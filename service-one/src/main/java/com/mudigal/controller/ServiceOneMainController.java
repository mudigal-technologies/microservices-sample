package com.mudigal.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudigal.ServiceOneApplication;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@RestController
public class ServiceOneMainController {

	private Logger logger = Logger.getLogger(ServiceOneApplication.class);

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Inside ServiceOneMainController's home() method");
		return "{\"data\":\"Message from Service-One!!\"}";
	}

}
