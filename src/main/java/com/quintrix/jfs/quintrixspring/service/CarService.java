package com.quintrix.jfs.quintrixspring.service;

import com.quintrix.jfs.quintrixspring.entity.Car;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;

public interface CarService {

  Car addCar(Car car);

  Car getCarDetailsById(Long id);

  GetCarsResponse getCars(String make);

}
