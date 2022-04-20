package com.quintrix.jfs.quintrixspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.service.CarService;

@RestController
public class CarController {

  // connects controller to service layer
  @Autowired
  private CarService carService;

  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  List<Car> getCars(@RequestParam(name = "make", required = false) String make) {
    return carService.getCars(make);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  Car getCarDetails(@PathVariable("id") Long id) {
    return carService.getCarDetailsById(id);
  }

  // posts car to list
  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  Car addCar(@RequestBody Car car) {
    return carService.addCar(car);

  }

}


