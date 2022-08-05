package com.ticketbooking.exception;

public class UnknownShowException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6525159829806461568L;

	public UnknownShowException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
