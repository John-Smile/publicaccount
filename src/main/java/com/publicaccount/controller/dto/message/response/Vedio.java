package com.publicaccount.controller.dto.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Vedio {
	@XStreamAlias("MediaId")
    private String mediaId;
	@XStreamAlias("ThumbMediaId")
    private String thumbMediaId;
	
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}
