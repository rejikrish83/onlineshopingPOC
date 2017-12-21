package com.atb.common.logging;

import com.atb.common.logging.event.LogEvent;
import com.atb.common.logging.producer.LogEventProducer;

public class Logger {

	/** The event producer. */
	private LogEventProducer eventProducer;

	/**
	 * The Constructor.
	 */
	public Logger() {
	}

	/**
	 * Log.
	 * 
	 * @param logEvent
	 *            the log event
	 */
	public void log(LogEvent logEvent) {
		eventProducer.publish(logEvent);
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
}
