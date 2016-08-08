package com.publicaccount.service.email;

import com.publicaccount.service.search.dto.BookDTO;

public interface EmailService {
	
	void sendFile(String[] emailAddr, BookDTO book);

}
