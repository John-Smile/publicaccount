package com.publicaccount.controller.dto.message.reqeust;

public class MenuEvent extends BaseEvent {
	private String eventKey;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
