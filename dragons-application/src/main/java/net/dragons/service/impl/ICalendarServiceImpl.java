package net.dragons.service.impl;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.BnbBooking;
import net.dragons.jpa.entity.Room;
import net.dragons.service.BnbBookingService;
import net.dragons.service.ICalendarService;
import net.dragons.service.RoomService;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;

@Service
public class ICalendarServiceImpl implements ICalendarService {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private BnbBookingService bnbBookingService;
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
	
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");  

	@Scheduled(fixedDelay=5*60*1000)
	public void loadICalendarFile() throws Exception {
		// Delete all booking
		bnbBookingService.deleteAll();
		
		// Insert new booking
		List<Room> rooms = roomService.getByHomeId(Long.valueOf(1));
		
		for (int i = 0; i < rooms.size(); i++) {
			System.setProperty("ical4j.unfolding.relaxed", "true");
			
			Room room = rooms.get(i);
			InputStream is = new URL(room.getCalendar()).openStream();
			CalendarBuilder builder = new CalendarBuilder();
			Calendar calendar = builder.build(is);

			for (Iterator<?> itr = calendar.getComponents().iterator(); itr.hasNext();) {
				Component component = (Component) itr.next();

				Property pStart = component.getProperty("DTSTART");
				Property pEnd = component.getProperty("DTEND");
				Property pSummary = component.getProperty("SUMMARY");
				
				if (pStart != null && pEnd != null && pSummary != null) {
					String strFrom = pStart.getValue();
					Date fromDate = SDF.parse(strFrom);
					
					String strTo = pEnd.getValue();
					Date toDate = SDF.parse(strTo);
					
					String strSummary = pSummary.getValue();
					
					BnbBooking bnb = new BnbBooking();
					bnb.setHomeId(room.getHomeId());
					bnb.setRoomId(room.getId());
					bnb.setFromDate(fromDate);
					bnb.setToDate(toDate);
					bnb.setSummary(strSummary);
					
					bnbBookingService.create(bnb);
					
				}
			}
		}
		

	}


}
