package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DataController {

	@RequestMapping("selectcar.mc")
	@ResponseBody
	public void selectcar(HttpServletResponse response, HttpSession session, String id) {
		if (id != null) {
			session.setAttribute("selectcar", id);
			session.setMaxInactiveInterval(10000);
		} else {
		}
		try {
			response.sendRedirect("main.mc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
