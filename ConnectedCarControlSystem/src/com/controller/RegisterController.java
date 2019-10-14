package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PrintLog;
import com.vo.User;

@Controller
public class RegisterController {

	@Resource(name="UserBiz")
	Biz<String, User> userBiz;
	
	@RequestMapping("register.mc")
	public ModelAndView registerPage(ModelAndView mv) {
		mv.setViewName("register");
		
		return mv;
	}
	
	@RequestMapping("registerImpl.mc")
	public void registerImpl() {
		User user = userBiz.select("id01");
		PrintLog.printLog("registerImpl", user.toString());
	}
	
	@RequestMapping("checkId.mc")
	@ResponseBody
	public void checkId(String id, HttpServletResponse reponse) {
		User user = userBiz.select(id);
		
		PrintLog.printLog("checkId", "get User");
		
		try {
			PrintWriter out = reponse.getWriter();
			
			if (user == null) {
				out.write("OK");
			}
			
			else {
				out.write("Already");
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
