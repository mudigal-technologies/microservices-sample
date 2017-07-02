package com.mudigal.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@Controller
public class WebMainController {

	private Logger logger = Logger.getLogger(WebMainController.class);

	@RequestMapping (value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Inside WEB Controller");
		return "index";
	}

}
