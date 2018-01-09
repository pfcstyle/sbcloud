package com.pfc.movie.controller;

import com.pfc.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${user.userServicePath}")
  private String userServicePath;

  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject(this.userServicePath + id, User.class);
  }

  @GetMapping("/test")
  public String test() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("user");
    System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

    ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("user2");
    System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

    return "1";
  }
}
