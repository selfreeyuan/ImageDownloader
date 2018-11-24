package com.yuanh.imagedownloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageWriter {
	String path;

	public ImageWriter(String path) {
		this.path = path;
	}
	
	public void writeImage(InputStream in,String fullPath) throws IOException {
		
		FileOutputStream ou = new FileOutputStream(new File(fullPath));
		byte[] buffer = new byte[1024];
		int readline;
		while((readline = in.read(buffer))!=-1) {
			ou.write(buffer, 0, readline);
		}
		ou.flush();
		ou.close();
	}
	
	public String getPath() {
		return this.path;
	}
}
