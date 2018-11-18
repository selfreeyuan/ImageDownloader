package com.yuanh.imagedownloader;

public class ImageUrlEntity {
	String rootUrl = null; //HTML根地址
	String serialSeq = null; //专辑序列号
	String imgSeq = null; //HTML序列号
	String suffix = null;
	
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

}
