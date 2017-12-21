
package com.atb.common.logging.aop.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.SoftException;

import com.atb.common.logging.aop.LogInterceptor;
import com.atb.common.logging.event.CallLogEvent;
import com.atb.common.logging.event.ReturnLogEvent;
import com.atb.common.logging.producer.LogEventProducer;

public class LogInterceptorImpl implements LogInterceptor {

	/** The event producer. */
	private LogEventProducer eventProducer;

	/**
	 * The Constructor.
	 */
	public LogInterceptorImpl() {

	}

	/**
	 * Gets the event producer.
	 * 
	 * @return the event producer
	 */
	public LogEventProducer getEventProducer() {

		return eventProducer;
	}

	/**
	 * Sets the event producer.
	 * 
	 * @param eventProducer
	 *            the event producer
	 */
	public void setEventProducer(LogEventProducer eventProducer) {

		this.eventProducer = eventProducer;
	}

	/**
	 * Log.
	 * 
	 * @param proceedingjoinpoint
	 *            the proceedingjoinpoint
	 * @return the object
	 * @throws Throwable
	 *             the throwable
	 */
	@Override
	public Object log(ProceedingJoinPoint proceedingjoinpoint) throws Throwable {

		CallLogEvent callLogEvent = new CallLogEvent(proceedingjoinpoint);
		if (eventProducer != null) {
			eventProducer.publish(callLogEvent);
		}
		Object returnObject = null;
		try {
			returnObject = proceedingjoinpoint.proceed();
		} catch (Exception exception) {
			if (exception instanceof RuntimeException) {
				throw exception;
			} else {
				throw new SoftException(exception);
			}
		}
		if (returnObject != null) {
			ReturnLogEvent returnLogEvent = new ReturnLogEvent(
					proceedingjoinpoint, returnObject);
			if (eventProducer != null) {
				eventProducer.publish(returnLogEvent);
			}
		}
		return returnObject;
	}
}
