package com.quintrix.jfs.quintrixspring.service;

import com.quintrix.jfs.quintrixspring.entity.Movies;
import com.quintrix.jfs.quintrixspring.models.GetMoviesResponse;

public interface MovieService {

  GetMoviesResponse getMovies(String title);

  Movies getMoviesRating(String rating);

  void addMovies(Movies movie);

}
