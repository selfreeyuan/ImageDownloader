package com.yuanh.imagedownloader;

import java.util.HashMap;

public class ConnProperties {
	private HashMap<String,String> properties = new HashMap<String, String>();

	public void setProperty(String key,String value) {
		this.properties.put(key,value);
	}
	
	public HashMap<String,String> getProperties(){
		return this.properties;
	}
}
