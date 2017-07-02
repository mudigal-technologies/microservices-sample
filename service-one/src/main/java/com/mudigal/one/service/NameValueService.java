package com.mudigal.one.service;

import com.mudigal.one.model.AllNameValueTO;
import com.mudigal.one.model.NameValueTO;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
public interface NameValueService {

	NameValueTO updateNameValue(NameValueTO nameValueTO);
	
	NameValueTO updateNameValue(NameValueTO nameValueTO, boolean fromRabbit);

	AllNameValueTO getAllNameValues(String name);

	NameValueTO generateUUID();

	NameValueTO generateUUID(String applicationName);

}
