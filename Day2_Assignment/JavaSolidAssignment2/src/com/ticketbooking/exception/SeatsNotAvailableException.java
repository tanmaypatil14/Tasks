package com.ticketbooking.exception;

public class SeatsNotAvailableException extends Exception {

	/**
		 * 
		 */
	private static final long serialVersionUID = 7583024531654872131L;

	public SeatsNotAvailableException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
