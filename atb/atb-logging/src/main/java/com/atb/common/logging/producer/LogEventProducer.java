package com.atb.common.logging.producer;

import com.atb.common.logging.event.LogEvent;

public interface LogEventProducer {
	
	/**
	 * Publish.
	 *
	 * @param logevent the logevent
	 */
	void publish(LogEvent logevent);
}
