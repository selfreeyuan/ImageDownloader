package com.yuanh.imagedownloader;

import java.util.ArrayList;

public class StdImageDownloader extends Downloader {

	public void imageDownload(ArrayList<String> list, int seq, String format) throws Exception {
		if (this.writer == null) {
			throw new Exception("Writer can not be null");
		}
	}

	public void setProperties(ConnProperties properties) {
		this.properties = properties;
	};

	public void setWriter(ImageWriter writer) {
		this.writer = writer;
	};
	
	
}
