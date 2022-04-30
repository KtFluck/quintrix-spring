package com.quintrix.jfs.quintrixspring.models;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;

public class GetCarsResponse {

  private String availableWarranty;

  // creates list of cars
  List<ClientCar> availableCarsList;

  List<Agent> agentsList;

  // getters and setters
  public String getAvailableWarranty() {
    return availableWarranty;
  }

  public void setAvailableWarranty(String availableWarranty) {
    this.availableWarranty = availableWarranty;
  }

  public List<ClientCar> getAvailableCarsList() {
    return availableCarsList;
  }

  public void setAvailableCarsList(List<ClientCar> carsList) {
    this.availableCarsList = carsList;
  }

  public List<Agent> getAgentsList() {
    return agentsList;
  }

  public void setAgentsList(List<Agent> agentsList) {
    this.agentsList = agentsList;
  }



}
