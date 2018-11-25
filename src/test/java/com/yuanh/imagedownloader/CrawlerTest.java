package com.yuanh.imagedownloader;

import java.net.MalformedURLException;

import org.junit.Test;

public class CrawlerTest {

	@Test
	public void testCrawler() throws MalformedURLException, Exception {

		ImgTarget target = new ImgTarget("picture", "img", "src");
		ConnProperties properties = new ConnProperties();
		properties.setUserAgent(
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
		properties.setReferer("http://www.tu11.com/BEAUTYLEGtuimo/2018/14145.html");
		StdImageDownloader downloader = new StdImageDownloader();
		downloader.setProperties(properties);
		downloader.setImgTarget(target);

		
		ImageWriter writer = new ImageWriter("D:\\ImageDown\\");
		downloader.setWriter(writer);
		downloader.imageDownload("https://www.yuleba.org/a/210-1544-8.html.html", 1);
	}

}