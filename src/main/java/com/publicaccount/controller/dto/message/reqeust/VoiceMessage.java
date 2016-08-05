package com.publicaccount.controller.dto.message.reqeust;

public class VoiceMessage extends BaseMessage {
	private String mdeiaId;
	private String format;
	private String recognition;
	
	public String getMdeiaId() {
		return mdeiaId;
	}
	public void setMdeiaId(String mdeiaId) {
		this.mdeiaId = mdeiaId;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
}
