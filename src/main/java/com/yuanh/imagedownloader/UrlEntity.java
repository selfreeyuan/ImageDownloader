package com.yuanh.imagedownloader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlEntity {
	private String fullUrl = null;
	private String rootUrl = null; // HTML根地址
	private String serialSeq = null; // 专辑序列号
	private String separator = null; // 专辑与图片序列号之间的分隔符，一般为"_"
	private String imgSeq = null; // HTML序列号
	private String suffix = null;

	public UrlEntity(String rootUrl, String serialSeq, String separator, String imgSeq, String suffix) {
		this.rootUrl = rootUrl;
		this.serialSeq = serialSeq;
		this.separator = separator;
		this.imgSeq = imgSeq;
		this.suffix = suffix;
		fullUrl = rootUrl + serialSeq + separator + imgSeq + "." + suffix;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public boolean exists() throws IOException {

		URL url = new URL(this.fullUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() == 200) {
			conn.disconnect();
			return true;
		}
		conn.disconnect();
		return false;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getRootUrl() {
		return rootUrl;
	}

	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
	}

	public String getSerialSeq() {
		return serialSeq;
	}

	public void setSerialSeq(String serialSeq) {
		this.serialSeq = serialSeq;
	}

	public String getImgSeq() {
		return imgSeq;
	}

	public void setImgSeq(String imgSeq) {
		this.imgSeq = imgSeq;
	}
	
	public void setImgSeq(int imgSeq) {
		this.imgSeq = String.valueOf(imgSeq);
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void buildFullUrl() {
		fullUrl = rootUrl + serialSeq + separator + imgSeq + "." + suffix;
	}

}
