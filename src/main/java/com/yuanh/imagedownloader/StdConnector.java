package com.yuanh.imagedownloader;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class StdConnector extends Connector {

	public StdConnector(URL url) {
		super(url);
	}

	private ConnProperties properties;

	@Override
	public InputStream getImageInpustream() throws Exception {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		for (String key : properties.getProperties().keySet()) {
			conn.setRequestProperty(key, properties.getProperties().get(key));
		}
		return conn.getInputStream();
	}

	@Override
	public void setProperties(ConnProperties properties) {
		this.properties = properties;
	}

}
