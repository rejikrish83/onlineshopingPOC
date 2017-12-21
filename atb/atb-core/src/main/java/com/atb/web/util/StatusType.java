package com.atb.web.util;

public enum StatusType {

	ACTIVE(0), IN_REPAIR(1), IN_CALIBRATION(1), NOT_IN_USE(1), AVAILABLE_FOR_RECYCLING(1), BROKEN(1), 
	SUSPENDED(1), DISCONNECTED(2), ERROR(3), ALARM(3), NULL(4),IN_MAINTENANCE(5),READY_FOR_PURCHASE(6),IN_TRANSFER(78);

	private final int intValue;

	private StatusType(final int intValue) {
		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public static StatusType fromIntValue(final int intValue) {
		switch (intValue) {
		case 0:
			return ACTIVE;
		case 1:
			return SUSPENDED;
		case 2:
			return DISCONNECTED;
		case 3:
			return ALARM;
		case 5:
			return IN_MAINTENANCE;
		case 6:
			return READY_FOR_PURCHASE;
		case 78:
			 return IN_TRANSFER;

		default:
			return NULL;
			//throw new IllegalArgumentException("Invalid Status.");
		}
	}

}
