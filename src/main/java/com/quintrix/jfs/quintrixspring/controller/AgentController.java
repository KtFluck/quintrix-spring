package com.quintrix.jfs.quintrixspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;
import com.quintrix.jfs.quintrixspring.restservice.AgentService;

@RestController
public class AgentController {

  // private static final Logger logger = LoggerFactory.getLogger(AgentController.class);

  // connects controller to service layer
  @Autowired
  AgentService agentService;

  // List of all agents
  @RequestMapping(method = RequestMethod.GET, value = "/agents")
  List<Agent> getAgentsList() {

    return agentService.getAgentList(); // need to add name param (@RequestParam(name = "name",
                                        // required = false) String name), must write method for
                                        // name query
                                        // in service layer
  }

  // add agent to list
  @RequestMapping(method = RequestMethod.POST, value = "/agents")
  List<Agent> addAgentsList(@RequestBody Agent agent) {

    return agentService.addAgentList(agent);
  }
  /*
   * // request agent by id
   * 
   * @RequestMapping(method = RequestMethod.GET, value = "/agents/{id}") List<Agent>
   * getAgentById(@PathVariable("id") Long id) {
   * 
   * logger.debug("Request: Called getAgentList Controller {}", id); return
   * agentService.getAgentById(id); }
   */
}
