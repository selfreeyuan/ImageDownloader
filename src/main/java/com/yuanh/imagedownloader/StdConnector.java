package com.yuanh.imagedownloader;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Map;


public class StdConnector extends Connector{
	private ConnProperties properties;
	
	@Override
	public InputStream getImageStream(URL url) throws Exception {
			if(this.properties==null) {
				throw new Exception("Conn Properties can not be null");
			}
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			for (Map.Entry<String, String> property : properties.getProperties().entrySet()) {
				conn.addRequestProperty(property.getKey(), property.getValue());
			}

			return conn.getInputStream();
	}
	
	@Override
	public void setProperties(ConnProperties properties) {
		this.properties = properties;
	}

}
