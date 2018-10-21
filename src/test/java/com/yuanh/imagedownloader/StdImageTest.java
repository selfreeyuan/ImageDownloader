package com.yuanh.imagedownloader;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import junit.framework.TestCase;

public class StdImageTest extends TestCase {
	
	@Test
	public static void testImageDown() throws MalformedURLException, IOException {
		StdImageDownloader d = new StdImageDownloader();
		ConnProperties properties = new ConnProperties();
		properties.setProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		properties.setProperty("Accept-Encoding", "gzip, deflate, br");
		properties.setProperty("Referer", "ttps://www.nvshens.com/g/27828/2.html");
		properties.setProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		
		d.ImageDownload("https://img.onvshen.com:85/gallery/24700/27091/s/039.jpg",0,39,1);
	}
}
