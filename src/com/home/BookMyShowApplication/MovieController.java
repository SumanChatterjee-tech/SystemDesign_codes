package com.home.BookMyShowApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieController {
	Map<City, List<Movie>> cityWiseMovieMapping;
	List<Movie> allMovies;
	public MovieController(Map<City, List<Movie>> cityWiseMovieMapping, List<Movie> allMovies) {
		super();
		this.cityWiseMovieMapping = cityWiseMovieMapping;
		this.allMovies = allMovies;
	}
	
	//crud operations as, add/delete/update a movie city wise or add a movie in all movie list or get a movie by id
	
	//ADD movie to a particular city, make use of cityVsMovies map
    void addMovie(Movie movie, City city) {

        allMovies.add(movie);

        List<Movie> movies = cityWiseMovieMapping.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityWiseMovieMapping.put(city, movies);
    }
    
    Movie getMovieByName(String movieName) {

        for(Movie movie : allMovies) {
            if((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }


    List<Movie> getMoviesByCity(City city) {
        return cityWiseMovieMapping.get(city);
    }
}
