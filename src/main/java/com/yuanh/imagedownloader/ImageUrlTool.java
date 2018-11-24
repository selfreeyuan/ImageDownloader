package com.yuanh.imagedownloader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUrlTool {
	public static UrlEntity parese(String url) {
		String regex = "((?:http|www)[a-zA-Z0-9:/.]+/)([0-9-_]+)(_|-)(\\d+).(html|jpg)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(url);
		
		UrlEntity e = null;

		while (m.find()) {
			e = new UrlEntity(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5));
			e.buildFullUrl();
		}
		return e;
	}


	
	
}
