package com.yuanh.imagedownloader;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {
	
	@Test
	public void testJsoup() throws IOException {
		Document doc = Jsoup.connect("http://www.tu11.com/BEAUTYLEGtuimo/2018/14145_7.html").get();
		Elements eles = doc.getElementsByClass("nry");
		Elements imgs = eles.select("img");
		for(Element e:imgs) {
			System.out.println(e.attr("src"));
		}
	}
}
