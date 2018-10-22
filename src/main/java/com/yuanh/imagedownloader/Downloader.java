package com.yuanh.imagedownloader;

public abstract class Downloader {
	public abstract void ImageDownload(String url, int start, int end, int seq) throws Exception;
	public abstract void setConnector(Connector connector);
	public abstract void setWriter(ImageWriter writer);
}
