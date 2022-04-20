package com.quintrix.jfs.quintrixspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.service.CarService;

@RestController
public class CarController {

  // connects controller to service layer
  @Autowired
  private CarService carService;

  // puts all cars in a list
  @RequestMapping("/cars")
  public List<Car> allCar() {
    return carService.carsList;

  }

}


