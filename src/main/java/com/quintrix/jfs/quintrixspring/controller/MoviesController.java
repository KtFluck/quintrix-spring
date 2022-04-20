package com.quintrix.jfs.quintrixspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Movies;
import com.quintrix.jfs.quintrixspring.service.MoviesService;

@RestController
public class MoviesController {

  // connects controller to service layer
  @Autowired
  private MoviesService moviesService;

  // gets all movies in list
  @RequestMapping("/movies")
  public List<Movies> allMovies() {
    return moviesService.moviesList;
  }

  // gets all movies with queried rating
  @RequestMapping("/movies/{rating}")
  public Movies getMoviesRating(@PathVariable("rating") String rating) {
    return moviesService.getMoviesRating(rating);
  }

  // method to add a movie to the list
  @RequestMapping(method = RequestMethod.POST, value = "/movies")
  public void addMovies(@RequestBody Movies movies) {
    moviesService.addMovies(movies);
  }

}


