package com.yuanh.imagedownloader;

import java.util.HashMap;

public class ConnProperties {
	private HashMap<String,String> properties = new HashMap<String, String>();

	public void setUserAgent(String value) {
		this.properties.put("UserAgent",value);
	}
	
	public String getUserAgent() {
		return this.properties.get("UserAgent");
	}
	
	public void setReferer(String reffer) {
		this.properties.put("Referer", reffer);
	}
	
	public String getReferer() {
		return this.properties.get("Referer");
		
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
}
