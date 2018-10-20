package com.yuanh.imagedownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StdImageDownloader {
	public void ImageDownload(String url,int start,int end,int seq) throws MalformedURLException, IOException {
		String filePath = "D:/ImageDownload/";

		String prefix = null;
		String suffix = null;

		String pattern = "(^https?:.*/)(\\d+)(.[a-z]+)$";
		Pattern p = Pattern.compile(pattern);

		Matcher matcher = p.matcher(url);
		if (matcher.find()) {
			prefix = matcher.group(1);
			suffix = matcher.group(3);
		}

		for (int i = start; i < end + 1; i++) {
			String str = null;
			if(i==0) {
				str = String.valueOf(i);
			}else {
				str =  String.format("%03d", i);

			}
			String target = prefix + str + suffix;
			URL imgUrl = new URL(target);
			HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
				InputStream in = conn.getInputStream();
				StdImageWriter writer = new StdImageWriter();
				writer.writeImage(in, filePath + seq+i + suffix);

		}

	}
}
