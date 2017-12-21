package com.atb.common.logging.event;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.MDC;

import com.atb.common.LoggingConstants;

public class LogEvent implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The timestamp. */
	private final Date timestamp = new Date();

	/** The user id. */
	private final String userID;

	/** The application name. */
	private final String moduleName;

	/**
	 * The Constructor.
	 */
	public LogEvent() {
		userID = MDC.get(LoggingConstants.USER_ID);
		moduleName = MDC.get(LoggingConstants.MODULE_NAME);
	}

	/**
	 * Gets the timestamp.
	 * 
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Gets the module name.
	 * 
	 * @return the module name
	 */
	public String getModuleName() {
		return moduleName;
	}
}
