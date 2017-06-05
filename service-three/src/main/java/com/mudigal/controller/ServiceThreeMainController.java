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
public class ServiceThreeMainController {

	private Logger logger = Logger.getLogger(ServiceThreeMainController.class);

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Inside ServiceThreeMainController's home() method");
		return "{\"data\":\"Message from Service-Three!!\"}";
	}

}
