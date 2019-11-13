package com.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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

import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.socket.MainServer;
import com.socket.Receiver;
import com.socket.Sender;
import com.test.PrintLog;
import com.vo.CarConsumable;
import com.vo.CarGroup;
import com.vo.CarStatus;
import com.vo.CarStatusTestHive;
import com.vo.DeviceToken;

@Controller
public class DataController {
	// For Socket Test
	private MainServer mainServer;

	@Resource(name = "CarConsumableBiz")
	Biz<String, CarConsumable> carConsumableBiz;

	@Resource(name = "CarStatusBiz")
	Biz<String, CarStatus> carStatusBiz;

	@Resource(name = "CarGroupBiz")
	Biz<String, CarGroup> CarGroupBiz;

	@Resource(name = "CarGroupUserBiz")
	Biz<String, CarGroup> carGroupUserBiz;
	
	@Resource(name = "DeviceTokenBiz")
	Biz<String, DeviceToken> deviceTokenBiz;
	
	

	final String titleMSG = "CAUSE";
	final String bodyMSG = "you turn on light!!";

	final String HIVE_LAT_STRING = "car_lat";
	final String HIVE_lON_STRING = "car_log";
	
	public DataController() {
		mainServer = new MainServer();
		mainServer.start();
    
		Runnable sendAreaListRunnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					getDangerAreaFromHive();
					try {
						Thread.sleep(1000 * 10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(sendAreaListRunnable).start();
	}
	
	public void getDangerAreaFromHive( ) {
		String DangerAreaString = "DangerArea";
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection conn = DriverManager.getConnection("jdbc:hive2://70.12.60.103:10000/default", "hive_db",
					"111111");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM travel01");
      
			while (rs.next()) {
				DangerAreaString += "/"+rs.getString("travel01."+HIVE_LAT_STRING)+",";
				DangerAreaString += rs.getString("travel01."+HIVE_lON_STRING);
			}

			conn.close();
			System.out.println("Success....");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
		String[] KeySet = mainServer.getSocketMap().keySet().toArray(new String[mainServer.getSocketMap().keySet().size()]);
		Receiver tempReceiver;
		Sender sender;
    
		for(int i=0;i<KeySet.length;i++) {
			tempReceiver = mainServer.getSocketMap().get(KeySet[i]);
			sender = new Sender(tempReceiver.getSocket());
			sender.setMsg(DangerAreaString);
			sender.run();
		}
	}
	
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
	
	@RequestMapping("deletecar.mc")
	public void deletecar(HttpServletResponse response, HttpSession session, String id) {
		if (id != null) {
			CarGroup carGroup = null;
			
			
			session.setMaxInactiveInterval(10000);
		}

		try {
			response.sendRedirect("main.mc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("getDrivingRecordFromHive.mc")
	@ResponseBody
	public void getDrivingRecordFromHive(String car_id, String date, HttpServletResponse response) {
		PrintWriter out = null;
		
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection conn = DriverManager.getConnection("jdbc:hive2://70.12.60.103:10000/default", "root", "111111");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT car_driving_count, MAX(car_fuel) AS fuel_max, MIN(car_fuel) AS fuel_min, MAX(car_hms) AS hms_max , MIN(car_hms) AS hms_min, AVG(car_speed) AS speed, MAX(car_distance) AS distance FROM travel01 WHERE car_id='" + car_id + "' AND car_date='" + date + "' GROUP BY car_driving_count");

			JSONArray ja = new JSONArray();
			
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				
				int fuelSpent = rs.getInt("fuel_max") - rs.getInt("fuel_min");
				float speedAvg = rs.getInt("speed");
				float distance = rs.getFloat("distance");
				String hms = rs.getString("hms_min") + " ~ " + rs.getString("hms_max");
				String timeSpent = getTimeSpent(rs.getString("hms_max"), rs.getString("hms_min")); 
				
				jo.put("fuelSpent", fuelSpent);
				jo.put("speedAvg", speedAvg);
				jo.put("distance", distance);
				jo.put("hms", hms);
				jo.put("timeSpent", timeSpent);
				
				PrintLog.printLog("getDrivingRecordFromHive", jo.toJSONString());
				
				ja.put(jo);
			}

			conn.close();
			PrintLog.printLog("getDrivingRecordFromHive", "Hive Success...");

			out = response.getWriter();
			out.write(ja.toString());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public String getTimeSpent(String timeMax, String timeMin) {
		String[] timeMaxs = timeMax.split(":");
		String[] timeMins = timeMin.split(":");
		
		int second = Integer.parseInt(timeMaxs[2]) - Integer.parseInt(timeMins[2]);
		int upSecond = 0;
		
		if (second < 0) {
			second += 60;
			upSecond = -1;
		}
		
		int minute = Integer.parseInt(timeMaxs[1]) - Integer.parseInt(timeMins[1]) + upSecond;
		int upMinute = 0;
		
		if (minute < 0) {
			minute += 60;
			upMinute = -1;
		}
		
		int hour = Integer.parseInt(timeMaxs[0]) - Integer.parseInt(timeMins[0]) + upMinute;
		
		String spentTime = String.format("%02d:%02d:%02d", hour, minute, second);
		
		return spentTime;
	}
	
	@RequestMapping("getDataFromHive.mc")
	public ModelAndView getDataFromHive(ModelAndView mv) {
		ArrayList<CarStatusTestHive> carStatus = new ArrayList<CarStatusTestHive>();

		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection conn = DriverManager.getConnection("jdbc:hive2://70.12.60.103:10000/default", "hive_db",
					"111111");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM travel01");

			while (rs.next()) {
				System.out.println(rs.getDate("test_hive.car_date"));
				System.out.println(rs.getString("test_hive.car_id"));

				carStatus.add(new CarStatusTestHive(rs.getDate("test_hive.car_date"), rs.getString("test_hive.car_id")));
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
				carStatus = new CarStatus(
						jo.get("car_id").toString(),
						jo.get("car_on").toString(),
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
						Integer.parseInt(jo.get("car_brake_pressure").toString()),
						carStatusBiz.select(jo.get("car_id").toString()).getCar_driving_count());
				
				MDC.put("car_id", jo.get("car_id").toString());
				MDC.put("car_on", jo.get("car_on").toString());
				MDC.put("car_speed", jo.get("car_speed").toString());
				MDC.put("car_distance", jo.get("car_distance").toString());
				MDC.put("car_air", jo.get("car_air").toString());
				MDC.put("car_dust", jo.get("car_dust").toString());
				MDC.put("car_finedust", jo.get("car_finedust").toString());
				MDC.put("car_temp", jo.get("car_temp").toString());
				MDC.put("car_ext_temperature", jo.get("car_ext_temperature").toString());
				MDC.put("car_ext_dust", jo.get("car_ext_dust").toString());
				MDC.put("car_ext_finedust", jo.get("car_ext_finedust").toString());
				MDC.put("car_humidity", jo.get("car_humidity").toString());
				MDC.put("car_fuel", jo.get("car_fuel").toString());
				MDC.put("car_bat", jo.get("car_bat").toString());
				MDC.put("car_date", jo.get("car_date").toString());
				MDC.put("car_hms", jo.get("car_hms").toString());
				MDC.put("car_lat", jo.get("car_lat").toString());
				MDC.put("car_log", jo.get("car_log").toString());
				MDC.put("car_filter", jo.get("car_filter").toString());
				MDC.put("car_eng_oil", jo.get("car_eng_oil").toString());
				MDC.put("car_brakeoil", jo.get("car_brakeoil").toString());
				MDC.put("car_accoil", jo.get("car_accoil").toString());
				MDC.put("car_coolwat", jo.get("car_coolwat").toString());
				MDC.put("car_accel_pressure", jo.get("car_accel_pressure").toString());
				MDC.put("car_brake_pressure", jo.get("car_brake_pressure").toString());
				MDC.put("car_driving_count", carStatusBiz.select(jo.get("car_id").toString()).getCar_driving_count());
				
				MDC.put("car_fuel_spent", Integer.parseInt(jo.get("car_fuel").toString())-carStatusBiz.select(jo.get("car_id").toString()).getCar_fuel());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if("off".equals(jo.get("car_on").toString()) && "1".equals(jo.get("car_light_on"))) {
			makeFCMEnvironment(jo.get("car_id").toString());
		}

		if (carStatus != null) {
			if (carStatusBiz.select(carStatus.getCar_id()) != null) {
				//시동 꺼지면  count ++;
        
				if(carStatusBiz.select(carStatus.getCar_id()).getCar_on().equals("on") && carStatus.getCar_on().equals("off")) {
					carStatus.setCar_driving_count(carStatus.getCar_driving_count() + 1);
				}
				
				if(!carStatusBiz.select(carStatus.getCar_id()).getCar_date().toString().equals(carStatus.getCar_date().toString()) ) {
					carStatus.setCar_driving_count(0);
				}
        
				carStatusBiz.update(carStatus);
			}
			
			else {
				carStatus.setCar_driving_count(0);
				carStatusBiz.insert(carStatus);
			}
		}
	}

	public void makeFCMEnvironment(String car_id) {
		ArrayList<CarGroup> carGroups =	carGroupUserBiz.selects(car_id);
		
		for (CarGroup carGroup : carGroups) {
			if (carGroup.getCar_id().equals(car_id)) {
				System.out.println(carGroup.getCar_id());
				searchTokenId(carGroup.getUser_id());
			}
		}
	}

	public void searchTokenId(String User_id) {
		ArrayList<DeviceToken> deviceTokens = deviceTokenBiz.selects(User_id);
		
		for (DeviceToken deviceToken : deviceTokens) {
			sendFCMMsg(deviceToken.getDevice_token(), titleMSG, bodyMSG);
		}
	}

	public void sendFCMMsg(String tokenId, String title, String context) {
		try {
			FileInputStream refreshToken = new FileInputStream(
					"C:\\Users\\student\\Desktop\\GongJo\\ConnectedCarControlSystem\\resource\\gongjo-93a9f-firebase-adminsdk-qwyxy-674f31e157.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(refreshToken))
					.setDatabaseUrl("https://gongjo-93a9f.firebaseio.com").build();
			
			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options); 
			}
			
			String registrationToken = tokenId;

			Message msg = Message.builder()
					.setAndroidConfig(AndroidConfig.builder().setTtl(1000).setPriority(AndroidConfig.Priority.NORMAL)
							.setNotification(AndroidNotification.builder().setTitle(title).setBody(context).build())
							.build())
//					.putData("title", title)
//					.putData("body", context)
					.setToken(registrationToken).build();

			String response = FirebaseMessaging.getInstance().send(msg);
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
			
			jo.put("car_date", carStatus.getCar_date().toString());
			jo.put("car_hms", carStatus.getCar_hms());
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

	@RequestMapping("getDrivingRecordData.mc")
	public ModelAndView getDrivingRecordData(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		mv.setViewName("index");
    
    CarStatus carStatus = null;
		String car_id = (String) session.getAttribute("selectcar");
		
		if (car_id != null && !car_id.equals("")) {
			mv.addObject("center", "drivingRecordList");
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

	@RequestMapping("getRealTimeDrivingData.mc")
	public ModelAndView getRealTimeDrivingData(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		mv.setViewName("index");
		
		CarStatus carStatus = null;
		String car_id = (String) session.getAttribute("selectcar");
		
		if (car_id != null && !car_id.equals("")) {
			mv.addObject("center", "realTimeDriving");
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
	@ResponseBody
	public void getRealTimedata(String car_id, HttpSession session, HttpServletResponse reponse) {
		CarStatus carStatus = null;
		carStatus = carStatusBiz.select(car_id);
		
		JSONObject jo = new JSONObject();
		
		jo.put("on", carStatus.getCar_on());
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
		jo.put("date", carStatus.getCar_date().toString());
		jo.put("hms", carStatus.getCar_hms());
		
		try {
			PrintWriter out = reponse.getWriter();
			out.write(jo.toJSONString());
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("sendControlCmd.mc")
	@ResponseBody
	public void controlCmd(String car_id, String type, String value, HttpServletResponse response) {
		String responseMsg = "";
		
		if (mainServer.getSocketMap().containsKey(car_id)) {
			String id = "";
			String data = "";
			
			if (type.equals("on")) {
				id = "00000000";
				data = "00000000" + "00000001";
			}
			
			else if (type.equals("off")) {
				id = "00000000";
				data = "00000000" + "00000000";
			}
			
			else if (type.equals("air")) {
				String changedValue = String.format("%03d",Integer.parseInt(value) + 40);
				
				id = "00020040";
				data = "00000000" + "00000" + changedValue;
			}
			
			String msg = "W28" + id + data;
			Socket targetSocket = mainServer.getSocketMap().get(car_id).getSocket();
			
			Sender sender = new Sender(targetSocket);
			sender.setMsg(msg);
			sender.start();
			
			responseMsg = "OKSocket";
		}
		
		else {
			responseMsg = "NoSocket";
		}
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			out.write(responseMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
  
	@RequestMapping("drawgraph.mc")
	public ModelAndView drawgraph(ModelAndView mv, HttpServletResponse response) {
		ArrayList<CarStatusTestHive> carStatus = new ArrayList<CarStatusTestHive>();
		org.json.simple.JSONArray graph1 = new org.json.simple.JSONArray();

		JSONObject data = new JSONObject();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection conn = DriverManager.getConnection("jdbc:hive2://70.12.60.103:10000/default","root" ,"111111");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT travel01.car_id, max(travel01.car_distance) as distance from travel01 group by travel01.car_id order by distance desc limit 10 ");
//			"SELECT max(travel01.car_distance) as distance, travel01.car_id from travel01 where travel01.car_on = 'on' group by travel01.car_id"
		
			
			while (rs.next()) {
				
				data = new JSONObject();
				
					data.put("name", rs.getString("travel01.car_id"));
					data.put("y", rs.getInt("distance"));
				
				System.out.println(data.get("name"));
				System.out.println(data.get("y"));
				
				graph1.add(data);
			}	
			conn.close();
			System.out.println("Success....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(graph1.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		
		mv.setViewName("index");
		mv.addObject("center", "charts");
		
		

		return mv;
	}
}
