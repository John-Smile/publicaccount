package com.publicaccount.service.push.dto;

import com.publicaccount.service.search.dto.BookDTO;

public class PushCarrier {
	private String[] emailAddr;
	private BookDTO book;
	
	public PushCarrier(String[] emailAddr, BookDTO book) {
		super();
		this.emailAddr = emailAddr;
		this.book = book;
	}
	
	public String[] getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String[] emailAddr) {
		this.emailAddr = emailAddr;
	}
	public BookDTO getBook() {
		return book;
	}
	public void setBook(BookDTO book) {
		this.book = book;
	}

}
