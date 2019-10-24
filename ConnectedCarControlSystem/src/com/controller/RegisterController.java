package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.test.PrintLog;
import com.vo.Car;
import com.vo.CarGroup;
import com.vo.CarStatus;
import com.vo.User;

@Controller
public class RegisterController {

	@Resource(name = "UserBiz")
	Biz<String, User> userBiz;

	
	@Resource(name="CarBiz")
	Biz<String,Car> carBiz;
	
	@Resource(name="CarGroupBiz")
	Biz<String,CarGroup> carGroupBiz;
	
	@Resource(name="CarStatusBiz")
	Biz<String,CarStatus> carStatus;

	@RequestMapping("register.mc")
	public ModelAndView registerPage(ModelAndView mv) {
		mv.setViewName("register");

		return mv;
	}

	@RequestMapping("registerImpl.mc")
	public ModelAndView registerImpl(ModelAndView mv, User user) {
		PrintLog.printLog("registerImpl", user.toString());
		userBiz.insert(user);

		mv.setViewName("login");

		return mv;
	}

	@RequestMapping("checkId.mc")
	@ResponseBody
	public void checkId(String id, HttpServletResponse reponse) {
		PrintLog.printLog("checkId", id);
		User user = userBiz.select(id);

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
	// Start Register
	// Car---------------------------------------------------------------------

	@RequestMapping("neworshare.mc")
	public ModelAndView newOrShareSelectPage(ModelAndView mv) {
		mv.setViewName("neworshare");
		return mv;
	}

	@RequestMapping("registerSharecar.mc")
	public ModelAndView registerSharecarPage(ModelAndView mv) {
		mv.setViewName("registerSharecar");
		return mv;
	}

	@RequestMapping("registersharecarImpl.mc")
	public void registersharecarImpl(Car car, HttpSession session, HttpServletResponse response) {
		PrintLog.printLog("registercarshareImpl", car.toString());

		User user = (User) session.getAttribute("userInfo");
		CarGroup carGroup = new CarGroup(user.getUser_id(), car.getCar_id());

		carGroupBiz.insert(carGroup);

		try {
			response.sendRedirect("main.mc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("checkShareCarId.mc")
	@ResponseBody
	public void checkShareCarId(String id, String uuid, HttpServletResponse response) {
		Car car = carBiz.select(id);
		ArrayList<CarGroup> cargroup = carGroupBiz.selects(uuid);

		try {
			PrintWriter out = response.getWriter();

			for (CarGroup group : cargroup) {
				if(car==null) {
					out.write("Already");
				}
				if ((group.getCar_id().toString().equals(id))) {
					out.write("Exist");
					break;
				}else if(!(group.getCar_id().equals(id))) {
					out.write("OK");
					break;
				}
			}
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("registercar.mc")
	public ModelAndView registercarPage(ModelAndView mv) {
		mv.setViewName("registercar");
		return mv;
	}

	@RequestMapping("registercarImpl.mc")
	public void registercarImpl(Car car, HttpSession session, HttpServletResponse response) {
		PrintLog.printLog("registercarImpl", car.toString());
		carBiz.insert(car);

		User user = (User) session.getAttribute("userInfo");

		CarGroup carGroup = new CarGroup (user.getUser_id(), car.getCar_id());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		CarStatus carstatus = new CarStatus(car.getCar_id(),80,20000,700,120,100,26,17,200,150,50,15,80,Date.valueOf(sdf.format(new java.util.Date())),"0",123.1234f,36.5678f,100,100,100,100,100,0,30);

		carGroupBiz.insert(carGroup);

		try {
			response.sendRedirect("main.mc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("checkCarId.mc")
	@ResponseBody
	public void checkCarId(String id, HttpServletResponse response) {
		Car car = carBiz.select(id);

		try {
			PrintWriter out = response.getWriter();

			if (car == null) {
				out.write("OK");
			}

			else {
				out.write("Already");
			}

			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}