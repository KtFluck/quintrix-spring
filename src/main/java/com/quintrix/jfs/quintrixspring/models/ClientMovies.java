package com.quintrix.jfs.quintrixspring.models;


public class ClientMovies {

  // Variable deceleration
  private String title;
  private String rating;
  private String runTime;
  private String showTime;

  public ClientMovies() {};

  // constructor using fields
  public ClientMovies(String title, String rating, String runTime, String showTime) {
    super();
    this.title = title;
    this.rating = rating;
    this.runTime = runTime;
    this.showTime = showTime;
  }

  // getters and setters
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
