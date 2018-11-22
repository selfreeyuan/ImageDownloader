package com.yuanh.imagedownloader;

import java.util.ArrayList;
import java.util.List;

public class StdImageDownloader extends Downloader {
	List<String> htmlList = new ArrayList<String>();
	String sampleURL; // 任意HTML地址
	int currentSeq = 0; // 默认的连续HTML序列号的开头号码
	int tryTimes = 3;
	int failTimes = 0;
	String separator = null;

	public List<String> buildHtmlList(String sampleURL) throws Exception {
		this.sampleURL = sampleURL;
		if (buildBeginPages() != false) {
			currentSeq++;
			ImageUrlEntity e = ImageUrlTool.parese(sampleURL);
			e.setSeparator(this.separator);
			e.setImgSeq(String.valueOf(currentSeq));
			e.buildFullUrl();

			while (e.exists()) {
				htmlList.add(e.getFullUrl());
				currentSeq++;
				e.setSeparator(separator);
				e.setImgSeq(currentSeq);
				e.buildFullUrl();
			}
		}
		return htmlList;
	}

	private boolean buildBeginPages() throws Exception {
		ImageUrlEntity e = ImageUrlTool.parese(sampleURL);

//		尝试没有任何序列号的HTML网址
		e.setSeparator("");
		e.setImgSeq("");
		if (e.exists()) {
			// 判断分隔符是否存在
			if ((this.separator = e.getSeparator()) == "") {
				// 使用默认分隔符“-”
				separator = "-";
			} else {
				// 使用已经捕获的分隔符
				this.separator = e.getSeparator();
			}
			e.buildFullUrl();
			htmlList.add(e.getFullUrl());
		} else {
			throw new Exception("URL doesn't Exists");
		}

//		尝试开始序列号为0,1,2的HTML网址，分隔符有可能为中划线“-”
		for (int i = 0; i < tryTimes; i++) {
			e.setSeparator(separator);
			e.setImgSeq(i);
			e.buildFullUrl();

			if (e.exists()) {
				e.buildFullUrl();
				currentSeq = i;
				htmlList.add(e.getFullUrl());
			} else {
				failTimes++;
			}
		}

		// 如果成功次数大于1次，少于默认失败次数，说明分隔符是对的
		if ((tryTimes - failTimes) > 0) {
			return true;
		}

//		如果以上全失败，分隔符不对，尝试用下划线“_”
		if (failTimes >= tryTimes) {
			for (int i = 0; i < tryTimes; i++) {
				e.setSeparator("_");
				e.setImgSeq(i);
				e.buildFullUrl();

				if (e.exists()) {
					e.buildFullUrl();
					currentSeq = i;
					htmlList.add(e.getFullUrl());
				} else {
					failTimes++;
				}
			}
		}

		return false;
	}

	public void imageDownload(ArrayList<String> list, int seq, String format) throws Exception {
		if (this.writer == null) {
			throw new Exception("Writer can not be null");
		}
	}

	public void setWriter(ImageWriter writer) {
		this.writer = writer;
	};

	public void setTryTimes(int tryTimes) {
		this.tryTimes = tryTimes;
	}

	public void setFailTimes(int failTimes) {
		this.failTimes = failTimes;
	}

}
