package com.yuanh.imagedownloader;

import java.util.ArrayList;

public abstract class Downloader {
	ConnProperties properties;
	ImageWriter writer;
	
	public abstract void imageDownload(ArrayList<String> list,int seq,String format) throws Exception;
	
	public abstract void setProperties(ConnProperties properties);
	public abstract void setWriter(ImageWriter writer);
}
