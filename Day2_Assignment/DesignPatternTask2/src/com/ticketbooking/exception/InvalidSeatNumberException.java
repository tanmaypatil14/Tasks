package com.ticketbooking.exception;

public class InvalidSeatNumberException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7862226407172141284L;

	public InvalidSeatNumberException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
