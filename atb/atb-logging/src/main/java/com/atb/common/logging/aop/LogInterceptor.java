package com.atb.common.logging.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public interface LogInterceptor {
	
	/**
	 * Log.
	 *
	 * @param proceedingjoinpoint the proceedingjoinpoint
	 * @return the object
	 * @throws Throwable the throwable
	 */
	Object log(ProceedingJoinPoint proceedingjoinpoint) throws Throwable;
}
