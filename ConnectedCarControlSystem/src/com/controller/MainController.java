package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.PrintLog;
import com.vo.User;

@Controller
public class MainController {
	
	@RequestMapping("main.mc")
	public ModelAndView mainPage(ModelAndView mv, HttpSession session) {
		mv.setViewName("index");
		
		User user = (User) session.getAttribute("userInfo");
		PrintLog.printLog("[MainController]", user.toString());
		
		if (user != null) {
			
			mv.addObject("center", "home");
		}
		
		return mv;
	}
}
