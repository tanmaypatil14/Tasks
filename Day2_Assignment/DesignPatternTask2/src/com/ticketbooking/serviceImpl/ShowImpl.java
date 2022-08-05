package com.ticketbooking.serviceImpl;

import java.util.List;
import com.ticketbooking.model.Show;

@FunctionalInterface
interface ShowLists {
	public List<Show> displayAllShows();
}

public class ShowImpl implements ShowLists {

	@Override
	public List<Show> displayAllShows() {
		return ShowManagerImpl.shows;
	}

}
