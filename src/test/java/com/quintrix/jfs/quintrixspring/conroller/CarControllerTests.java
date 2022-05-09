package com.quintrix.jfs.quintrixspring.conroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import com.quintrix.jfs.quintrixspring.controller.CarController;
import com.quintrix.jfs.quintrixspring.entity.Car;
import com.quintrix.jfs.quintrixspring.service.CarService;

public class CarControllerTests {

  @Test
  void mockServiceTest() {
    CarService carServiceMock = Mockito.mock(CarService.class);

    Car car = new Car();
    car.setId(777L);
    car.setMake("Ford");

    Mockito.when(carServiceMock.getCarDetailsById(1L)).thenReturn(car);
    assertEquals(carServiceMock.getCarDetailsById(1L).getId(), 777L);
  }

  @Test
  void mockControllerTest() {

    CarController carController = new CarController();
    CarService carServiceMock = Mockito.mock(CarService.class);

    Car car = new Car();
    car.setId(777L);
    car.setMake("Ford");

    MockMvc mockMvc = standaloneSetup(carController).build();
    carController.setCarService(carServiceMock);
    Mockito.when(carServiceMock.deleteCarById(1L)).thenReturn(true);
    assertTrue(carController.deleteById(1L));
  }


}
