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
public class ApiGatewayMainController {

	private Logger logger = Logger.getLogger(ApiGatewayMainController.class);
	
	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Called API Gateway's root API");
		return "Message from API-Gateway!!";
	}
}
