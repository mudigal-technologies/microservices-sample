package com.mudigal.two.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mudigal.two.component.queue.ServiceTwoRabbitMQBean;
import com.mudigal.two.model.NameValueTO;
import com.mudigal.two.service.NameValueService;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Vijayendra Mudigal
 */
@Profile("!default")
@Service("serviceTwoRabbitMessageConsumer")
public class ServiceTwoRabbitMessageConsumer {

  private Logger logger = LoggerFactory.getLogger(ServiceTwoRabbitMessageConsumer.class);

  private NameValueService nameValueService;

  @Value("${spring.application.name}")
  private String applicationName;

  @Autowired
  public ServiceTwoRabbitMessageConsumer(NameValueService nameValueService) {
    this.nameValueService = nameValueService;
  }

  @RabbitListener(queues = ServiceTwoRabbitMQBean.queueName)
  public void process(String data) {

    logger.info(String.format("Received by %s data (%s) from RabbitMQ", applicationName, data));
    try {
      NameValueTO nameValueTO = new ObjectMapper().readValue(data, NameValueTO.class);
      logger.info(String.format("Processed data as (%s)",nameValueTO));
      nameValueService.updateNameValue(nameValueTO, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
