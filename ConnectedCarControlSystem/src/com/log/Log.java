package com.log;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.test.PrintLog;

@Service
@Aspect
public class Log {
	private Logger status_log;
	private Logger warning_log;
	
	public Log() {
		status_log = Logger.getLogger("status");
		warning_log = Logger.getLogger("warning");
	}
	
	@Before("execution(* com.controller.DataController.getData(..))")
	public void makeLog(JoinPoint jp) {
		PrintLog.printLog("Log", jp.getArgs()[0].toString() + "");
		String car_id = jp.getArgs()[0].toString();
		
		MDC.put("car_id", car_id);
		status_log.debug(jp.getSignature().getName());
	}
}
