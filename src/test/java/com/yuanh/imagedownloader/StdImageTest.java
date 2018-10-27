package com.yuanh.imagedownloader;


import org.junit.Test;


import junit.framework.TestCase;

public class StdImageTest extends TestCase {
	
	@Test
	public static void testImageDown() throws Exception {
		
		
		ConnProperties properties = new ConnProperties();
		properties.setProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		properties.setProperty("Accept-Encoding", "gzip, deflate, br");
		properties.setProperty("Referer", "ttps://www.nvshens.com/g/27828/2.html");
		properties.setProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		
		StdConnector connector = new StdConnector();
		connector.setProperties(properties);
		
		StdImageDownloader d = new StdImageDownloader();
		d.setConnector(connector);
		
		ImageWriter writer = new ImageWriter("D://ImageDown//");
		d.setWriter(writer);
		d.imageDownload("http://img15.yixiu8.com:8080/picture/180925/pic5/35.jpg",1,35,1,"%d");
	}
}
