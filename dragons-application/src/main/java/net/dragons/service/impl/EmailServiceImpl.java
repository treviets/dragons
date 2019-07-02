package net.dragons.service.impl;

import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import net.dragons.constant.TheDragonHostConstant;
import net.dragons.dto.BookingEmailDto;
import net.dragons.jpa.entity.Booking;
import net.dragons.jpa.entity.Configuration;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.Room;
import net.dragons.jpa.entity.RoomImage;
import net.dragons.service.ConfigurationService;
import net.dragons.service.EmailService;
import net.dragons.service.RoomImageService;
import net.dragons.service.RoomService;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	RoomImageService roomImageService;
	
	@Autowired 
	RoomService roomService;
	
	@Autowired
	ConfigurationService configurationService;
	
	@Override
	public void sendBookingEmail(BookingEmailDto dto) {

		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setFrom(new InternetAddress(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_FROM, TheDragonHostConstant.ADMIN_BOOKING_EMAIL_NAME));
				
				messageHelper.setSubject(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_TITLE);
//				messageHelper.setCc(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_IN_CC_LIST);
				
				String content = prepareEmailData(dto);
				messageHelper.setText(content, true);
				
				messageHelper.setTo("vunhankhtn@gmail.com");
			}
		});
	}
	
	private String prepareEmailData(BookingEmailDto dto) {
		String emailContent = getEmailContent();
		emailContent = emailContent.replaceAll("#booking_status#", "Confirmed");
		
		Customer customer = dto.getCustomer();
		if (customer != null) {
			String customerName = dto.getCustomer().getFirstName() + dto.getCustomer().getLastName();
			emailContent = emailContent.replaceAll("#customer_name#", customerName);
		}
		
		Booking booking = dto.getBooking();
		if (booking != null) {
			String fromDate = booking.getFromDate().toString();
			String toDate = booking.getToDate().toString();
			String numberOfNight = booking.getNumberOfNights().toString();
			String numberOfGuest = booking.getNumberOfGuess().toString();
			
			emailContent = emailContent.replaceAll("#from_date#", fromDate);
			emailContent = emailContent.replaceAll("#to_date#", toDate);
			emailContent = emailContent.replaceAll("#number_of_night#", numberOfNight);
			emailContent = emailContent.replaceAll("#number_of_guest#", numberOfGuest);
			emailContent = emailContent.replaceAll("#pick_up#", "Yes");
		}
		
		Room room = roomService.findById(booking.getRoomId());
		if (room != null) {
			Double cleaningFee = Double.valueOf(20);
			Double serviceFee = Double.valueOf(15);
			Double roomPrice = Double.parseDouble(room.getPrice());
			Double roomAmount = roomPrice * booking.getNumberOfNights();
			Double totalAmount = roomAmount + cleaningFee + serviceFee;
			
			emailContent = emailContent.replaceAll("#room_fee#", roomPrice.toString());
			emailContent = emailContent.replaceAll("#clearning_fee#", cleaningFee.toString());
			emailContent = emailContent.replaceAll("#service_fee#", serviceFee.toString());
			emailContent = emailContent.replaceAll("#room_amount#", roomAmount.toString());
			emailContent = emailContent.replaceAll("#total_amount#", totalAmount.toString());
		}
		
		List<Configuration> configs = configurationService.findAll();
		for (int i = 0; i < configs.size(); i++) {
			if (configs.get(i).getKey().equals("WIFI_NAME")) {
				emailContent = emailContent.replaceAll("#wifi_name#", configs.get(i).getValue());
			}
			if (configs.get(i).getKey().equals("WIFI_PASS")) {
				emailContent = emailContent.replaceAll("#wifi_pass#", configs.get(i).getValue());
			}
		}
		
		emailContent = emailContent.replaceAll("#room_code#", "Yes");
		emailContent = emailContent.replaceAll("#room_address#", "Yes");
		emailContent = emailContent.replaceAll("#passlock#", "Yes");
		
		
		List<RoomImage> images = roomImageService.findByRoomId(booking.getRoomId());
		String imageList = "";
		for (int i = 0; i < 5; i++) {
			String base = "<img class='footer-image' src='#image_src#'/>";
			String src = "http://tdh.thedragonshost.com:8080/dragons/" + images.get(i).getImage();
			
			base = base.replace("#image_src#", src);
			imageList = imageList + base;
		}
		emailContent = emailContent.replaceAll("#room_images#", imageList);
		
		return emailContent;
	}
	
	private static String getEmailContent() {
		String email = "<!DOCTYPE html> <html lang='en'><head><meta charset='utf-8'> <title>Welcome to The dragons host</title> <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"
				+ " <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>"
				+ " <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>"
				+ " <style> body { color: #7e5d25; } .header .title { text-align: center;} .header .title strong { font-size: 20px;} .summary .title { margin-top: 20px; }"
				+ " .summary .title {text-align: center;} .summary .title strong, .apart-information .title strong, .price-information .title strong, .cancel-policy .title strong {font-size: 30px;}"
				+ " .row { margin-right: 0px; margin-left: 0px;} .footer-image { margin-left: 10px; margin-right: 10px; width: 120px; height: 80px;} .header-background { background-image: url(https://d1nabgopwop1kh.cloudfront.net/hotel-asset/10000003003349773_wh_4); }"
				+ " .header-logo { width: 100px; height: 100px; border-radius: 50%;} </style> </head>"
				+ "<body><div class='container' style='width: 750px;'><div class='header row header-background' style='height: 135px;'>"
				+ "<div class='title'><img class='header-logo' src='http://tdh.thedragonshost.com:8080/dragons/static/logo/header.png'/><br><strong>Thank your for booking with The Dragons Host</strong></div></div>"
				+ "<div class='summary row' style='border-bottom: 1px solid #7e5d25;'><div class='title'><strong>Reservation Summary</strong></div><div class='row no-margin-lr'>"
				+ "<div class='col-xs-6 text-right'><p>Reservation Status: </p><p>Guest Name: </p><p>Check-in Date/Time: </p><p>Check-out Date/Time: </p><p>Nights: </p><p>Guest Number: </p><p>Pick up: </p></div>"
				+ "<div class='col-xs-6 text-left'><p>#booking_status#</p><p>#customer_name#</p><p>#from_date#</p><p>#to_date#</p><p>#number_of_night#</p><p>#number_of_guest#</p><p>#pick_up#</p></div>"
				+ "<div class='text-center'><img src='http://tdh.thedragonshost.com:8080/dragons/static/logo/background.png' style='width: 400px;height: 200px;'/><p style='margin-top: 15px;'>Your trip is almost here and we can't wait to host you in beatiful Ho Chi Minh City!</p>	</div></div></div>"
				+ "<div class='apart-information row' style='border-bottom: 1px solid #7e5d25;'><div class='title text-center'><strong>Apartment Information</strong></div>"
				+ "<div class='col-xs-6 text-right'><p>Apartment Code: </p><p>Address: </p><p>Passlock/ Keypad: </p><p>Wifi: </p><p>Password: </p></div>"
				+ "<div class='col-xs-6 text-left'><p>#room_code# </p><p>#room_address#</p><p>#passlock#</p><p>#wifi_name#</p><p>#wifi_pass</p></div></div>"
				+ "<div class='price-information row' style='border-bottom: 1px solid #7e5d25;'><div class='title text-center'><strong>Price Information</strong></div>"
				+ "<div class='col-xs-6 text-left'><p>$#room_fee# x #number_of_night# nights </p><p>Cleaning fee: </p><p>Service fee: </p><strong>Total: </strong></div>"
				+ "<div class='col-xs-6 text-right'><p>#room_amount#</p><p>$#clearning_fee#</p><p>$#service_fee#</p><strong>$#total_amount#</strong></div></div>"
				+ "<div class='cancel-policy row text-center'><div class='title text-center'><strong>Cancellation Policy</strong></div><p class='text-center'>Please note you are within cancellation penalty of 1 night/s fee. No show is subject to 1 night/s fee</p>"
				+ "<strong class='text-center' style='font-size: 30px;'>We're here for you 24/7</strong><p>Have a question? Chat online with one of our guest services team or email us at cs@thedragonshost.com</p>"
				+ "<p><strong>And don't forget to post your pictures and video to our Facebook and Instagram</strong></p><p><strong>Facebook: </strong>www.facebook.com/thedragonshost/</p><p><strong>Instagram: </strong>thedragonshost</p></div>"
				+ "<div class='footer row text-center' style='margin-bottom: 50px;margin-top:15px;'>#{room_images}#</div></div></body></html>";
	
		return email;
	}
	
	
	
}
