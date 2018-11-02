package com.yuanh.imagedownloader;


import java.net.MalformedURLException;

import org.junit.Test;

public class CrawlerTest {

	@Test
	public void testCrawler() throws MalformedURLException, Exception {
		
		ConnProperties properties = new ConnProperties();
		properties.setProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		
		Connector connector = new StdConnector();
		connector.setProperties(properties);
		
		Downloader downloader = new CrawlerDownloader();
		downloader.setConnector(connector);
		
		ImageWriter writer = new ImageWriter("D://ImageDown//");
		downloader.setWriter(writer);
		
		downloader.imageDownload("https://www.yuleba.org/a/211-1368-36.html", 1, "%03d");
	}
}