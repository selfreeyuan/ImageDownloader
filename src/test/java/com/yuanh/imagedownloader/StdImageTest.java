package com.yuanh.imagedownloader;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import junit.framework.TestCase;

public class StdImageTest extends TestCase {
	
	@Test
	public static void testImageDown() throws MalformedURLException, IOException {
		StdImageDownloader d = new StdImageDownloader();
		d.ImageDownload("https://img.onvshen.com:85/gallery/24700/27091/s/039.jpg",0,39,1);
	}
}
