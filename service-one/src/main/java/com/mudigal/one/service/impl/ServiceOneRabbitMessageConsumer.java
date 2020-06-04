package com.mudigal.one.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mudigal.one.component.queue.ServiceOneRabbitMQBean;
import com.mudigal.one.model.NameValueTO;
import com.mudigal.one.service.NameValueService;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Profile("!default")
@Service("serviceOneRabbitMessageConsumer")
public class ServiceOneRabbitMessageConsumer {

	private Logger logger = LoggerFactory.getLogger(ServiceOneRabbitMessageConsumer.class);

	private NameValueService nameValueService;

	@Autowired
	public ServiceOneRabbitMessageConsumer(NameValueService nameValueService) {
		this.nameValueService = nameValueService;
	}

	@Async
	@RabbitListener(queues = ServiceOneRabbitMQBean.queueName)
	public void process(String data) {
		
		logger.info("Received data (" + data + ") from RabbitMQ");
		try {
			NameValueTO nameValueTO = new ObjectMapper().readValue(data, NameValueTO.class);
			nameValueService.getNameValue().subscribe(nameValueFromDB -> {
				// Update remaining name value pairs if the received data is not
				// from the application that produced it. Example: service-one
				if (!nameValueTO.getName().equals(nameValueFromDB.getName())) {
					nameValueFromDB.getRemainingNameValuePair().put(
							nameValueTO.getName(),
							nameValueTO.getValue());
					nameValueService.updateNameValue(nameValueFromDB, true);
					logger.info("Processed data as (" + nameValueTO + ")");
				}
			});
		} catch (IOException e) {
			logger.error("Error processing data: " + data + " from RabbitMQ.\n" + e.getMessage());
		}
	}
}
