package com.quintrix.jfs.quintrixspring.restservice;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;

public interface AgentService {

  public List<Agent> addAgentList(Agent agent);

  public List<Agent> getAgentById(Long id);

  // GetAgentsResponse getAgent(String name);

  public List<Agent> getAgentList();


}
