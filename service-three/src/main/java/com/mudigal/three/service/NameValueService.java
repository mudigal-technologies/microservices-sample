package com.mudigal.three.service;

import com.mudigal.three.model.AllNameValueTO;
import com.mudigal.three.model.NameValueTO;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
public interface NameValueService {

	NameValueTO updateNameValue(NameValueTO nameValueTO);

	AllNameValueTO getAllNameValues(String name);

	NameValueTO updateNameValue(NameValueTO nameValueTO, boolean fromRabbit);

	NameValueTO generateUUID();

	NameValueTO generateUUID(String applicationName);

}
