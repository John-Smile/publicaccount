package com.publicaccount.service.push.impl;

import com.publicaccount.service.email.EmailService;
import com.publicaccount.service.push.dto.PushCarrier;
import com.publicaccount.service.search.dto.BookDTO;


public class PushTask implements Runnable {
	private PushCarrier pushCarrier;
	private EmailService emailService;
	
	public PushTask(PushCarrier pushCarrier, EmailService emailService) {
		this.pushCarrier = pushCarrier;
		this.emailService = emailService;
	}

	@Override
	public void run() {
		BookDTO book = pushCarrier.getBook();
		emailService.sendFile(pushCarrier.getEmailAddr(), book);
	}

}
