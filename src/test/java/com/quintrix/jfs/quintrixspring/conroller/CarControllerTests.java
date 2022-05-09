package com.quintrix.jfs.quintrixspring.conroller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
// this is needed for get call
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.quintrix.jfs.quintrixspring.controller.CarController;
import com.quintrix.jfs.quintrixspring.entity.Car;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;
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
  void mockControllerMvcMockTest() throws Exception {

    CarController carController = new CarController();
    CarService carServiceMock = Mockito.mock(CarService.class);

    GetCarsResponse getCarsResponse = new GetCarsResponse();

    List<ClientCar> carsList = new ArrayList<>();
    ClientCar car = new ClientCar();
    car.setYear(1995);
    car.setMake("Honda");
    carsList.add(car);
    getCarsResponse.setAvailableCarsList(carsList);

    carController.setCarService(carServiceMock);
    Mockito.when(carServiceMock.getCars("Honda")).thenReturn(getCarsResponse);

    // standaloneSetup import is not automatic, do NOT commit out line
    MockMvc mockMvc = standaloneSetup(carController).build();

    mockMvc.perform(get("/cars").param("make", "Honda"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$.availableCarsList", hasSize(1)))
        .andExpect(jsonPath("$.availableCarsList[0].year", is(1995)));

    // carController.setCarService(carServiceMock);
    // Mockito.when(carServiceMock.deleteCarById(1L)).thenReturn(true);
    // assertNull(carController.deleteById(1L));
  }



}
