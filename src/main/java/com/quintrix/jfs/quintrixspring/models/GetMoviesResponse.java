package com.quintrix.jfs.quintrixspring.models;

import java.util.List;

public class GetMoviesResponse {

  // creates a list of movies for the client
  List<ClientMovies> moviesAvailableList;

  // getters and setters
  public List<ClientMovies> getMoviesAvailableList() {
    return moviesAvailableList;
  }

  public void setMoviesAvailableList(List<ClientMovies> moviesAvailableList) {
    this.moviesAvailableList = moviesAvailableList;
  }

}
