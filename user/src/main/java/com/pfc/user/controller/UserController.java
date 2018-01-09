package com.pfc.user.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.pfc.user.entity.User;
import com.pfc.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private EurekaClient eurekaClient;

  @Autowired
  private DiscoveryClient discoveryClient;


  @GetMapping("/eureka-instance")
  public String serviceUrl() {
    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("USER", false);
    return instance.getHomePageUrl();
  }

  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    return this.discoveryClient.getLocalServiceInstance();
  }


  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }
}
