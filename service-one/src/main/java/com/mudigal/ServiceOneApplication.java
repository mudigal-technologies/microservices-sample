package com.mudigal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}
	
	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String home() {
		return "{\"data\":\"Message from Service-One!!\"}";
	}
}
