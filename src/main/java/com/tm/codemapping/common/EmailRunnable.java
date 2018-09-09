package com.tm.codemapping.common;

import java.io.StringWriter;
import java.util.Properties;

import freemarker.core.ParseException;
import freemarker.template.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailRunnable implements Runnable {

	@Override
	public void run() {
		/*
		// TODO Auto-generated method stub
		try {			
			Properties properties = new Properties();
			properties.setProperty("mail.host", "smtp.qq.com");
			properties.setProperty("mail.transport.protocol", "smtp");
			properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.setProperty("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(properties);
            session.setDebug(true);
            Transport transport = session.getTransport();
            transport.connect("smtp.qq.com", "1510161612@qq.com", "授权码");
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.addRecipients(Message.RecipientType.TO, "");
            mimeMessage.setFrom("1510161612@qq.com");
            mimeMessage.setSubject("XXX集团：通知");
            MimeMultipart mixed = new MimeMultipart("mixed");
            mimeMessage.setContent(mixed);
            MimeBodyPart content = new MimeBodyPart();
            mixed.addBodyPart(content);
            MimeMultipart bodyMimeMultipart = new MimeMultipart("related");
            content.setContent(bodyMimeMultipart);
            MimeBodyPart bodyPart = new MimeBodyPart();
            //freemarker加载邮件模板
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
            cfg.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(),"ftl");
            //Template emailTemplate = cfg.getTemplate("email.ftl");
            StringWriter out = new StringWriter();
            //emailTemplate.process(employee,out);
            bodyPart.setContent(out.toString(),"text/html;charset=utf-8");
            bodyMimeMultipart.addBodyPart(bodyPart);
            mimeMessage.saveChanges();
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
		}catch(NoSuchProviderException e) {
			e.printStackTrace();
		}catch(MessagingException e) {
			e.printStackTrace();
		}*/
	}

}
