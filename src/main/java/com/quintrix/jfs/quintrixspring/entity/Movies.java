package com.quintrix.jfs.quintrixspring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movies {

  // Variable deceleration
  @Id
  private Integer movieId;
  private String title;
  private String rating;
  private String runTime;
  private String showTime;

  public Movies() {};

  // constructor using fields
  public Movies(Integer movieId, String title, String rating, String runTime, String showTime) {
    super();
    this.movieId = movieId;
    this.title = title;
    this.rating = rating;
    this.runTime = runTime;
    this.showTime = showTime;
  }

  // getters and setters
  public Integer getMovieId() {
    return movieId;
  }

  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getRunTime() {
    return runTime;
  }

  public void setRunTime(String runTime) {
    this.runTime = runTime;
  }

  public String getShowTime() {
    return showTime;
  }

  public void setShowTime(String showTime) {
    this.showTime = showTime;
  }

}
