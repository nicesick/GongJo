package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PrintLog;
import com.vo.CarConsumable;
import com.vo.CarStatus;
import com.vo.CarStatusTestHive;

@Controller
public class DataController {
	fcmController fcmUtil;
	@Resource(name = "CarConsumableBiz")
	Biz<String, CarConsumable> carConsumableBiz;

	@Resource(name = "CarStatusBiz")
	Biz<String, CarStatus> carStatusBiz;

	@RequestMapping("selectcar.mc")
	public void selectcar(HttpServletResponse response, HttpSession session, String id) {
		if (id != null) {
			session.setAttribute("selectcar", id);
			session.setMaxInactiveInterval(10000);
		}

		try {
			response.sendRedirect("main.mc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("getDataFromHive.mc")
	public ModelAndView getDataFromHive(ModelAndView mv) {
		ArrayList<CarStatusTestHive> carStatus = new ArrayList<CarStatusTestHive>();

		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection conn = DriverManager.getConnection("jdbc:hive2://70.12.60.103:10000/default", "hive_db",
					"111111");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM test_hive");

			while (rs.next()) {
				System.out.println(rs.getDate("test_hive.car_date"));
				System.out.println(rs.getString("test_hive.car_id"));

				carStatus
						.add(new CarStatusTestHive(rs.getDate("test_hive.car_date"), rs.getString("test_hive.car_id")));
			}

			conn.close();
			System.out.println("Success....");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		mv.setViewName("index");
		mv.addObject("center", "testHive");
		mv.addObject("hiveInfo", carStatus);

		return mv;
	}

	@RequestMapping(value = "sendData.mc", method = RequestMethod.POST)
	public void getDataFromPad(HttpServletRequest request) {
		InputStream in = null;
		String data = "";

		try {
			in = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			
			data = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		PrintLog.printLog("DataController", data);
		CarStatus carStatus = null;
		
		JSONParser parser = new JSONParser();
		JSONObject jo = null;
		
		try {
			jo = (JSONObject) parser.parse(data);
			
			if (jo != null && !jo.isEmpty()) {
				carStatus = new CarStatus(jo.get("car_id").toString(), 
						Integer.parseInt(jo.get("car_speed").toString()), 
						Integer.parseInt(jo.get("car_distance").toString()),
						Integer.parseInt(jo.get("car_air").toString()),
						Integer.parseInt(jo.get("car_dust").toString()),
						Integer.parseInt(jo.get("car_finedust").toString()),
						Integer.parseInt(jo.get("car_temp").toString()),
						Integer.parseInt(jo.get("car_ext_temperature").toString()),
						Integer.parseInt(jo.get("car_ext_dust").toString()),
						Integer.parseInt(jo.get("car_ext_finedust").toString()),
						Integer.parseInt(jo.get("car_humidity").toString()),
						Integer.parseInt(jo.get("car_fuel").toString()),
						Integer.parseInt(jo.get("car_bat").toString()),
						Date.valueOf(jo.get("car_date").toString()),
						jo.get("car_hms").toString(),
						Float.parseFloat(jo.get("car_lat").toString()),
						Float.parseFloat(jo.get("car_log").toString()),
						Integer.parseInt(jo.get("car_filter").toString()),
						Integer.parseInt(jo.get("car_eng_oil").toString()),
						Integer.parseInt(jo.get("car_brakeoil").toString()),
						Integer.parseInt(jo.get("car_accoil").toString()),
						Integer.parseInt(jo.get("car_coolwat").toString()),
						Integer.parseInt(jo.get("car_accel_pressure").toString()),
						Integer.parseInt(jo.get("car_brake_pressure").toString()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if("0".equals(jo.get("car_start_up").toString()) && "1".equals(jo.get("car_light_on"))) {
			System.out.println("danger");
			fcmUtil = new fcmController();
			fcmUtil.makeFCMEnvironment(jo.get("car_id").toString());
		}
		if (carStatus != null) {
			if (carStatusBiz.select(carStatus.getCar_id()) != null) {
				carStatusBiz.update(carStatus);
			}
			
			else {
				carStatusBiz.insert(carStatus);
			}
		}
	}

	// �냼紐⑦뭹 �젙蹂� �솗�씤
	@RequestMapping("getConsumableData.mc")
	public ModelAndView getConsumableData(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		CarConsumable carConsumable = null;
		CarStatus carStatus = null;

		String car_id = (String) session.getAttribute("selectcar");
		mv.setViewName("index");

		if (car_id != null && !car_id.equals("")) {
			carConsumable = carConsumableBiz.select(car_id);
			carStatus = carStatusBiz.select(car_id);

			if (carConsumable != null && carStatus != null) {
				PrintLog.printLog("DataController", carConsumable.toString());
				PrintLog.printLog("DataController", carStatus.toString());

				mv.addObject("center", "carConsumableList");
				mv.addObject("carConsumable", carConsumable);
				mv.addObject("carStatus", carStatus);
			}

			else {
				try {
					response.sendRedirect("main.mc");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		}

		else {
			try {
				response.sendRedirect("main.mc");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		return mv;
	}
	
	//�냼紐⑦뭹 �떎�떆媛� �솗�씤
	@RequestMapping("getRealTimeConsumable.mc")
	@ResponseBody
	public void getRealTimeConsumable(String car_id, HttpSession session, HttpServletResponse response) {
		PrintWriter out = null;
		
		CarConsumable carConsumable = null;
		CarStatus carStatus = null;
		
		carConsumable = carConsumableBiz.select(car_id);
		carStatus = carStatusBiz.select(car_id);
		
		if (carConsumable != null && carStatus != null) {
			PrintLog.printLog("getRealTimeConsumable", carConsumable.toString());
			PrintLog.printLog("getRealTimeConsumable", carStatus.toString());
			
			JSONObject jo = new JSONObject();
			
			jo.put("car_filter", carStatus.getCar_filter());
			jo.put("car_eng_oil", carStatus.getCar_eng_oil());
			jo.put("car_brakeoil", carStatus.getCar_brakeoil());
			jo.put("car_accoil", carStatus.getCar_accoil());
			jo.put("car_coolwat", carStatus.getCar_coolwat());

			jo.put("date_filter", carConsumable.getDate_filter().toString());
			jo.put("date_eng_oil", carConsumable.getDate_eng_oil().toString());
			jo.put("date_breakoil", carConsumable.getDate_breakoil().toString());
			jo.put("date_accoil", carConsumable.getDate_accoil().toString());
			jo.put("date_coolwat", carConsumable.getDate_coolwat().toString());
			
			try {
				out = response.getWriter();
				out.write(jo.toJSONString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (out != null) {
				out.close();
			}
		}
	}

	// �슫�뻾湲곕줉 �솗�씤
	@RequestMapping("getDrivingRecordData.mc")
	public ModelAndView getDrivingRecordData(ModelAndView mv) {
		mv.setViewName("index");
		mv.addObject("center", "drivingRecordList");

		return mv;
	}

	// �떎�떆媛� �긽�깭 �솗�씤

	@RequestMapping("getRealTimeDrivingData.mc")
	public ModelAndView getRealTimeDrivingData(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		mv.setViewName("index");
		
		CarStatus carStatus = null;
		String car_id = (String) session.getAttribute("selectcar");
		
		if (car_id != null && !car_id.equals("")) {
			carStatus = carStatusBiz.select(car_id);
			
			if (carStatus != null) {
				mv.addObject("carStatus", carStatus);
				mv.addObject("center", "realTimeDriving");
			}
			
			else {
				try {
					response.sendRedirect("main.mc");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return null;
			}
		}
		
		else {
			try {
				response.sendRedirect("main.mc");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}

		return mv;
	}
	
	@RequestMapping("getRealTimeData.mc")
	public void getRealTimedata(String car_id, HttpSession session, HttpServletResponse reponse) {
		CarStatus carStatus = null;
		carStatus = carStatusBiz.select(car_id);
		
		JSONObject jo = new JSONObject();
		
		jo.put("speed", carStatus.getCar_speed());
		jo.put("distance", carStatus.getCar_distance());
		jo.put("air", carStatus.getCar_air());
		jo.put("dust", carStatus.getCar_dust());
		jo.put("finedust", carStatus.getCar_finedust());
		jo.put("temp", carStatus.getCar_temp());
		jo.put("humidity", carStatus.getCar_humidity());
		jo.put("ext_dust", carStatus.getCar_ext_dust());
		jo.put("ext_finedust", carStatus.getCar_ext_finedust());
		jo.put("ext_temperature", carStatus.getCar_ext_temperature());
		jo.put("fuel", carStatus.getCar_fuel());
		jo.put("bat", carStatus.getCar_bat());
		jo.put("lat", carStatus.getCar_lat());
		jo.put("log", carStatus.getCar_log());
		
		try {
			PrintWriter out = reponse.getWriter();
			out.write(jo.toJSONString());
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
