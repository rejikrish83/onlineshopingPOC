package com.atb.common.logging.event;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class CallLogEvent extends LogEvent {

	private static final long serialVersionUID = 1L;

	/** The class name. */
	private String className;

	/** The method name. */
	private String methodName;

	/** The arguments. */
	private Object[] arguments;

	/** The callback info. */
	private String callbackInfo;

	/**
	 * The Constructor.
	 * 
	 * @param joinPoint
	 *            the join point
	 */
	public CallLogEvent(final JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();
		Object target = joinPoint.getTarget();
		if (target != null) {
			className = target.getClass().getName();
		} 
		if (signature != null) {
			methodName = signature.getName();
		}
		arguments = args;
	}

	/**
	 * The Constructor.
	 * 
	 * @param className
	 *            the class name
	 * @param methodName
	 *            the method name
	 * @param arguments
	 *            the arguments
	 */
	public CallLogEvent(final String className, final String methodName, final Object[] arguments) {
		this.className = className;
		this.methodName = methodName;
		this.arguments = arguments.clone();
	}

	/**
	 * Gets the class name.
	 * 
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the class name.
	 * 
	 * @param className
	 *            the class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Gets the method name.
	 * 
	 * @return the method name
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * Sets the method name.
	 * 
	 * @param methodName
	 *            the method name
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * Gets the arguments.
	 * 
	 * @return the arguments
	 */
	public Object[] getArguments() {
		return arguments.clone();
	}

	/**
	 * Sets the arguments.
	 * 
	 * @param arguments
	 *            the arguments
	 */
	public void setArguments(Object[] arguments) {
		this.arguments = arguments.clone();
	}

	/**
	 * Gets the callback info.
	 * 
	 * @return the callback info
	 */
	public String getCallbackInfo() {
		return callbackInfo;
	}

	/**
	 * Sets the callback info.
	 * 
	 * @param callbackInfo
	 *            the callback info
	 */
	public void setCallbackInfo(String callbackInfo) {
		this.callbackInfo = callbackInfo;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String preString = String
				.format("Call Trace:\nGTMT-User-ID: %s \nTimestamp: %s\nClass: %s\nMethod: %s",
						new Object[] {getUserID(), getTimestamp(), className, methodName});
		if (arguments != null) {
			StringBuilder argBuilder = new StringBuilder();
			Object[] aobj = arguments;			
			int j = aobj.length;
			for (int i = 0; i < j; i++) {
				Object argument = aobj[i];
				argBuilder.append("Argument: ");
				if (argument == null) {
					argBuilder.append("null");
				} else {
					argBuilder.append("[");
					argBuilder.append(argument.getClass().getName());
					argBuilder.append("] ");
					argBuilder.append(argument.toString());
					argBuilder.append("\n");
				}
			}
			if (callbackInfo == null) {
				return String.format("%s \n%s", new Object[] {preString,argBuilder.toString()});
			} else {
				return String.format("%s \n%sCallout Info: %s\n", 
						new Object[] {preString, argBuilder.toString(), callbackInfo});
			}
		}
		if (callbackInfo == null) {
			return String.format("%s \nArgument: %s", new Object[] {preString,"None"});
		} else {
			return String.format("%s \nArgument: %sCallout Info: %s\n",
					new Object[] {preString, "None", callbackInfo});
		}
	}
}
