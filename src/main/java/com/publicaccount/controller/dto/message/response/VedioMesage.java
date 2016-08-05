package com.publicaccount.controller.dto.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class VedioMesage extends BaseMessage {
	@XStreamAlias("Vedio")
	private Vedio vedio;

	public Vedio getVedio() {
		return vedio;
	}

	public void setVedio(Vedio vedio) {
		this.vedio = vedio;
	}

}
