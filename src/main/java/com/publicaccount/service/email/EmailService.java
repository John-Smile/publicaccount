package com.publicaccount.service.email;

public interface EmailService {
	
	void sendFile(String emailAddr, String fileName, byte[] file);

}
