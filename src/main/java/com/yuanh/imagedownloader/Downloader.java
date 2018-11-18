package com.yuanh.imagedownloader;

public class Downloader {
	ConnProperties properties;
	ImageWriter writer;
	
	public void imageDownload() throws Exception {
		if(this.writer == null) {
			throw new Exception("Writer can not be null");
		}
	};
	
	public void imageDownload(String url,int seq,String format) throws Exception {
		imageDownload();
	}
	
	public  void setProperties(ConnProperties properties) {
		this.properties = properties;
	};
	public  void setWriter(ImageWriter writer) {
		this.writer = writer;
	};
}
