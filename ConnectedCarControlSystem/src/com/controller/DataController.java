package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataController {
	
	@RequestMapping("selectcar.mc")
	public void selectcar(HttpServletResponse response, HttpSession session, String id) {
		if (id != null) {
			session.setAttribute("selectcar", id);
			session.setMaxInactiveInterval(10000);
		}
		
		try {
			response.sendRedirect("main.mc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/sendData.mc",method= RequestMethod.POST)
	public void getData(HttpServletRequest request) {
		InputStream in = null;
		String data = "";
		
		try {
			in = request.getInputStream();
			BufferedInputStream bin = new BufferedInputStream(in);
			StringBuilder sb = new StringBuilder();
			
            while (bin.available() > 0) {
                sb.append((char) bin.read());
            }
            
            data = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(data);
	}
}
