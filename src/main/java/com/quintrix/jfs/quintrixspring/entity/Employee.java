package com.quintrix.jfs.quintrixspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

  @Id
  private Integer id;

  @Column(name = "FRIST_NAME")
  private String firstName;
  @Column(name = "LAST_NAME")
  private String lastName;


  // getters and setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }



}
