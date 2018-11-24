package com.yuanh.imagedownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class StdConnector extends Connector {
	private ConnProperties properties;

	public StdConnector(URL url) {
		super(url);
	}


	@Override
	public void setProperties(ConnProperties properties) {
		this.properties = properties;
	}

	@Override
	public ConnProperties getProperties() {
		return this.properties;
	}


	@Override
	public InputStream getInpustream() throws IOException {
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		for(String key:properties.getProperties().keySet()) {
			conn.setRequestProperty(key, properties.getProperties().get(key));
		}
		return conn.getInputStream();
	}

}
