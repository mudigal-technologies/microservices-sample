package com.mudigal.two.controller;

import com.mudigal.two.ServiceTwoApplication;
import com.mudigal.two.model.AllNameValueTO;
import com.mudigal.two.service.NameValueService;
import io.swagger.v3.oas.annotations.Operation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vijayendra Mudigal
 */

@RestController
public class NameValueController {

  @Value("${spring.application.name}")
  private String applicationName;

  @Autowired
  private NameValueService nameValueService;

  private Logger logger = Logger.getLogger(ServiceTwoApplication.class);

  @GetMapping(value = "/")
  @Operation(summary = "Get name and value", description = "Get service name and its corresponding values for all the services")
  public AllNameValueTO getAllNameValue() {
    logger.info("Inside " + applicationName + " controller's getAllNameValue() method");
    return nameValueService.getAllNameValues(applicationName);
  }

}
