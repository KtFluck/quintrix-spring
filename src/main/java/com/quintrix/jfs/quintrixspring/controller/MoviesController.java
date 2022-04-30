package com.quintrix.jfs.quintrixspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.entity.Movies;
import com.quintrix.jfs.quintrixspring.models.GetMoviesResponse;
import com.quintrix.jfs.quintrixspring.service.MovieService;

@RestController
public class MoviesController {

  // connects controller to service layer
  @Autowired
  MovieService moviesService;

  @RequestMapping(method = RequestMethod.GET, value = "/movies")
  public GetMoviesResponse getMovies(@RequestParam(name = "title", required = false) String title) {
    return moviesService.getMovies(title);
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


