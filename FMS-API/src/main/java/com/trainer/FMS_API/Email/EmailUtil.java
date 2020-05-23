package com.trainer.FMS_API.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	MailSender mailSender;

	@Autowired
	JavaMailSender javaMailSender;

	public boolean sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(fromAddress);
		simpleMailMessage.setTo(toAddress);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(msgBody);

		try {
			log.info("Main send is ={}", simpleMailMessage);
			mailSender.send(simpleMailMessage);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public void sendEmailWithAttactment(String toAddress, String fromAddress, String subject, String msgBody,
			String attachment) {

		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(fromAddress);
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(msgBody);

			FileSystemResource file = new FileSystemResource(attachment);
			helper.addAttachment(file.getFilename(), file);

		} catch (MessagingException e) {
			throw new MailParseException(e);
		}

		javaMailSender.send(message);
	}

}
