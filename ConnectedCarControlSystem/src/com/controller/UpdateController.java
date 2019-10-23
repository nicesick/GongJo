package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PrintLog;
import com.vo.User;

@Controller
public class UpdateController {

	@Resource(name="UserBiz")
	Biz<String, User> userBiz;
	
	@RequestMapping("editmyinfo.mc")
	public ModelAndView registerPage(ModelAndView mv) {
		mv.setViewName("editmyinfo");
		
		return mv;
	}
	
	@RequestMapping("editmyinfoImpl.mc")
	public void registercarImpl(User user, HttpSession session, HttpServletResponse response) {
		PrintLog.printLog("editmyinfo", user.toString());
		userBiz.update(user);		
		try {
			response.sendRedirect("main.mc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
