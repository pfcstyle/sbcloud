package com.pfc.discovereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverEurekaApplication.class, args);
	}
}
