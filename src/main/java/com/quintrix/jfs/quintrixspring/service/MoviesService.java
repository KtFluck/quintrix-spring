package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Movies;

@RestController
public class MoviesService {

  public List<Movies> moviesList = new ArrayList<>(Arrays.asList(

      // Movies(String title, String rating, String runTime, String showTime)
      new Movies("Fantastic Beasts: The Secrets of Dumbledore", "PG-13", "2h23m",
          "5:15pm, 6:00pm, 7:00pm, 7:50pm, 8:30pm, 9:15pm"),
      new Movies("Sonic the Hedgehog 2", "PG", "2h2m", "7:00pm, 8:00pm, 9:00pm"),
      new Movies("Morbius", "PG-13", "1h48m", "6:20pm, 9:00pm")

  ));


  @RequestMapping(method = RequestMethod.GET, value = "/movies")
  public List<Movies> getMovies(@RequestParam(name = "title", required = false) String title) {

    if (title != null) {
      return moviesList.stream().filter(c -> c.getTitle().equals(title))
          .collect(Collectors.toList());

    } else {
      return moviesList;
    }
  }



  public Movies getMoviesRating(String rating) {
    return moviesList.stream().filter(movies -> movies.getRating().equals(rating)).findFirst()
        .get();
  }

  public void addMovies(Movies movie) {
    moviesList.add(movie);
  }


}
