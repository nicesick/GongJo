package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import com.test.PrintLog;
import com.vo.CarStatusTestHive;
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
	
	@RequestMapping("getDataFromHive.mc")
	public ModelAndView getDataFromHive(ModelAndView mv) {
		ArrayList<CarStatusTestHive> carStatus = new ArrayList<CarStatusTestHive>();
		
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection conn = DriverManager.getConnection("jdbc:hive2://70.12.60.103:10000/default", "", "");
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM test_hive");
	        
	        while (rs.next()) {
	            System.out.println(rs.getDate("test_hive.car_date"));
	            System.out.println(rs.getString("test_hive.car_id"));
	            
	            carStatus.add(new CarStatusTestHive(rs.getDate("test_hive.car_date"), rs.getString("test_hive.car_id")));
	        }

	        conn.close();
	        System.out.println("Success....");
	        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mv.setViewName("index");
		mv.addObject("center", "testHive");
		mv.addObject("hiveInfo", carStatus);
		
		return mv;
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
