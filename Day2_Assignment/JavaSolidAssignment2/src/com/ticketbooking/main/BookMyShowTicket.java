package com.ticketbooking.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.ticketbooking.model.Show;
import com.ticketbooking.serviceImpl.ShowImpl;
import com.ticketbooking.serviceImpl.ShowManagerImpl;

public class BookMyShowTicket {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		List<Show> list = ShowManagerImpl.shows;
		ShowManagerImpl showManagerImpl = new ShowManagerImpl();

		Scanner scanner = new Scanner(new File("C:\\Users\\TanmayP2\\OneDrive - CitiusTech\\Documents\\Impact_Training\\JAVA Solid Principle\\Assignment\\show.txt"));

		while (scanner.hasNextLine()) {
			String getData = scanner.nextLine();
			String[] splitData = getData.split(",");
			String showName = splitData[0];
			String showTime = splitData[1];
			String seatsAvailable = splitData[2];

			showManagerImpl.populate(new Show(showName, showTime, Integer.parseInt(seatsAvailable)));
		}
		list = new ShowImpl().displayAllShows();
		list.stream().sorted(Comparator.comparing(Show::getShowName)).forEach(x -> System.out.println(x));

		try {
			showManagerImpl.getBookMyShow(list, "Doctor Stange In The Multiverse Of Madness", "05:30", 3);
			list = ShowManagerImpl.shows;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
