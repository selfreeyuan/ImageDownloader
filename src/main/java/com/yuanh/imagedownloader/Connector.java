package com.yuanh.imagedownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.sun.net.ssl.HttpsURLConnection;

public abstract class Connector {
	URL url;

	public Connector(URL url) {
		this.url = url;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public void setProperties(ConnProperties properties) {
		// TODO Auto-generated method stub
		
	}

	public ConnProperties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract InputStream getInpustream() throws IOException ;
}