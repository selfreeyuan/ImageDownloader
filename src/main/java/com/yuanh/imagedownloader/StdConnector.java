package com.yuanh.imagedownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public class StdConnector {
	private ConnProperties properties;
	
	
	public InputStream getImage(URL url) throws Exception {
			if(this.properties==null) {
				throw new Exception("Conn Properties can not be null");
			}
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			for (java.util.Map.Entry<String, String> property : properties.getProperties().) {
				conn.addRequestProperty(property.getKey(), property.getValue());
			}

			return conn.getInputStream();
	}
	
	public void setProperties(ConnProperties properties) {
		this.properties = properties;
	}
}
