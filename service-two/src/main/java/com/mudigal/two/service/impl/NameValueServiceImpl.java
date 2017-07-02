package com.mudigal.two.service.impl;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mudigal.two.service.impl.NameValueServiceImpl;
import com.mudigal.two.dao.NameValueDao;
import com.mudigal.two.domain.NameValue;
import com.mudigal.two.model.AllNameValueTO;
import com.mudigal.two.model.NameValueTO;
import com.mudigal.two.service.NameValueService;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Service(value = "nameValueService")
public class NameValueServiceImpl implements NameValueService {
	
	private Logger logger = Logger.getLogger(NameValueServiceImpl.class);
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private NameValueDao nameValueDao;

	@Autowired
	private ServiceTwoRabbitMessageProducer serviceTwoRabbitMessageProducer;

	@Override
	public NameValueTO updateNameValue(NameValueTO nameValueTO) {
		return updateNameValue(nameValueTO, false);
	}

	@Override
	public NameValueTO updateNameValue(NameValueTO nameValueTO, boolean fromRabbit) {
		logger.info("Saving: " + nameValueTO);
		NameValueTO savedData = dozerBeanMapper
				.map(nameValueDao.save(dozerBeanMapper.map(nameValueTO, NameValue.class)), NameValueTO.class);
		if (!fromRabbit) {
			serviceTwoRabbitMessageProducer.sendMessageToQueue(savedData);
		}
		return savedData;
	}

	@Override
	public AllNameValueTO getAllNameValues(String name) {
		Iterable<NameValue> nameValues = nameValueDao.findAll();
		AllNameValueTO allNameValueTO = new AllNameValueTO();
		for (NameValue nameValue : nameValues) {
			if (nameValue.getName().equals(name)) {
				allNameValueTO.setOriginalName(nameValue.getName());
				allNameValueTO.setOriginalValue(nameValue.getValue());
			} else {
				allNameValueTO.getRemainingNameValuePair().put(nameValue.getName(), nameValue.getValue());
			}
		}
		return allNameValueTO;
	}
	
	@Override
	@Scheduled (fixedDelay= 60000)
	public NameValueTO generateUUID() {
		return generateUUID(applicationName);
	}

	@Override
	public NameValueTO generateUUID(String applicationName) {
		NameValueTO nameValueTO = new NameValueTO();
		nameValueTO.setName(applicationName);
		nameValueTO.setValue(UUID.randomUUID().toString());
		logger.info("Saved Information: " + updateNameValue(nameValueTO));
		return nameValueTO;
	}
}
