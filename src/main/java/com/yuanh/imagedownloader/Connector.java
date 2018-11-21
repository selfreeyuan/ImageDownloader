package com.yuanh.imagedownloader;


import java.io.InputStream;
import java.util.ArrayList;

public abstract class Connector {
	public abstract ArrayList<String> buildImageList() throws Exception;
	public abstract InputStream getImageInpustream();
	public abstract void setProperties(ConnProperties properties);
}