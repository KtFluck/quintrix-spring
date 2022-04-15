package com.quintrix.jfs.quintrixspring.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.service.CarService;

@RestController
public class CarController {

  @Autowired
  private CarService carService;

  @RequestMapping("/cars")
  public List<Car> all_Car() {
    return carService.carsList;

  }

}


