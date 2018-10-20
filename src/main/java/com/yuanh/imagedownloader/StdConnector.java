package com.yuanh.imagedownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class StdConnector {
	
	public InputStream getImage(URL url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			conn.setRequestProperty("Referer", "ttps://www.nvshens.com/g/27828/2.html");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
			return conn.getInputStream();
	}
}
