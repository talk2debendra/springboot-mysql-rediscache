package com.codingvine.rediscache.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class ServiceMonitor {

	@Before("execution(public * com.codingvine.rediscache.service.impl.*ServiceImpl.*(..))")
	public void logBeforeAccess(JoinPoint joinPoint) {
		if (joinPoint != null) {
			String packageName = joinPoint.getSignature() != null ? joinPoint.getSignature().getDeclaringTypeName()
					: "LOG-404";
			log.info(". . .Service [" + packageName + "." + getMethodSignature(joinPoint) + " initiated . . .]");

		}
	}

	@After("execution(public * com.codingvine.rediscache.service.impl.*ServiceImpl.*(..))")
	public void logAfterAccess(JoinPoint joinPoint) {
		if (joinPoint != null) {
			String packageName = joinPoint.getSignature() != null ? joinPoint.getSignature().getDeclaringTypeName()
					: "LOG-404";
			log.info(". . .Service [" + packageName + "." + getMethodSignature(joinPoint) + " completed . . .]");
		}
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
