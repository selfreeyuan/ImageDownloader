package com.yuanh.imagedownloader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUrlTool {
	public static ImageUrlEntity parese(String url) {
		String regex =  "((?:http|www)[a-zA-Z0-9:/.]+/)(\\d*)_?(\\d+).(html|jpg)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(url);
		
		ImageUrlEntity e =  new ImageUrlEntity();
		while(m.find()) {
			e.setRootUrl(m.group(1));
			e.setSerialSeq(m.group(2));
			e.setImgSeq(m.group(3));
			e.setSuffix(m.group(4));
		}
		return e;
	}
}
