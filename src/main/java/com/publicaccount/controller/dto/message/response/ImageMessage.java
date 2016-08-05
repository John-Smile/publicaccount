package com.publicaccount.controller.dto.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ImageMessage extends BaseMessage {
	@XStreamAlias("Image")
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
