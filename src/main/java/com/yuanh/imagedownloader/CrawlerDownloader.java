package com.yuanh.imagedownloader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerDownloader extends Downloader {
	List<String> imgUrls = new ArrayList<String>();

	public void imageDownload(String url, int seq, String format) throws MalformedURLException, Exception {
		int firstPage = 0;
		String currentHtml = turnToPage(url, firstPage);
		while (findImage(currentHtml)) {
			currentHtml = turnNextPage(currentHtml);
		}
		downImage(seq,format);
	}

	private boolean findImage(String htmlUrl) throws Exception {

		InputStream in = this.connector.getImageStream(new URL(htmlUrl));

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while ((str = reader.readLine()) != null) {
			if (str.indexOf("<div class=\"picture\">") != -1) {
				String nextImageLine = reader.readLine();
				if (nextImageLine.indexOf("<img src=") != -1) {
					String regex = "(https?[0-9a-z:./]+)";
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(nextImageLine);
					while (m.find()) {
						imgUrls.add(m.group(1));
					}
					return true;
				}
			}
		}
		return false;
	}

	public String turnToPage(String url, int current) {
		String result = null;
		String regex = "(\\d+)(?=.html)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(url);
		if (m.find()) {
			result = m.replaceFirst(String.valueOf(current));
			System.out.println("turnTo:" + result);
		}
		return result;
	}

	public String turnNextPage(String url) {
		String result = null;
		String regex = "(\\d+)(?=.html)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(url);
		if (m.find()) {
			int i = Integer.parseInt(m.group(1));
			result = m.replaceFirst(String.valueOf(++i));
			System.out.println("turnNext:" + result);
		}
		return result;
	}

	private void downImage(int seq, String format) throws Exception {
		int count = 0;
		for (String imgUrl : imgUrls) {
			InputStream imgIn = connector.getImageStream(new URL(imgUrl));
			writer.writeImage(imgIn, writer.getPath() + seq + String.format(format, count)+".jpg");
			count++;
		}
	}

}
