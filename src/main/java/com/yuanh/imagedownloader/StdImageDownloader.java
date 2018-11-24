package com.yuanh.imagedownloader;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StdImageDownloader extends Downloader {
	List<String> imgList = new ArrayList<String>();
	ConnProperties properties = null;
	ImgTarget target = null;
	String sampleURL; // 任意HTML地址
	int currentSeq = 0; // 默认的连续HTML序列号的开头号码
	int tryTimes = 3;
	int failTimes = 0;
	String separator = null;

	public List<String> buildImgList(String sampleURL) throws Exception {
		this.sampleURL = sampleURL;
		if (buildBeginPages() != false) {
			currentSeq++;
			UrlEntity e = ImageUrlTool.parese(sampleURL);
			e.setSeparator(this.separator);
			e.setImgSeq(String.valueOf(this.currentSeq));
			e.buildFullUrl();

			while (e.exists()) {
				String htmlUrl = e.getFullUrl();
				List<String> temp = digImgUrl(htmlUrl);
				if (!temp.isEmpty()) {
					this.imgList.addAll(temp);
					this.currentSeq++;
					e.setSeparator(this.separator);
					e.setImgSeq(this.currentSeq);
					e.buildFullUrl();
				} else {
					return this.imgList;
				}
			}
		}
		return this.imgList;
	}

	private boolean buildBeginPages() throws Exception {
		UrlEntity e = ImageUrlTool.parese(sampleURL);

		//尝试获取分隔符
		if (e.getSeparator() != null) {
			this.separator = e.getSeparator();
		} else {
			this.separator = "-";
		}
		
//		尝试没有任何序列号的HTML网址
		e.setSeparator("");
		e.setImgSeq("");
		e.buildFullUrl();
		if (e.exists()) {
			this.imgList.addAll(digImgUrl(e.getFullUrl()));
		}

		// 尝试开始序列号为0,1,2的HTML网址，分隔符有可能为中划线“-”
		tryUrls(e, this.separator);

		// 如果成功次数大于1次，少于默认失败次数，说明分隔符是对的
		if ((tryTimes - failTimes) > 0) {
			return true;
		}

		// 重置失败计算器
		failTimes = 0;

		// 如果以上全失败，分隔符不对，尝试用下划线“_”
		this.separator = "_";
		tryUrls(e, this.separator);

		// 如果成功次数大于1次，少于默认失败次数，说明分隔符是对的
		if ((tryTimes - failTimes) > 0) {
			return true;
		}

		return false;
	}

	public void imageDownload(String sampleUrl,int seq) throws Exception {
		if (this.writer == null) {
			throw new Exception("Writer can not be null");
		}
		List<String> list  = buildImgList(sampleUrl);
		int fileSeq = 0;
		for(String imgURL:list) {
			Connector conn = new StdConnector(new URL(imgURL));
			conn.setProperties(properties);
			InputStream in = conn.getInpustream();
			writer.writeImage(in, writer.getPath()+seq+String.format("%03d", fileSeq)+".jpg");
			fileSeq++;
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

	public boolean checkEnd(List<String> list) {
		if (list != null) {
			return true;
		}

		return false;
	}

	public void setImgTarget(ImgTarget target) {
		this.target = target;
	}

	public void setProperties(ConnProperties properties) {
		this.properties = properties;
	}

	private List<String> digImgUrl(String htmlUrl) throws Exception {
		ImgUrlFinder finder = new ImgUrlFinder();
		Connector conn = new StdConnector(new URL(htmlUrl));
		conn.setProperties(properties);
		List<String> list = finder.findImgUrls(conn, target);
		return list;
	}

	private void tryUrls(UrlEntity e, String separater) throws Exception {
		if (failTimes <= tryTimes) {
			for (int i = 0; i < tryTimes; i++) {
				e.setSeparator(separater);
				e.setImgSeq(i);
				e.buildFullUrl();

				if (e.exists()) {
					String htmlUrl = e.getFullUrl();
					List<String> temp = digImgUrl(htmlUrl);
					if (!temp.isEmpty()) {
						imgList.addAll(temp);
					}
					currentSeq = i;
				} else {
					failTimes++;
				}
			}
		}
	}

}
