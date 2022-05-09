package com.quintrix.jfs.quintrixspring.models;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;

public class GetAgentsResponse {

  List<Agent> agentsList;

  public List<Agent> getAgentsList() {
    return agentsList;
  }

  public void setAgentsList(List<Agent> agentsList) {
    this.agentsList = agentsList;
  }



}
