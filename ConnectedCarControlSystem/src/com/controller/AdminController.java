package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PrintLog;
import com.vo.Car;
import com.vo.CarGroup;
import com.vo.CarStatus;
import com.vo.User;

@Controller
public class AdminController {
	@Resource(name = "CarBiz")
	Biz<String, Car> carBiz;

	@Resource(name = "UserBiz")
	Biz<String, User> userBiz;

	@Resource(name = "CarStatusBiz")
	Biz<String, CarStatus> carStatusBiz;

	@Resource(name = "CarGroupBiz")
	Biz<String, CarGroup> carGroupBiz;
	
	
	
	@RequestMapping("admincarlist.mc")
	public ModelAndView mainPage1(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		mv.setViewName("index");

		User user = (User) session.getAttribute("userInfo");

		if (user != null) {
			PrintLog.printLog("[MainController]", user.toString());

			ArrayList<Car> cars = carBiz.selects(user.getUser_id());
			PrintLog.printLog("[MainController]", cars.toString());

			ArrayList<CarStatus> allcarstatus = carStatusBiz.selectAll(); // selects all cars
			session.setAttribute("admincars", allcarstatus);
			
			mv.addObject("center", "admincarlist");

		}

		return mv;
	}

	@RequestMapping("adminuserlist.mc")
	public ModelAndView mainPage2(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		mv.setViewName("index");

		User user = (User) session.getAttribute("userInfo");

		if (user != null) {
			PrintLog.printLog("[MainController]", user.toString());

			ArrayList<Car> cars = carBiz.selects(user.getUser_id());
			PrintLog.printLog("[MainController]", cars.toString());

			ArrayList<User> alluser = userBiz.selectAll(); // selects all cars
			session.setAttribute("adminusers", alluser);

			mv.addObject("center", "adminuserlist");

		}

		return mv;
	}
	
	@RequestMapping("adminmakemarkers.mc")
	public void adminmakemarkers(HttpServletResponse response) {
		
		ArrayList<CarStatus> allcarstatus = carStatusBiz.selectAll();
		
		JSONArray ja = null;
		ja = new JSONArray();
		
		for(int i=0; i<allcarstatus.size(); i++) {
			JSONObject jo = new JSONObject();
			jo.put("car_id", allcarstatus.get(i).getCar_id());
			jo.put("car_lat", allcarstatus.get(i).getCar_lat());
			jo.put("car_log", allcarstatus.get(i).getCar_log());
			jo.put("car_ext_dust", allcarstatus.get(i).getCar_ext_dust());
			jo.put("car_ext_finedust", allcarstatus.get(i).getCar_ext_finedust());
			ja.add(jo);
		}
		
		
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(ja.toJSONString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
