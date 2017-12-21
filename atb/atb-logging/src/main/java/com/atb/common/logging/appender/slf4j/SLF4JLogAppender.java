package com.atb.common.logging.appender.slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atb.common.logging.appender.LogAppender;

public class SLF4JLogAppender implements LogAppender {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(com.atb.common.logging.appender.slf4j.SLF4JLogAppender.class);

	/**
	 * The Constructor.
	 */
	public SLF4JLogAppender() {

	}

	/**
	 * Append.
	 * 
	 * @param s
	 *            the s
	 */
	@Override
	public void append(String event) {

		if (event != null) {
			Matcher matcher = Pattern.compile("Severity: \\w{4,5}").matcher(
					event);
			boolean logged = false;
			if (matcher.find()) {
				String level = matcher.group().replaceAll("Severity: ", "");
				if ("WARN".equalsIgnoreCase(level)) {
					LOGGER.warn(event);
					logged = true;
				} else if ("ERROR".equalsIgnoreCase(level)) {
					LOGGER.error(event);
					logged = true;
				} else if ("DEBUG".equalsIgnoreCase(level)) {
					LOGGER.debug(event);
				} else if ("TRACE".equals(level)) {
					LOGGER.trace(event);
					logged = true;
				}
			}
			if (!logged) {
				LOGGER.info(event);
			}
		}
	}
}