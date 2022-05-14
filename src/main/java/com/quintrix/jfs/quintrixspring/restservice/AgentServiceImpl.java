package com.quintrix.jfs.quintrixspring.restservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;

@Component
public class AgentServiceImpl implements AgentService {

  // @bean restTemplete w/ timeout in ApplicationConfig
  @Autowired
  RestTemplate restTemplate;

  // URL hard coded in yml file
  @Value("${agentService.getUrl}")
  String agentServiceGetUrl;


  // Gets a list of all agents: http://localhost:8080/agents
  @Override
  public List<Agent> getAgentList() {
    List<Agent> agentsList = null;
    // header authorization
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization",
        "Bearer ee583768b8bc0d4e8ea40afd85078131d35b86602c9379398875dab35f8a0611");
    HttpEntity<Agent> requestBody = new HttpEntity<>(headers);
    // ResonseEntity using restTemplete
    ResponseEntity<List<Agent>> agentsListResponseEntity = restTemplate.exchange(agentServiceGetUrl,
        HttpMethod.GET, requestBody, new ParameterizedTypeReference<List<Agent>>() {});
    // checks HttpStatus
    if (agentsListResponseEntity.getStatusCode() == HttpStatus.OK) {
      agentsList = agentsListResponseEntity.getBody();
    }
    return agentsList;
  }

  // Adds agent to database using POST: http://localhost:8080/agents
  @Override
  public List<Agent> addAgentList(Agent agent) {
    // header authorization
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization",
        "Bearer ee583768b8bc0d4e8ea40afd85078131d35b86602c9379398875dab35f8a0611");
    HttpEntity<Agent> requestBody = new HttpEntity<>(agent, headers);
    // ResonseEntity using restTemplete
    ResponseEntity<String> agentsListResponseEntity =
        restTemplate.exchange(agentServiceGetUrl, HttpMethod.POST, requestBody, String.class);

    System.out.println(agentsListResponseEntity);
    // adds agent to list at index 0
    List<Agent> agentList = getAgentList();
    agentList.add(0, agent);
    return agentList;
  }

  // Gets agent info using given id number: http://localhost:8080/agents/3305
  @Override
  public Agent getAgentById(Long id) {

    // header authorization
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization",
        "Bearer ee583768b8bc0d4e8ea40afd85078131d35b86602c9379398875dab35f8a0611");
    HttpEntity<Agent> requestBody = new HttpEntity<>(headers);
    // ResonseEntity using restTemplete
    ResponseEntity<Agent> response = restTemplate.exchange(agentServiceGetUrl + "/" + id,
        HttpMethod.GET, requestBody, Agent.class);
    // checks HttpStatus
    if (response.getStatusCode() == HttpStatus.OK) {
      Agent agentById = response.getBody();
      return agentById;
    }
    return response.getBody();
  }
}

