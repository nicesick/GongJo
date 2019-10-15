package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.User;

@Controller
public class LoginController {
	@Resource(name="UserBiz")
	Biz<String, User> userBiz;
	
	@RequestMapping("login.mc")
	public ModelAndView loginPage(ModelAndView mv) {
		mv.setViewName("login");
		
		return mv;
	}
	
	@RequestMapping("loginImpl.mc")
	@ResponseBody
	public void loginImpl(HttpServletResponse response, HttpSession session, String id, String pwd) {
		User user = userBiz.select(id);
		
		try {
			PrintWriter out = response.getWriter();
			
			if (user != null) {
				if (user.getUser_pwd().equals(pwd)) {
					session.setAttribute("userInfo", user);
					
					out.print("LoginSuccess");
				}
				
				else {
					out.print("LoginFail");
				}
			}
			
			else {
				out.print("LoginFail");
			}
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
