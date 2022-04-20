package com.quintrix.jfs.quintrixspring.models;

public class Car {

  // variable decelerations
  Long id;
  String make;
  String model;
  Integer year;

  public Car() {};

  // constructor using fields
  public Car(Long id, String make, String model, Integer year) {
    super();
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  // getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }



}
