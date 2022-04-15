package com.quintrix.jfs.quintrixspring.controler;

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

  @Autowired
  private MoviesService moviesService;

  @RequestMapping("/movies")
  public List<Movies> all_Movies() {
    return moviesService.moviesList;
  }

  @RequestMapping("/movies/{rating}")
  public Movies getMoviesRating(@PathVariable("rating") String rating) {
    return moviesService.getMoviesRating(rating);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/movies")
  public void addMovies(@RequestBody Movies movies) {
    moviesService.addMovies(movies);
  }

}


