package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PringLog;
import com.vo.User;

@Controller
public class RegisterController {

	@Autowired
	@Qualifier("userBiz")
	Biz<String, User> userBiz;
	
	@RequestMapping("register.mc")
	public ModelAndView registerPage(ModelAndView mv) {
		mv.setViewName("register");
		
		return mv;
	}
	
	@RequestMapping("registerImpl.mc")
	public void registerImpl() {
		User user = userBiz.select("id01");
		PringLog.pringLog("registerImpl", user.toString());
	}
}
