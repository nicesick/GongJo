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
	
	public Log() {
		status_log = Logger.getLogger("status");
		warning_log = Logger.getLogger("warning");
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
}
