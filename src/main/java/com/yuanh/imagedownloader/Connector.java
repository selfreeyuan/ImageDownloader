package com.yuanh.imagedownloader;

import java.io.InputStream;
import java.net.URL;

public abstract class Connector {
	URL url;

	public Connector(URL url) {
		this.url = url;
	}

	public abstract InputStream getImageInpustream() throws Exception;

	public abstract void setProperties(ConnProperties properties);
}