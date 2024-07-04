package com.home.BookMyShowApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookMyShowApplication {
	MovieController movieController;
    TheaterController theatreController;
	public BookMyShowApplication() {
		initializeApplication();
	}
    
	public void initializeApplication(){
		movieController = new MovieController(new HashMap<>(), new ArrayList<>());
		theatreController = new TheaterController(new HashMap<>(), new ArrayList<>());
		createMovies();
		createTheaters();
		//implement createBooking
		//createBooking();
	}
	
	public void createTheaters() {
		List<Movie> lsitOfMovie = movieController.getMoviesByCity(City.Kolkata);
		List<Screens> listOfScreens = createScreens();
		
		Theater inox = new Theater(1, listOfScreens, null, "anyAddress", City.Kolkata);
		List<Shows> listOfShows = new ArrayList<>();
		Shows mornignShow = createShows(1, lsitOfMovie.get(0) , inox.getScreens().get(0), 10);
		Shows eveShow = createShows(1, lsitOfMovie.get(1) , inox.getScreens().get(0), 20);
		listOfShows.add(mornignShow);
		listOfShows.add(eveShow);
		inox.setMovies(listOfShows);
		
		Theater pvr = new Theater(1, listOfScreens, null, "anyAddress", City.Hyderabad);
		List<Shows> listOfShowsPvr = new ArrayList<>();
		Shows mornignShowPVR = createShows(1, lsitOfMovie.get(0) , inox.getScreens().get(0), 10);
		Shows eveShowPVR = createShows(1, lsitOfMovie.get(1) , inox.getScreens().get(0), 20);
		listOfShowsPvr.add(mornignShowPVR);
		listOfShowsPvr.add(eveShowPVR);
		inox.setMovies(listOfShows);
		
		 theatreController.addTheatre(inox, City.Kolkata);
	     theatreController.addTheatre(pvr, City.Hyderabad);
	}
	public Shows createShows(int id, Movie movie,  Screens screen, int startTime){
		return new Shows(id, movie, screen, startTime , new ArrayList<>());
	}
	public List<Screens> createScreens(){
        List<Screens> screens = new ArrayList<>();
        Screens screen1 = new Screens(1, createSeats());
        screens.add(screen1);
        return screens;
	}
	
	public List<Seats> createSeats(){
		  //creating 100 seats for testing purpose, this can be generalised
        List<Seats> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seats seat = new Seats(i, 1, CategoryOfSeats.SLIVER, 100);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
        	Seats seat = new Seats(i, 2, CategoryOfSeats.GOLD, 300);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
        	Seats seat = new Seats(i, 3, CategoryOfSeats.SLIVER, 450);
            seats.add(seat);
        }

        return seats;
	}
	public void createMovies() {
		Movie m1 = new Movie(1, "Antaheen", 120);
		Movie m2 = new Movie(2, "Boba Tunnel", 123);
		
		movieController.addMovie(m1, City.Hyderabad);
		movieController.addMovie(m1, City.Kolkata);
		movieController.addMovie(m2, City.Hyderabad);
	}
}
