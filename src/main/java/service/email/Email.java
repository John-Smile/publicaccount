package service.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	
	public static void main(String[] args) throws Exception {
		Session session = configSession("from", "pass");
		Multipart content = configMesssageBody("body", "fileName", "filePath");
		MimeMessage message = configMessage(session, new String[]{"to"}, "subject", content);
		sendFrom126(message);
	}
	
	public static void sendFrom126(MimeMessage message) throws MessagingException {
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host, from, pass);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
		Transport.send(message);
	}

	public static MimeMessage configMessage(Session session, String[] to,
			                                String subject, Multipart content) throws AddressException, MessagingException {
		
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

	public static Multipart configMesssageBody(String body, String fileName, String filePath) throws MessagingException {
		
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

	public static Session configSession(String from, String pass) {
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

}
