package com.mudigal.two.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mudigal.two.component.queue.ServiceTwoRabbitMQBean;
import com.mudigal.two.model.NameValueTO;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Service("serviceTwoRabbitMessageProducer")
public class ServiceTwoRabbitMessageProducer {

	private Logger logger = LoggerFactory.getLogger(ServiceTwoRabbitMessageProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessageToQueue(final NameValueTO message) {

		try {
			logger.info("Sending message (" + message + ") to RabbitMQ's exchange ("
					+ ServiceTwoRabbitMQBean.exchangeName + ")");
			this.rabbitTemplate.convertAndSend(ServiceTwoRabbitMQBean.exchangeName,
					ServiceTwoRabbitMQBean.routingKeyName, new ObjectMapper().writeValueAsString(message));
		} catch (MessagingException | JsonProcessingException e) {

		}
	}
}
