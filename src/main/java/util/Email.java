package util;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	//mail:st4460623@gmail.com
	// pass:  jmgq rwhj kgcx rklg
	
	final static String from = "st4460623@gmail.com";// noi gui
	final static String password= "jmgq rwhj kgcx rklg";
	
	public static boolean sendEmail(String to,String title,String content) {
		
		//Properties: Khai bao thuoc tinh
		
		//Giao thuc : SMTP, POP3, IMAP
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP host
		props.put("mail.smtp.port", "587"); // TLS: 587(google) , SSL: 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// create Authenticator
		javax.mail.Authenticator auth =  new javax.mail.Authenticator() {

			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
				return new javax.mail.PasswordAuthentication(from, password);
			}
					
		};
		
		//Phien lam` viec
		Session session = Session.getInstance(props, auth);
		
		//Gui email den: levandai2692003@gmail.com
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.addHeader("Content-type", "text/html; charset = UTF-8");
			msg.setFrom(from);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));// noi nhan
		
			msg.setSubject(title);	//Tieu de
			msg.setSentDate(new Date());  // ngay` gui
			//msg.setReplyTo(InternetAddress.parse(from,false));
			// Noi dung
				msg.setContent(content,"text/html; charset=UTF-8");

			//Gui mail
			Transport.send(msg);
			System.out.println("Send success");
			return true;
			
		} catch (MessagingException e) {
			System.out.println("Send fail");
			e.printStackTrace();
			return false;
		}
		
	}
	public static void main(String[] args) {
		
		Email.sendEmail("levandai2692003@gmail.com", "Mail được gửi từ mail khác", "Đây là nội dung");
	}
}
