package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.entity.Movies;
import com.quintrix.jfs.quintrixspring.models.ClientMovies;
import com.quintrix.jfs.quintrixspring.models.GetMoviesResponse;
import com.quintrix.jfs.quintrixspring.repository.MovieRepository;

@RestController
public class MoviesServiceImpl implements MovieService {

  @Autowired
  MovieRepository movieResository;

  // creates an array list with movie values
  public List<Movies> moviesList = new ArrayList<>(Arrays.asList(

      // Movies(String title, String rating, String runTime, String showTime)
      new Movies(100, "Fantastic Beasts: The Secrets of Dumbledore", "PG-13", "2h23m",
          "5:15pm, 6:00pm, 7:00pm, 7:50pm, 8:30pm, 9:15pm"),
      new Movies(101, "Sonic the Hedgehog 2", "PG", "2h2m", "7:00pm, 8:00pm, 9:00pm"),
      new Movies(102, "Morbius", "R", "1h48m", "6:20pm, 9:00pm")

  ));

  // gets movie with title specified or returns all movies

  @Override
  public GetMoviesResponse getMovies(String title) {
    GetMoviesResponse getMoviesResponse = new GetMoviesResponse();

    if (title != null) {
      getMoviesResponse.setMoviesAvailableList(moviesList.stream()
          .filter(c -> c.getTitle().equals(title))
          .map(c -> new ClientMovies(c.getTitle(), c.getRating(), c.getRunTime(), c.getShowTime()))
          .collect(Collectors.toList()));

    }

    return getMoviesResponse;

  }


  /*
   * @Override public List<Movies> getMovies(String title) { if (title != null) { return
   * moviesList.stream().filter(c -> c.getTitle().equals(title)) .collect(Collectors.toList());
   * 
   * } else {
   * 
   * return moviesList; }
   * 
   * }
   */

  // gets movies with specified rating
  @Override
  public Movies getMoviesRating(String rating) {
    return moviesList.stream().filter(movies -> movies.getRating().equals(rating)).findFirst()
        .get();
  }

  // add movie to list
  @Override
  public void addMovies(Movies movie) {
    moviesList.add(movie);
  }


}
