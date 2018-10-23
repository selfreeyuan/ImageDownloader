package com.yuanh.imagedownloader;

public class Downloader {
	private Connector connnector;
	private ImageWriter writer;
	public  void ImageDownload(String url, int start, int end, int seq,String format) throws Exception{
		if(this.connnector == null) {
			throw new Exception("Connector can not be null");
		}
		if(this.writer == null) {
			throw new Exception("Writer can not be null");
		}
	};
	public  void setConnector(Connector connector) {
		this.connnector = connector;
	};
	public  void setWriter(ImageWriter writer) {
		this.writer = writer;
	};
}
