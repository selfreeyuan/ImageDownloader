package com.yuanh.imagedownloader;

import java.io.InputStream;
import java.net.URL;

public abstract class Connector {
	public abstract InputStream getImageStream(URL url) throws Exception;
	public abstract void setProperties(ConnProperties properties);
}
