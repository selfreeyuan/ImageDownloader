package com.yuanh.imagedownloader;

import org.junit.Test;

import junit.framework.TestCase;

public class StdImageTest extends TestCase {

	@Test
	public static void testImageDown() throws Exception {

		ConnProperties properties = new ConnProperties();
		properties.setProperty("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		properties.setProperty("Accept-Encoding", "gzip, deflate");
		properties.setProperty("Accept-Language", "zh-CN,zh;q=0.9");

		properties.setProperty("Referer", "http://www.tu11.com/ligui/2018/13413_12.html");
		properties.setProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		properties.setProperty("Host", "img15.yixiu8.com:8080");
		properties.setProperty("Cookie", "Cookie: Hm_lvt_a521ae282c3c2742707c26ac9d3a8c59=1540484468,1540485462,1540918022,1540990459; Hm_lpvt_a521ae282c3c2742707c26ac9d3a8c59=1540997720");
		StdConnector connector = new StdConnector();
		connector.setProperties(properties);

		StdImageDownloader d = new StdImageDownloader();
		d.setConnector(connector);

		ImageWriter writer = new ImageWriter("D://ImageDown//");
		d.setWriter(writer);
		d.imageDownload("http://img15.yixiu8.com:8080/picture/181022/pic10/36.jpg", 1, 36, 3, "%d");
	}
}
