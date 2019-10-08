package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("main.mc")
	public ModelAndView defaultMain(ModelAndView mv) {
		mv.setViewName("index");
		mv.addObject("center", "home");
		
		return mv;
	}
}
