package com.mudigal.one.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mudigal.one.domain.NameValue;
import com.mudigal.one.service.NameValueService;

import reactor.core.publisher.Mono;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@RestController
@RequestMapping(value = "/")
public class NameValueController {
	
	Logger logger = Logger.getLogger(NameValueController.class.getName());
	
	@Autowired
	private NameValueService nameValueService;

	@GetMapping
	public Mono<NameValue> getNameValue() {
		logger.debug("Inside getNameValue() method of NameValueController class");
		return nameValueService.getNameValue();
	}

}
