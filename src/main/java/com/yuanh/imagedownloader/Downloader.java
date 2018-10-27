package com.yuanh.imagedownloader;

public class Downloader {
	Connector connector;
	ImageWriter writer;
	
	public void imageDownload() throws Exception {
		if(this.connector == null) {
			throw new Exception("Connector can not be null");
		}
		if(this.writer == null) {
			throw new Exception("Writer can not be null");
		}
	};

	public  void imageDownload(String url, int start, int end, int seq,String format) throws Exception{
		imageDownload();
	};
	
	public void imageDownload(String url,int seq,String format) throws Exception {
		imageDownload();
	}
	
	public  void setConnector(Connector connector) {
		this.connector = connector;
	};
	public  void setWriter(ImageWriter writer) {
		this.writer = writer;
	};
}
