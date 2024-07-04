package com.home.BookMyShowApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TheaterController {
	Map<City, List<Theater>> cityWiseTheaterMapping;
	List<Theater> allTheaters;

	public TheaterController(Map<City, List<Theater>> cityWiseTheaterMapping, List<Theater> allTheaters) {
		super();
		this.cityWiseTheaterMapping = cityWiseTheaterMapping;
		this.allTheaters = allTheaters;
	}

	public Map<City, List<Theater>> getCityWiseTheaterMapping() {
		return cityWiseTheaterMapping;
	}

	public void setCityWiseTheaterMapping(Map<City, List<Theater>> cityWiseTheaterMapping) {
		this.cityWiseTheaterMapping = cityWiseTheaterMapping;
	}

	public List<Theater> getAllTheaters() {
		return allTheaters;
	}

	public void setAllTheaters(List<Theater> allTheaters) {
		this.allTheaters = allTheaters;
	}

	void addTheatre(Theater theatre, City city) {

		allTheaters.add(theatre);

		List<Theater> theatres = cityWiseTheaterMapping.getOrDefault(city, new ArrayList<>());
		theatres.add(theatre);
		cityWiseTheaterMapping.put(city, theatres);
	}
}
