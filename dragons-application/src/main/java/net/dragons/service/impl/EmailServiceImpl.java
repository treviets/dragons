package net.dragons.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import net.dragons.service.EmailService;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void send(String title, String content, String toEmail) {

		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setFrom("admin@thedragonshost.com");
				messageHelper.setTo(toEmail);
				messageHelper.setSubject(title);
				messageHelper.setCc("cs@thedragonshost.com");
				messageHelper.setText(content, true);
			}
		});
	}
}
