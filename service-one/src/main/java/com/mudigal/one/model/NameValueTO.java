package com.mudigal.one.model;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
public class NameValueTO {

	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "NameValueTO [name=" + name + ", value=" + value + "]";
	}

}
