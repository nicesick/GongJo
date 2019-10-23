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
import com.socket.MainServer;
import com.vo.User;

@Controller
public class LoginController {
	// For Socket Test
	private MainServer mainServer;
	
	@Resource(name="UserBiz")
	Biz<String, User> userBiz;
	
	// Initialize MainServer
	public LoginController() {
		mainServer = new MainServer();
		mainServer.start();
	}
	
	@RequestMapping("logout.mc")
	public void logout(HttpSession session, HttpServletResponse response) {
		if (session != null) {
			session.invalidate();
		}
		
		try {
			response.sendRedirect("login.mc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("login.mc")
	public ModelAndView loginPage(ModelAndView mv, HttpServletResponse response, HttpSession session) {
		User user = (User)session.getAttribute("userInfo");
		
		if (user != null) {
			try {
				response.sendRedirect("main.mc");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
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
					session.setMaxInactiveInterval(10000);
					
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
