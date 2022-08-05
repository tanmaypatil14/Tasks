package com.ticketbooking.service;

import java.util.List;
import com.ticketbooking.exception.InvalidSeatNumberException;
import com.ticketbooking.exception.SeatsNotAvailableException;
import com.ticketbooking.exception.UnknownShowException;
import com.ticketbooking.model.Show;

public interface ShowManager {
	public void populate(Show show);

	public void getBookMyShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws UnknownShowException, SeatsNotAvailableException, InvalidSeatNumberException;

}
