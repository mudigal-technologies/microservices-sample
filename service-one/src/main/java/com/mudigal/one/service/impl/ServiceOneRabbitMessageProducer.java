package com.mudigal.one.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mudigal.one.component.queue.ServiceOneRabbitMQBean;
import com.mudigal.one.model.NameValueTO;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Profile("!default")
@Service("serviceOneRabbitMessageProducer")
public class ServiceOneRabbitMessageProducer {

	private Logger logger = LoggerFactory.getLogger(ServiceOneRabbitMessageProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessageToQueue(final NameValueTO data) {

		try {
			logger.info("Sending message (" + data + ") to RabbitMQ's exchange ("
					+ ServiceOneRabbitMQBean.exchangeName + ")");
			this.rabbitTemplate.convertAndSend(ServiceOneRabbitMQBean.exchangeName,
					ServiceOneRabbitMQBean.routingKeyName, new ObjectMapper().writeValueAsString(data));
		} catch (MessagingException | JsonProcessingException e) {
			logger.error("Error sending data: " + data + " to RabbitMQ. \n" + e.getMessage());
		}
	}
}
