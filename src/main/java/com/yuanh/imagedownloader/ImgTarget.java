package com.yuanh.imagedownloader;

public class ImgTarget {
	public String parentTag;
	public String targetTag;
	public String attr;
	
	public ImgTarget()
	{
		
	}
	public ImgTarget(String parentTag, String targetTag, String attr) {
		super();
		this.parentTag = parentTag;
		this.targetTag = targetTag;
		this.attr = attr;
	}
	public void setParentTag(String parentTag) {
		this.parentTag = parentTag;
	}
	public void setTargetTag(String targetTag) {
		this.targetTag = targetTag;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getParentTag() {
		return parentTag;
	}
	public String getTargetTag() {
		return targetTag;
	}
	public String getAttr() {
		return attr;
	}
	
	
}
