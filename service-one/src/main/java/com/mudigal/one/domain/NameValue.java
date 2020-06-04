package com.mudigal.one.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@Data
@Document
@NoArgsConstructor
public class NameValue {

	@Id
	@JsonProperty (value = "originalName")
	private String name;
	
	@JsonProperty (value = "originalValue")
	private String value;
	
	private Map<String, String> remainingNameValuePair = new HashMap<String, String>();

	public NameValue(String name, String value) {
		this.name = name;
		this.value = value;
	}
}
