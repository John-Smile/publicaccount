package com.publicaccount.controller.dto.message.reqeust;

public class QRCodeEvent extends BaseEvent {
	private String eventKey;
	private String ticket;
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
