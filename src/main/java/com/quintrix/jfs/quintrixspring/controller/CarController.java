package com.quintrix.jfs.quintrixspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.jfs.quintrixspring.entity.Car;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;
import com.quintrix.jfs.quintrixspring.restservice.AgentService;
import com.quintrix.jfs.quintrixspring.service.CarService;

@RestController
public class CarController {

  private static final Logger logger = LoggerFactory.getLogger(CarController.class);

  // connects controller to service layer
  @Autowired
  CarService carService;
  @Autowired
  AgentService agentService;

  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  GetCarsResponse getCars(@RequestParam(name = "make", required = false) String make) {

    return carService.getCars(make);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  Car getCarDetails(@PathVariable("id") Long id) {

    logger.debug("Request: Called getCarsDetails Controller {}", id);
    return carService.getCarDetailsById(id);
  }

  // posts car to list
  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  Car addCar(@RequestBody String carStr) throws JsonMappingException, JsonProcessingException {

    System.out.println(carStr);
    ObjectMapper objectMapper = new ObjectMapper();
    Car car = objectMapper.readValue(carStr, Car.class);
    return carService.addCar(car);

  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/cars{id}")
  public Car deleteById(@PathVariable("id") Long id) {

    logger.debug("Request: Called getCarsDetails Controller {}", id);
    if (carService.deleteCarById(id)) {
      return new Car();
    } else {
      return null;
    }
  }

  public CarService getCarService() {
    return carService;
  }

  public void setCarService(CarService carService) {
    this.carService = carService;
  }


}


