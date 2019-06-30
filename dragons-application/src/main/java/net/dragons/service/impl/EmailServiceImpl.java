package net.dragons.service.impl;

import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import net.dragons.constant.TheDragonHostConstant;
import net.dragons.dto.BookingEmailDto;
import net.dragons.jpa.entity.Customer;
import net.dragons.service.EmailService;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendBookingEmail(BookingEmailDto dto) {

		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setFrom(new InternetAddress(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_FROM, TheDragonHostConstant.ADMIN_BOOKING_EMAIL_NAME));
				
				Customer customer = dto.getCustomer();
				if (customer != null) {
					String toEmail = customer.getEmail();
					messageHelper.setTo(toEmail);
					
					String customerName = customer.getFirstName() + customer.getLastName();
				}
				
				
				messageHelper.setSubject(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_TITLE);
//				messageHelper.setCc(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_IN_CC_LIST);
				
				Multipart multipart = new MimeMultipart();
				 
				MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(messageHelper, "\\static\\email\\booking.html");
				
				multipart.addBodyPart(htmlPart);
				
				mimeMessage.setContent(multipart);
				
				Transport.send(mimeMessage);
			}
		});
	}
}
