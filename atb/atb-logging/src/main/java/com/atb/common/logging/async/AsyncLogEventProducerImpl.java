package com.atb.common.logging.async;

import com.atb.common.logging.appender.LogAppender;
import com.atb.common.logging.event.LogEvent;
import com.atb.common.logging.producer.LogEventProducer;

public class AsyncLogEventProducerImpl implements LogEventProducer {

	/** The async appender. */
	private LogAppender asyncAppender;

	/**
	 * The Constructor.
	 */
	public AsyncLogEventProducerImpl() {
	}

	/**
	 * Gets the async appender.
	 * 
	 * @return the async appender
	 */
	public LogAppender getAsyncAppender() {
		return asyncAppender;
	}

	/**
	 * Sets the async appender.
	 * 
	 * @param asyncAppender
	 *            the async appender
	 */
	public void setAsyncAppender(LogAppender asyncAppender) {
		this.asyncAppender = asyncAppender;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atb.common.logging.producer.LogEventProducer#publish(
	 * com.atb.common.logging.event.LogEvent)
	 */
	@Override
	public void publish(LogEvent logEvent) {
		asyncAppender.append(logEvent.toString());
	}
}
