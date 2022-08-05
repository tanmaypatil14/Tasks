package com.ticketbooking.serviceImpl;

import java.util.LinkedList;
import java.util.List;
import com.ticketbooking.exception.InvalidSeatNumberException;
import com.ticketbooking.exception.SeatsNotAvailableException;
import com.ticketbooking.exception.UnknownShowException;
import com.ticketbooking.model.Show;
import com.ticketbooking.service.ShowManager;

public class ShowManagerImpl implements ShowManager {

	public static volatile List<Show> shows = getPopulateShows();

	@Override
	public void populate(Show show) {
		shows.add(show);
	}

	@Override
	public void getBookMyShow(List<Show> showList, String showName, String showTime, int numberOfSeats)
			throws UnknownShowException, SeatsNotAvailableException, InvalidSeatNumberException {
		boolean nameFlag = false;
		boolean timeFlag = false;
		boolean seatsFlag = false;
		for (Show show : shows) {
			if (show.getShowName().equalsIgnoreCase(showName)) {
				nameFlag = true;
				if (show.getShowTime().equals(showTime)) {
					timeFlag = true;
					if (show.getSeatsAvailable() >= numberOfSeats) {
						show.setSeatsAvailable(show.getSeatsAvailable() - numberOfSeats);
						seatsFlag = true;
						System.out.println(" ");
						System.out.println("You have successfully booked show.\n");
						System.out.println("Movie Name : " + show.getShowName() + " and Number Of Seats : "	+ numberOfSeats + "\n");
						System.out.println("Remaining seats : " + show.getSeatsAvailable());
					}
				}
				break;
			}
		}

		if (!nameFlag) {
			throw new UnknownShowException("The Show name " + showName + " is not available");
		} else if (!timeFlag) {
			throw new UnknownShowException("The Show name " + showName + " is not available at the time " + showTime);
		} else if (!seatsFlag) {
			throw new SeatsNotAvailableException("Currently the seats is almost booked, Sorry fot the incovinience");
		}
	}

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private static List<Show> getPopulateShows() {
		return new LinkedList() {};
	}
}
