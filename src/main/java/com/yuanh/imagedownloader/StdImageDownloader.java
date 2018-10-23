package com.yuanh.imagedownloader;

import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StdImageDownloader extends Downloader{
	Connector connector;
	ImageWriter writer;

	public void ImageDownload(String url, int start, int end, int seq,String format) throws Exception {
		super.ImageDownload(url, start, end, seq, format);
		
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
			if (i == 0) {
				str = String.valueOf(i);
			} else {
				str = String.format(format, i);

			}
			String target = prefix + str + suffix;
			URL imgUrl = new URL(target);
			
			InputStream in = connector.getImageStream(imgUrl);
			writer.writeImage(in, writer.getPath() + seq + i + suffix);

		}

	}
}
