package com.yuanh.imagedownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CrawlerTest {
	List<String> imgUrls = new ArrayList<String>();

	@Test
	public void testCrawler() throws MalformedURLException, Exception {
		StdConnector connector = new StdConnector();
		ConnProperties properties = new ConnProperties();
		properties.setProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		connector.setProperties(properties);

		InputStream in = connector.getImageStream(new URL("https://www.yuleba.org/a/211-1450-31.html"));
		System.out.println(findURL(in));
	}

	private boolean findURL(InputStream in) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while ((str = reader.readLine()) != null) {
			if (str.indexOf("<div class=\"picture\">") != -1) {
				String nextImageLine = reader.readLine();
				if (nextImageLine.indexOf("<img src=") != -1) {
					String regex = "(https?[0-9a-z:./]+)";
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(nextImageLine);
					if (m.find()) {
						for (int i = 1; i < m.groupCount() + 1; i++) {
							imgUrls.add(m.group(i));
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	public String turnPage(String url) {
		String result = null;
		String regex = "(\\d)(?=.html)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(url);
		if (m.find()) {
			int i = Integer.parseInt(m.group(1));
			result = m.replaceFirst(String.valueOf(++i));
		}
		System.out.println(result);
		return result;
	}
}
