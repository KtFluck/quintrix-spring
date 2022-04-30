package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.entity.Car;
import com.quintrix.jfs.quintrixspring.exception.CarNotFoundException;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;
import com.quintrix.jfs.quintrixspring.repository.CarRepository;
import com.quintrix.jfs.quintrixspring.restservice.AgentService;

@Service
public class CarServiceImpl implements CarService {

  private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

  @Autowired
  CarRepository carResository;

  @Autowired
  AgentService agentService;


  // creates an array list of cars
  public List<Car> carsList = new ArrayList<>(
      Arrays.asList(new Car(1L, "Ford", "SUV", 2011), new Car(2L, "Honda", "Civic", 2008)

      ));


  // gets car with specified make and car info
  @Override
  public GetCarsResponse getCars(String make) {
    GetCarsResponse getCarsResponse = new GetCarsResponse();

    if (make != null) {
      getCarsResponse.setAvailableCarsList(carsList.stream().filter(c -> c.getMake().equals(make))
          .map(c -> new ClientCar(c.getMake(), c.getModel(), c.getYear()))
          .collect(Collectors.toList()));
    }

    // else {
    // return getCarsResponse.setAvailableCarsList(carsList);
    // }
    getCarsResponse.setAvailableWarranty("2 year warranty");


    List<Agent> agentsList = agentService.getAgentList();

    getCarsResponse.setAgentsList(agentsList);
    return getCarsResponse;
  }



  // gets cars with specified id or returns nothing
  @Override
  public Car getCarDetailsById(Long id) {

    // Optional<Car> car =
    // carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();

    // for this to work you must have @Autowired carResository
    Optional<Car> car = carResository.findById(id);

    if (car.isPresent()) {
      return car.get();
    } else {
      logger.error("Customer is calling with id = {}", id);
      throw new CarNotFoundException("Invalid id", "Please use a different Id");
    }
  }

  // method to add car
  @Override
  public Car addCar(Car car) {
    carsList.add(car);
    return car;
  }

}
