package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.DeviceToken;
import com.vo.User;

@Controller
public class LoginController {
	@Resource(name="UserBiz")
	Biz<String, User> userBiz;
	
	@Resource(name = "DeviceTokenBiz")
	Biz<String,DeviceToken> deviceTokenBiz;
	
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
	public void loginImpl(HttpServletResponse response, HttpSession session, String id, String pwd, String token) {
		User user = userBiz.select(id);
		
		try {
			PrintWriter out = response.getWriter();
			
			if (user != null) {
				if (user.getUser_pwd().equals(pwd)) {
					session.setAttribute("userInfo", user);
					session.setMaxInactiveInterval(10000);
					
					if (!checkExistDeviceToken(id, token)) {
						deviceTokenBiz.insert(new DeviceToken(id, token));
					}
					
					//Log4j
					MDC.put("user_id", user.getUser_id().toString());
					MDC.put("user_name",user.getUser_name().toString());
					MDC.put("user_gender", user.getUser_gender().toString());
					System.out.println(user.getUser_birthdate());
					MDC.put("user_birthdate", user.getUser_birthdate().toString());
					
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
	
	public boolean checkExistDeviceToken(String user_id,String device_token) {
		ArrayList<DeviceToken> deviceTokenList = deviceTokenBiz.selects(user_id);
		
		for(DeviceToken deviceToken:deviceTokenList) {
			if(deviceToken.getDevice_token().equals(device_token)) return true;
		}
		
		return false;
	}
}
