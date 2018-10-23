package com.yuanh.imagedownloader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CrawlerTest {

	@Test
	public void testCrawler() throws MalformedURLException, Exception {
		StdConnector connector = new StdConnector();
		ConnProperties properties = new ConnProperties();
		properties.setProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		connector.setProperties(properties);

		InputStream in = connector.getImageStream(new URL("https://www.yuleba.org/a/211-1450-0.html"));

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String str = null;
		String target = null;
		while ((str = reader.readLine()) != null) {
			if (str.indexOf("<div class=\"picture\">") != -1) {
				target = reader.readLine();
			}
		}
	}

	public String parseURL(String url) {
		String pattern = "(https[a-z0-9:/.]+)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(url);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}
}
