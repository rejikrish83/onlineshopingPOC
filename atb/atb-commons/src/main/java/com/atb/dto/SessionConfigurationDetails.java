/**
 * 
 */
package com.atb.dto;

import java.io.Serializable;

/**
 * @author rejikrishnan.rr
 *
 */
public class SessionConfigurationDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String contextPathValue;
	private Long configuredSession;
	/**
	 * @return the contextPathValue
	 */
	public String getContextPathValue() {
		return contextPathValue;
	}
	/**
	 * @param contextPathValue the contextPathValue to set
	 */
	public void setContextPathValue(String contextPathValue) {
		this.contextPathValue = contextPathValue;
	}
	/**
	 * @return the configuredSession
	 */
	public Long getConfiguredSession() {
		return configuredSession;
	}
	/**
	 * @param configuredSession the configuredSession to set
	 */
	public void setConfiguredSession(Long configuredSession) {
		this.configuredSession = configuredSession;
	}
}
