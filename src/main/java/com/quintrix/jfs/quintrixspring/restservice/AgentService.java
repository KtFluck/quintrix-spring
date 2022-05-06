package com.quintrix.jfs.quintrixspring.restservice;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;

public interface AgentService {

  public List<Agent> getAgentList();

  public List<Agent> addAgentList(Agent agent);

}
