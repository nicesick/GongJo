package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PrintLog;
import com.vo.Car;
import com.vo.User;

@Controller
public class MainController {
	@Resource(name = "CarBiz")
	Biz<String, Car> carBiz;
	
	@RequestMapping("main.mc")
	public ModelAndView mainPage(ModelAndView mv, HttpSession session) {
		mv.setViewName("index");
		
		User user = (User) session.getAttribute("userInfo");
		PrintLog.printLog("[MainController]", user.toString());
		
		if (user != null) {
			ArrayList<Car> cars = carBiz.selects(user.getUser_id());
			PrintLog.printLog("[MainController]", cars.toString());
			
			if(cars.size() > 0) {
				mv.addObject("carInfo", cars);
				mv.addObject("center", "carlist");
			}
			
			else {
				mv.addObject("center", "home");
			}
			
		}
		
		return mv;
	}
}
