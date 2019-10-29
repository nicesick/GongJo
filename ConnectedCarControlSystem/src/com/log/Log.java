package com.log;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class Log {
	private static final int PRESSURE_STANDARD = 50;
	
	private Logger status_log;
	private Logger warning_log;
	private Logger user_log;
	
	public Log() {
		status_log = Logger.getLogger("status");
		warning_log = Logger.getLogger("warning");
		user_log=Logger.getLogger("user");
	}
	
	@After("execution(* com.controller.DataController.getData(..))")
	public void makeLog(JoinPoint jp) {
		int car_accel_pressure = Integer.parseInt(MDC.get("car_accel_pressure").toString());
		int car_brake_pressure = Integer.parseInt(MDC.get("car_brake_pressure").toString());
		
		if (car_accel_pressure > PRESSURE_STANDARD || car_brake_pressure > PRESSURE_STANDARD) {
			warning_log.debug(jp.getSignature().getName());
		}
		status_log.debug(jp.getSignature().getName());
		
	}
	
	@After("execution(* com.controller.LoginController.loginImpl(..))")
	public void makeUserLog(JoinPoint jp) {
		

		String user_id = MDC.get("user_id").toString();
		String user_birthday = MDC.get("user_birthdate").toString();
		
		if(user_id != null) {
			user_log.debug(jp.getSignature().getName());
		}else {
			warning_log.debug(jp.getSignature().getName());
		}


	}
}
