package com.mudigal.one;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mudigal.one.domain.NameValue;
import com.mudigal.one.service.NameValueService;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient
@EnableReactiveMongoRepositories
public class ServiceOneApplication {

	@Bean
	CommandLineRunner generateNameValue(NameValueService nameValueService) {

		return args -> {
			NameValue nameValue = nameValueService.generateUUID();
			nameValueService.updateNameValue(nameValue, false);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}

}
