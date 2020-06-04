package com.mudigal.two.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mudigal.two.component.queue.ServiceTwoRabbitMQBean;
import com.mudigal.two.model.NameValueTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

/**
 * @author Vijayendra Mudigal
 */
@Profile("!default")
@Service("serviceTwoRabbitMessageProducer")
public class ServiceTwoRabbitMessageProducer {

  private Logger logger = LoggerFactory.getLogger(ServiceTwoRabbitMessageProducer.class);

  private RabbitTemplate rabbitTemplate;

  @Autowired
  public ServiceTwoRabbitMessageProducer(
      RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessageToQueue(final NameValueTO message) {

    try {
      logger.info("Sending message (" + message + ") to RabbitMQ's exchange ("
          + ServiceTwoRabbitMQBean.exchangeName + ")");
      this.rabbitTemplate.convertAndSend(ServiceTwoRabbitMQBean.exchangeName,
          ServiceTwoRabbitMQBean.routingKeyName, new ObjectMapper().writeValueAsString(message));
    } catch (MessagingException | JsonProcessingException e) {
      logger.error(e.getMessage());
    }
  }
}
