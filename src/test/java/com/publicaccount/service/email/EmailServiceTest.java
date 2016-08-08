package com.publicaccount.service.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.publicaccount.service.search.dto.BookDTO;


@ContextConfiguration(locations = {"classpath:config/publicaccount-context1.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailServiceTest {
	@Value("${emailAddr}")
    private String emailAddr;
	@Value("${fileName}")
	private String fileName;
	@Value("${filePath}")
	private String filePath;
	@Resource
	private EmailService emailService;
	
	@Test
	public void testSendFile() throws Exception {
		File file = new File(filePath);
		InputStream is = new FileInputStream(file);
		byte[] bFile = new byte[(int)file.length()];
		is.read(bFile);
		is.close();
		
		emailService.sendFile(new String[]{emailAddr}, new BookDTO(fileName, 1, bFile));
	}

}
