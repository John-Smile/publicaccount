package com.publicaccount.service.email.impl;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.publicaccount.service.email.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Value("${email.account:}")
	private String from;
	@Value("${email.pass:}")
	private String pass;
	private Session session;
	private Transport transport;
	
	@Autowired
	public EmailServiceImpl(@Value("${email.account:}") String from, @Value("${email.pass:}") String pass) throws NoSuchProviderException {
		this.from = from;
		this.pass = pass;
		session = configSession(from, pass);
		transport = session.getTransport("smtp");
	}
	
//	public static void main(String[] args) throws Exception {
//		Session session = configSession("", "");
//		Multipart content = configMesssageBody("Kindle pdf", "The C Programming Language", "E:\\document\\book\\C\\The C Programming Language.pdf");
//		MimeMessage message = configMessage(session, new String[]{""}, "kindle push", content);
//		sendFrom126(session, message);
//	}
	
	public void sendFrom163(MimeMessage message) throws MessagingException {
		transport.connect(session.getProperty("mail.smtp.host"),
				          session.getProperty("mail.smtp.user"),
				          session.getProperty("mail.smtp.password"));
		transport.sendMessage(message, message.getAllRecipients());
	}
	
	private MimeMessage configMessage(String[] to, String subject, Multipart content) throws AddressException, MessagingException {
		
		MimeMessage message = new MimeMessage(session);
		// 发件地址
		message.setFrom(new InternetAddress(session.getProperty("mail.smtp.user")));
		// 收件地址
		for( int i = 0; i < to.length; i++ ) {
			InternetAddress address = new InternetAddress(to[i]);
			message.addRecipient(Message.RecipientType.TO, address);
		}
		// 邮件主题
		message.setSubject(subject);
		// 邮件内容
		message.setContent(content);
		
		return message;
	}

	@SuppressWarnings("unused")
	private Multipart configMesssageBody(String body, String fileName, String filePath) throws MessagingException {
		
		Multipart multipart = new MimeMultipart();
		// 文本内容
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(body);
		multipart.addBodyPart(messageBodyPart);
		// 附件
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(filePath);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(fileName);
		multipart.addBodyPart(messageBodyPart);

		return multipart;
	}
	
    @SuppressWarnings("unused")
	private Multipart configMesssageBody(String body, String fileName, byte[] file, String contentType) throws MessagingException {
		
		Multipart multipart = new MimeMultipart();
		// 文本内容
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(body);
		multipart.addBodyPart(messageBodyPart);
		// 附件
		messageBodyPart = new MimeBodyPart();
		DataSource source = new ByteArrayDataSource(file, contentType);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(fileName);
		multipart.addBodyPart(messageBodyPart);

		return multipart;
	}
    
    private Multipart configMesssageBody(String fileName, byte[] file, String contentType) throws MessagingException {
		
		Multipart multipart = new MimeMultipart();
		// 附件
		BodyPart messageBodyPart = new MimeBodyPart();
		DataSource source = new ByteArrayDataSource(file, contentType);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(fileName);
		multipart.addBodyPart(messageBodyPart);

		return multipart;
	}

	private Session configSession(String from, String pass) {
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		String host = "smtp.126.com";
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
		return session;
	}

	@Override
	public void sendFile(String emailAddr, String fileName, byte[] file) {
		try {
			Multipart content = configMesssageBody(fileName, file, "application/pdf");
			MimeMessage message = configMessage(new String[]{emailAddr}, fileName, content);
			sendFrom163(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
