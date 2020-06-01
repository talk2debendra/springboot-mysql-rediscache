package com.codingvine.rediscache.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class ControllerMonitor {

	@Before("execution(public * com.codingvine.rediscache.controller.*Controller.*(..))")
	public void logBeforeAccess(JoinPoint joinPoint) {
		if (joinPoint != null) {
			String packageName = joinPoint.getSignature() != null ? joinPoint.getSignature().getDeclaringTypeName()
					: "";
			log.info(". . .A request initiated from controller [" + packageName + "." + getMethodSignature(joinPoint)
					+ "]. . .");
		}

	}

	@After("execution(public * com.codingvine.rediscache.controller.*Controller.*(..))")
	public void logAfterAccess(JoinPoint joinPoint) {
		if (joinPoint != null) {
			String packageName = joinPoint.getSignature() != null ? joinPoint.getSignature().getDeclaringTypeName()
					: "LOG-404";
			log.info(". . .Request from controller [" + packageName + "." + getMethodSignature(joinPoint)
					+ "] completed. . .");
		}
	}

	@AfterThrowing(pointcut = "execution(public * com.codingvine.rediscache.controller.*Controller.*(..))", throwing = "exception")
	public void logAfterThrowing(Exception exception) {
		log.error("Exception caught:" + exception.getMessage());
	}

	private String getMethodSignature(JoinPoint joinPoint) {
		if (joinPoint != null) {
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();
			StringBuilder sb = new StringBuilder();
			if (arguments != null) {
				for (Object param : arguments) {
					sb.append(param).append(",");
				}
				sb = (sb.length() > 1) ? sb.deleteCharAt(sb.length() - 1) : sb;
			}
			methodName = methodName + "(" + new String(sb) + ")";
			return methodName;
		} else {
			return "LOG-405";
		}
	}
}
