package com.atb.common.logging.event;

import org.aspectj.lang.JoinPoint;

public class ReturnLogEvent extends CallLogEvent {

	private static final long serialVersionUID = 1L;

	/** The return object. */
	private Object returnObject;

	/**
	 * The Constructor.
	 * 
	 * @param joinPoint
	 *            the join point
	 * @param returnObject
	 *            the return object
	 */
	public ReturnLogEvent(JoinPoint joinPoint, Object returnObject) {
		super(joinPoint);
		this.returnObject = returnObject;
	}

	/**
	 * Gets the return object.
	 * 
	 * @return the return object
	 */
	public Object getReturnObject() {
		return returnObject;
	}

	/**
	 * Sets the return object.
	 * 
	 * @param returnObject
	 *            the return object
	 */
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	
	/** (non-Javadoc)
	 * @see com.atb.common.logging.event.CallLogEvent#toString()
	 */
	@Override
	public String toString() {
		String callEventString = super.toString();
		return String.format(
				"%sReturn Trace:\nReturn Class: %s,\nReturn Value: %s\n",
				new Object[] {callEventString,
						returnObject.getClass().getName(), returnObject});
	}
}
