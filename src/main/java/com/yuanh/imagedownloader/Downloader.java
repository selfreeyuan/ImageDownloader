package com.yuanh.imagedownloader;


public abstract class Downloader {
	ConnProperties properties;
	ImageWriter writer;
	
	public abstract void imageDownload(String sampleURL,int seq) throws Exception;
	
	public abstract void setWriter(ImageWriter writer);
}
