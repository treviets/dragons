package net.dragons.service.impl;

import java.text.SimpleDateFormat;
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
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.Home;
import net.dragons.jpa.entity.Room;
import net.dragons.jpa.entity.RoomImage;
import net.dragons.service.ConfigurationService;
import net.dragons.service.EmailService;
import net.dragons.service.HomeService;
import net.dragons.service.RoomImageService;
import net.dragons.service.RoomService;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	HomeService homeService;
	
	@Autowired
	RoomImageService roomImageService;
	
	@Autowired 
	RoomService roomService;
	
	@Autowired
	ConfigurationService configurationService;
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
	
	@Override
	public void sendBookingEmail(BookingEmailDto dto) {

		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				String toEmail = "";
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setFrom(new InternetAddress(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_FROM, TheDragonHostConstant.ADMIN_BOOKING_EMAIL_NAME));
				messageHelper.setSubject(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_TITLE);
//				messageHelper.setCc(TheDragonHostConstant.ADMIN_BOOKING_EMAIL_IN_CC_LIST);
				
				Customer customer = dto.getCustomer();
				if (customer != null) {
					toEmail = customer.getEmail();
				}

				String content = prepareEmailData(dto);
				
				messageHelper.setTo(toEmail);
				messageHelper.setText(content, true);
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
			String fromDate = SDF.format(booking.getFromDate());
			String toDate = SDF.format(booking.getToDate());
			String numberOfNight = booking.getNumberOfNights().toString();
			String numberOfGuest = booking.getNumberOfGuess().toString();
			Double cleaningFee = booking.getCleaningFee();
			Double serviceFee = booking.getServiceFee();
			Double roomPrice = booking.getPrice();
			Double roomAmount = roomPrice * booking.getNumberOfNights();
			Double totalAmount = roomAmount + cleaningFee + serviceFee;
			
			emailContent = emailContent.replaceAll("#from_date#", fromDate);
			emailContent = emailContent.replaceAll("#to_date#", toDate);
			emailContent = emailContent.replaceAll("#number_of_night#", numberOfNight);
			emailContent = emailContent.replaceAll("#number_of_guest#", numberOfGuest);
			emailContent = emailContent.replaceAll("#pick_up#", "Yes");
			
			emailContent = emailContent.replaceAll("#room_fee#", roomPrice.toString());
			emailContent = emailContent.replaceAll("#clearning_fee#", cleaningFee.toString());
			emailContent = emailContent.replaceAll("#service_fee#", serviceFee.toString());
			emailContent = emailContent.replaceAll("#room_amount#", roomAmount.toString());
			emailContent = emailContent.replaceAll("#total_amount#", totalAmount.toString());
		}
		
		Room room = roomService.findById(booking.getRoomId());
		if (room != null) {
			emailContent = emailContent.replaceAll("#room_code#", room.getCode());
		}
		
		Home home = homeService.findById(booking.getHomeId());
		if (home != null) {
			emailContent = emailContent.replaceAll("#wifi_name#", home.getWifiName());
			emailContent = emailContent.replaceAll("#wifi_pass#", home.getWifiPass());
			emailContent = emailContent.replaceAll("#passlock#", home.getPassLock());	
			emailContent = emailContent.replaceAll("#room_address#", home.getAddress());
		}
		
		List<RoomImage> images = roomImageService.findByRoomId(booking.getRoomId());
		
		String headerImages = "";
		String footerImages = "";
		for (int i = 0; i < 5; i++) {
			String src = "https://api.thedragonshost.com/dragons" + images.get(i).getImage();
			
			String baseHeader = "<img src='#image_src#' style='width: 20%;height: 100%;'/>";
			String baseFooter = "<img src='#image_src#' style='width: 20%; margin: 0;padding: 0;' />";
			
			baseFooter = baseFooter.replace("#image_src#", src);
			baseHeader = baseHeader.replace("#image_src#", src);
			
			footerImages = footerImages + baseFooter;
			headerImages = headerImages + baseHeader;
		}
	
		emailContent = emailContent.replaceAll("#room_header_images#", headerImages);
		emailContent = emailContent.replaceAll("#room_footer_images#", footerImages);
	
		String headerLogo = "https://api.thedragonshost.com/dragons/static/logo/header.png";
		String background = "https://api.thedragonshost.com/dragons/static/logo/background.png";
		emailContent = emailContent.replaceAll("#header_logo#", headerLogo);
		emailContent = emailContent.replaceAll("#background_logo#", background);
		
		return emailContent;
	}
	
	private static String getEmailContent() {
		return "<!DOCTYPE html><html lang='en'><head>	<meta charset='utf-8'>	<title>Welcome to The dragons host</title>	<style>		.header .title {			text-align: center;		}		.header .title strong {			font-size: 20px;		}		.summary .title {			margin-top: 20px;		}		.summary .title {			text-align: center;		}		.summary .title strong, 		.apart-information .title strong,		.price-information .title strong,		.cancel-policy .title strong		 {			font-size: 30px;		}		.row {			margin-right: 0px;    		margin-left: 0px;		}		.footer-image{			margin-left: 10px;    		margin-right: 10px;			width: 120px;			height: 80px;		}		.header-logo {			width: 100px;    		height: 100px;    		border-radius: 50%;		}	</style></head><body style='color: #7e5d25;'>	<div class='container' style='width: 800px;margin: auto;'>	"
				+ "	<div style='height: 150px;border: 2px solid currentColor;width: 100%;'>			<div style='width: 100%;height:100%;display: flex;opacity: 0.3;'>				#room_header_images#			</div>	"
				+ "		</div>		</div>		<div class='summary row' style='border-bottom: 1px solid #7e5d25;'>			<div class='title'>				<strong>Reservation Summary</strong>			</div>			<div class='row no-margin-lr'>				<div class='col-xs-6' style='width: 50%;float: left;text-align: right;'>					<p>Reservation Status: </p>					<p>Guest Name: </p>					<p>Check-in Date/Time: </p>					<p>Check-out Date/Time: </p>					<p>Nights: </p>					<p>Guest Number: </p>					<p>Pick up: </p>				</div>				<div class='col-xs-6 text-left' style='width: 50%;float: right;'>					<p>#booking_status# </p>					<p>#customer_name#</p>					<p>#from_date#</p>					<p>#to_date#</p>					<p>#number_of_night#</p>					<p>#number_of_guest#</p>					<p>#pick_up#</p>				</div>				<div class='text-center' style='width: 100%;text-align: center;'>					<img src='#background_logo#' style='width: 600px;height: 250px;'/>					<p style='margin-top: 15px;'>Your trip is almost here and we can't wait to host you in beautiful Ho Chi Minh City!</p>					</div>			</div>		</div>		<div class='apart-information row' style='border-bottom: 1px solid #7e5d25;display: inline-block;width: 100%;'>			<div class='title text-center' style='text-align: center;'>				<strong>Apartment Information</strong>			</div>			<div style='width: 100%;text-align: center;'>				<p>Apartment Code: #room_code#</p>				<p>Address: #room_address#</p>				<p>Passlock/ Keypad: #passlock#</p>				<p>Wifi: #wifi_name#</p>				<p>Password: #wifi_pass#</p>			</div>		</div>		<div class='price-information row' style='border-bottom: 1px solid #7e5d25;display: inline-block;width: 100%;'>			<div class='title text-center' style='text-align: center;'>				<strong>Price Information</strong>			</div>			<div class='col-xs-6 text-left' style='width: 50%;float: left;'>				<p>$#room_fee# x 6 nights </p>				<p>Cleaning fee: </p>				<p>Service fee: </p>				<strong>Total: </strong>			</div>			<div class='col-xs-6 text-right' style='width: 50%;float: right;text-align: right;'>				<p>$#room_amount# </p>				<p>$#clearning_fee# </p>				<p>$#service_fee#</p>				<strong>$#total_amount#</strong>			</div>		</div>		<div class='cancel-policy row text-center' style='border-bottom: 1px solid #7e5d25;display: inline-block;width: 100%; text-align: center;'>			<div class='title text-center' style='text-align: center;'>				<strong>Cancellation Policy</strong>			</div>			<p class='text-center'>Please note you are within cancellation penalty of 1 night/s fee. No show is subject to 1 night/s fee</p>		</div>		<div style='text-align: center;'>			<strong class='text-center' style='font-size: 30px;'>We're here for you 24/7</strong>			<p>Have a question? Chat online with one of our guest services team or email us at cs@thedragonshost.com</p>			<p><strong>And don't forget to post your pictures and video to our Facebook and Instagram</strong></p>			<p><strong>Facebook: </strong>www.facebook.com/thedragonshost/</p>			<p><strong>Instagram: </strong>thedragonshost</p>		</div>		<div class='footer row text-center' style='margin-bottom: 50px;margin-top:15px;width: 100%;display: flex;'>			#room_footer_images#		</div>	</div></body></html>";
	}
	
}
