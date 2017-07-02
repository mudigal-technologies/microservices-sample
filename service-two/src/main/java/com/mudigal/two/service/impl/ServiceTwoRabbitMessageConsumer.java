package com.mudigal.two.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mudigal.two.component.queue.ServiceTwoRabbitMQBean;
import com.mudigal.two.model.NameValueTO;
import com.mudigal.two.service.NameValueService;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Service("serviceTwoRabbitMessageConsumer")
public class ServiceTwoRabbitMessageConsumer {

	private Logger logger = LoggerFactory.getLogger(ServiceTwoRabbitMessageConsumer.class);

	@Autowired
	private NameValueService nameValueService;

	@RabbitListener(queues = ServiceTwoRabbitMQBean.queueName)
	public void process(String data) {
		
		logger.info("Received data (" + data + ") from RabbitMQ");
		try {
			NameValueTO nameValueTO = new ObjectMapper().readValue(data, NameValueTO.class);
			logger.info("Processd data as (" + nameValueTO + ")");
			nameValueService.updateNameValue(nameValueTO, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
