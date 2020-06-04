package com.mudigal.one.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudigal.one.dao.NameValueRepository;
import com.mudigal.one.domain.NameValue;
import com.mudigal.one.model.NameValueTO;
import com.mudigal.one.service.NameValueService;
import com.mudigal.one.service.impl.NameValueServiceImpl;

import reactor.core.publisher.Mono;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Service
public class NameValueServiceImpl implements NameValueService {

	private Logger logger = LoggerFactory.getLogger(NameValueServiceImpl.class);

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private NameValueRepository nameValueRepository;

	@Autowired(required = false)
	private ServiceOneRabbitMessageProducer serviceOneRabbitMessageProducer;

	private NameValue dataFromDB;

	@Override
	public NameValue updateNameValue(NameValue nameValue, boolean fromRabbit) {
        if (nameValue != null) {
			nameValueRepository.save(nameValue).subscribe(savedData -> {
				if (!fromRabbit) {
					NameValueTO dataForRabbit = new NameValueTO(savedData.getName(), savedData.getValue());
					if (serviceOneRabbitMessageProducer != null) {
						logger.info("Sending data to RabbitMQ's queue. Data: " + dataForRabbit);
					    serviceOneRabbitMessageProducer.sendMessageToQueue(dataForRabbit);
					}
				}
				dataFromDB = savedData;
			});
        }

		return dataFromDB;
	}

	@Override
	public Mono<NameValue> getNameValue() {
		Mono<NameValue> dataFromDB = nameValueRepository.findById(applicationName);
		logger.debug("Data from mongo database getNameValue(): " + dataFromDB.subscribe());
		return dataFromDB;
	}

	@Override
	public NameValue generateUUID() {
		return new NameValue(applicationName, UUID.randomUUID().toString());
	}

}
