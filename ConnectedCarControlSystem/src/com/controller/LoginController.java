package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("login.mc")
	public ModelAndView loginPage(ModelAndView mv) {
		mv.setViewName("login");
		
		return mv;
	}
	
	
}
