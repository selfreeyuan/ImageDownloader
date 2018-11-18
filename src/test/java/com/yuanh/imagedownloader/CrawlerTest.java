package com.yuanh.imagedownloader;


import java.net.MalformedURLException;

import org.junit.Test;

public class CrawlerTest {

	@Test
	public void testCrawler() throws MalformedURLException, Exception {
		ImageUrlEntity e = ImageUrlTool.parese("http://www.tu11.com/BEAUTYLEGtuimo/2018/14113_24.html");
		System.out.println(e.getImgSeq());
	}
}