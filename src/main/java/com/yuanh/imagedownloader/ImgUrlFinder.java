package com.yuanh.imagedownloader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImgUrlFinder {
	public List<String> findImgUrls(Connector conn,ImgTarget target) throws Exception{
		URL url = conn.getUrl();
		List<String> imgList = new ArrayList<String>();
		Document doc  = Jsoup.connect(url.toString())
				.userAgent(conn.getProperties().getUserAgent())
				.referrer(conn.getProperties().getReferer())
				.get();
		
		Elements classE =  doc.getElementsByClass(target.getParentTag());
		for(Element everyClassE:classE) {
			Elements picEs = everyClassE.getElementsByTag("img");
			for(Element picE:picEs) {
				imgList.add(picE.attr("src"));
			}
		}
		return imgList;
	}
}
