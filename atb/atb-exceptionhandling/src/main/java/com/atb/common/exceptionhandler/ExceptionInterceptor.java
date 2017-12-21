package com.atb.common.exceptionhandler;

import java.util.Properties;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.ThrowsAdvice;

import com.atb.common.exception.ATBException;
import com.atb.common.logging.Logger;
import com.atb.common.logging.event.ExceptionLogEvent;

/**
 * The Class ExceptionInterceptor.
 */
public class ExceptionInterceptor implements ThrowsAdvice {

	/** The logger. */
	private Logger logger;
	private Properties exceptionProperties;
	
	/**
	 * The Constructor.
	 */
	public ExceptionInterceptor() {

	}

	/**
	 * After throwing.
	 * 
	 * @param joinPoint
	 *            the join point
	 * @param exception
	 *            the exception
	 * @throws Exception
	 *             the exception
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception exception)
			throws Exception {

		int errorCode;
		String errorMsg = "";
		boolean isGeneralException = false;
		logException(joinPoint, exception);
		if (exception instanceof ATBException) {
			errorCode = ((ATBException) exception).getErrorCode();
			errorMsg = exceptionProperties.getProperty(String
					.valueOf(((ATBException) exception)
							.getErrorCode()));
		} else {
			errorCode = 1500;
			errorMsg = "Internal Server Error";
			isGeneralException = true;
		}
		
		if (isGeneralException) {
			ATBException gtmtException = new ATBException(
					errorMsg);
			gtmtException.setErrorCode(errorCode);
			exception = gtmtException;
		} else {
			ATBException gtmtException = new ATBException(
					errorMsg);
			gtmtException.setErrorCode(errorCode);
			exception = gtmtException;
		}
		
		logException(joinPoint, exception);
		throw exception;
	}

	/**
	 * Log exception.
	 * 
	 * @param joinPoint
	 *            the join point
	 * @param exception
	 *            the exception
	 */
	private void logException(JoinPoint joinPoint, Exception exception) {

		if (logger != null) {
			ExceptionLogEvent event = new ExceptionLogEvent(joinPoint,
					exception);
			logger.log(event);
		}
	}

	/**
	 * Gets the logger.
	 * 
	 * @return the logger
	 */
	public Logger getLogger() {

		return logger;
	}

	/**
	 * Sets the logger.
	 * 
	 * @param logger
	 *            the logger
	 */
	public void setLogger(Logger logger) {

		this.logger = logger;
	}

	/**
	 * @return the exceptionProperties
	 */
	public Properties getExceptionProperties() {
		return exceptionProperties;
	}

	/**
	 * @param exceptionProperties the exceptionProperties to set
	 */
	public void setExceptionProperties(Properties exceptionProperties) {
		this.exceptionProperties = exceptionProperties;
	}
}