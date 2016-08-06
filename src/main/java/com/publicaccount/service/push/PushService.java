package com.publicaccount.service.push;

public interface PushService {
	
	void push(String[] emailAddress, String fileName, byte[] file);

}
