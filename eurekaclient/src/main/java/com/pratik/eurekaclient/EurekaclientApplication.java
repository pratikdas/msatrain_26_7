package com.pratik.eurekaclient;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientApplication.class, args);
	}

}

@RestController
@Slf4j
class ServiceInstanceRestController {


	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances")
	public String serviceInstancesByApplicationName(
			@PathVariable String applicationName) {

		List<ServiceInstance> instances = discoveryClient.getInstances();

		// Fetch the first instance
		ServiceInstance firstInstance = instances.get(0);
		log.info("service instance {} {} {}", firstInstance.getHost(), firstInstance.getPort(), firstInstance.getServiceId())

		return firstInstance.getServiceId();
	}
}
