package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PrintLog;
import com.vo.Car;
import com.vo.User;

@Controller
public class AdminController {
	@Resource(name = "CarBiz")
	Biz<String, Car> carBiz;
	
	@Resource(name = "UserBiz")
	Biz<String, User> userBiz;
	
	@RequestMapping("admincarlist.mc")
	public ModelAndView mainPage1(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		mv.setViewName("index");
		
		User user = (User) session.getAttribute("userInfo");
	
		if (user != null) {
			PrintLog.printLog("[MainController]", user.toString());
			
			ArrayList<Car> cars = carBiz.selects(user.getUser_id());
			PrintLog.printLog("[MainController]", cars.toString());

				ArrayList<Car> allcar = carBiz.selectAll();		//selects all cars
				session.setAttribute("admincars", allcar);
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

				ArrayList<User> alluser = userBiz.selectAll();		//selects all cars
				session.setAttribute("adminusers", alluser);
				mv.addObject("center", "adminuserlist");
				
			}

		return mv;
	}
}
