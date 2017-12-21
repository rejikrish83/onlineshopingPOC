package com.atb.common.logging.event;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.SoftException;

public class ExceptionLogEvent extends CallLogEvent {

	private static final long serialVersionUID = 1L;

	/** The exception. */
	private final Throwable exception;
	
	/** The severity level. */
	private String severityLevel;
	
	/** The response code. */
	private String responseCode;
	
	/** The response message. */
	private String responseMessage;

	/**
	 * The Constructor.
	 *
	 * @param joinPoint the join point
	 * @param exception the exception
	 * @param severityLevel the severity level
	 * @param responseCode the response code
	 * @param responseMessage the response message
	 */
	public ExceptionLogEvent(JoinPoint joinPoint, Throwable exception,
			String severityLevel, String responseCode, String responseMessage) {
		super(joinPoint);
		this.severityLevel = null;
		this.exception = exception;
		this.severityLevel = severityLevel;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	/**
	 * The Constructor.
	 *
	 * @param className the class name
	 * @param methodName the method name
	 * @param arguments the arguments
	 * @param exception the exception
	 * @param severityLevel the severity level
	 */
	public ExceptionLogEvent(String className, String methodName,
			Object[] arguments, Throwable exception, String severityLevel) {
		super(className, methodName, arguments);
		this.severityLevel = null;
		this.exception = exception;
		this.severityLevel = severityLevel;
	}

	/**
	 * The Constructor.
	 *
	 * @param joinPoint the join point
	 * @param exception the exception
	 */
	public ExceptionLogEvent(JoinPoint joinPoint, Throwable exception) {
		super(joinPoint);
		severityLevel = null;
		this.exception = exception;
	}

	/** (non-Javadoc)
	 * 
	 * @see com.atb.common.logging.event.CallLogEvent#toString()
	 */
	@Override
	public String toString() {
		String callEventString = super.toString();
		StringBuilder stackTraceBuilder = new StringBuilder();
		Throwable cause = null;
		if (exception.getClass() == SoftException.class) {
			cause = exception.getCause();
		} else {
			cause = exception;
		}
		StackTraceElement[] traceElements = cause.getStackTrace();
		stackTraceBuilder.append(cause.getMessage());
		StackTraceElement[] astacktraceelement;
		int j = (astacktraceelement = traceElements).length;
		for (int i = 0; i < j; i++) {
			StackTraceElement element = astacktraceelement[i];
			stackTraceBuilder.append(element);
			stackTraceBuilder.append("\n");
		}

		return String
				.format("%sException Log Event: %s\nSeverity: %s\nModule Name: %s\n" 
						+ "Code: %s\nMessage: %s\nStack Trace: %s",
						new Object[] { callEventString,
								cause.getClass().getName(), severityLevel,
								getModuleName(), responseCode,
								responseMessage, stackTraceBuilder.toString() });
	}
}
