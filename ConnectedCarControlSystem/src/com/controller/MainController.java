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
public class MainController {
	@Resource(name = "CarBiz")
	Biz<String, Car> carBiz;
	
	@RequestMapping("main.mc")
	public ModelAndView mainPage(ModelAndView mv, HttpSession session, HttpServletResponse response) {
		mv.setViewName("index");
		
		User user = (User) session.getAttribute("userInfo");
		
		if (user != null) {
			PrintLog.printLog("[MainController]", user.toString());
			
			ArrayList<Car> cars = carBiz.selects(user.getUser_id());
			PrintLog.printLog("[MainController]", cars.toString());
		
			if(user.getUser_type().equals("1")) { //Admin
				ArrayList<Car> allcar = carBiz.selectAll();
				
				session.setAttribute("admincars", allcar);
				mv.addObject("center", "admincarlist");
				
			}
			
			else if(cars.size() > 0) {	//Normal Users
				session.setAttribute("carInfo", cars);
				mv.addObject("center", "carlist");
			}
			
			else {
				try {
					response.sendRedirect("neworshare.mc");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		}
		
		else {
			try {
				response.sendRedirect("login.mc");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		return mv;
	}
}
