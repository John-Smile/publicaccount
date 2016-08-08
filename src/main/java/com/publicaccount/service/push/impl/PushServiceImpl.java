package com.publicaccount.service.push.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.publicaccount.service.email.EmailService;
import com.publicaccount.service.push.PushService;
import com.publicaccount.service.push.dto.PushCarrier;

@Service
public class PushServiceImpl implements PushService {
	@Resource
	private EmailService emailService;
	private ExecutorService executor = Executors.newCachedThreadPool();

	@Override
	public void push(PushCarrier pushCarrier) {
		executor.execute(new PushTask(pushCarrier, emailService));
	}
}
