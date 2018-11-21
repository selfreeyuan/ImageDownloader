package com.yuanh.imagedownloader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageUrlEntity {
	String fullUrl = null;
	String rootUrl = null; // HTML根地址
	String serialSeq = null; // 专辑序列号
	String separator = null; // 专辑与图片序列号之间的分隔符，一般为"_"
	String imgSeq = null; // HTML序列号
	String suffix = null;

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

	public ImageUrlEntity(String rootUrl, String serialSeq, String separator, String imgSeq, String suffix) {
		fullUrl = rootUrl + serialSeq + separator + imgSeq + "." + suffix;
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

	public String getSourceUrl() {
		return fullUrl;
	}

	public void buildFullUrl() {
		fullUrl = rootUrl + serialSeq + separator + imgSeq + "." + suffix;
	}

}
