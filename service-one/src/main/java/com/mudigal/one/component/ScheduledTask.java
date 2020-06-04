package com.mudigal.one.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mudigal.one.domain.NameValue;
import com.mudigal.one.service.NameValueService;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Component
public class ScheduledTask {

	private Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

	private NameValueService nameValueService;

	@Autowired
	public ScheduledTask(NameValueService nameValueService) {
		this.nameValueService = nameValueService;
	}

	@Scheduled(fixedDelay = 60 * 1000)
	public void generateUUID() {
		logger.debug("Triggered scheduled task to update the service's value.");
		nameValueService.getNameValue().subscribe(data -> {
			NameValue nameValue = data;
			nameValue.setValue(nameValueService.generateUUID().getValue());
			nameValueService.updateNameValue(nameValue, false);
		});
	}
	
}
