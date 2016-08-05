package com.publicaccount.controller.dto.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class VoiceMessage extends BaseMessage {
	@XStreamAlias("Voice")
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}
