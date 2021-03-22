package com.dev.warehouse.utils;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailSendUtil {

	/**
	 * 
	 * @param subject 邮件标题
	 * @param mailContent  邮件本文 
	 * @param sendToMailAddress 收件邮箱地址
	 * @param senderMailAddress 发件邮件地址
	 * @param senderMailPass 发件邮件密码
	 * @param senderMailNickname 发件邮件昵称
	 * @param serverAddress 服务器地址
	 * @throws Exception
	 */
	public void sendSimpleMail(String subject,String mailContent,
			String sendToMailAddress,String senderMailAddress, String senderMailPass,
			String senderMailNickname,String serverAddress) throws Exception {
		//准备环境
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		//properties.setProperty("mail.debug", "true");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		//制造会话
		Session session = Session.getInstance(properties);
		//制造火箭
		Transport transport = session.getTransport();
		transport.connect(serverAddress, 465, senderMailAddress, senderMailPass);	
		//制造卫星
		MimeMessage	message = new MimeMessage(session); 
		message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
		message.setFrom(new InternetAddress("\"" + 
				MimeUtility.encodeText(senderMailNickname)  + 
				"\" <" + senderMailAddress +">"));
		//件名を設定する
		message.setSubject(subject);
		
		MimeMultipart mmp= new MimeMultipart("mixed");
		message.setContent(mmp);
		//邮件本文
		MimeBodyPart mimeBodyPart =new MimeBodyPart();
		mimeBodyPart.setText(mailContent);
		mmp.addBodyPart(mimeBodyPart);
		//保存邮件变化
		message.saveChanges();
		message.setRecipients(RecipientType.TO, 
				new Address[]{new InternetAddress(sendToMailAddress)});
		transport.sendMessage(message,new Address[]{new InternetAddress(sendToMailAddress)});
		transport.close();
	}
}
