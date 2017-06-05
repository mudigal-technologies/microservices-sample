package com.mudigal.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@RestController
public class ServiceTwoMainController {

	private Logger logger = Logger.getLogger(ServiceTwoMainController.class);

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Inside ServiceTwoMainController's home() method");
		return "{\"data\":\"Message from Service-Two!!\"}";
	}

}
