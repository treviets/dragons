package net.dragons.service.impl;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.dto.BookingDto;
import net.dragons.jpa.entity.Room;
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
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
	
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");  

	public void loadICalendarFile() throws Exception {
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
					
					BookingDto dto = new BookingDto();
					dto.setRoomId(room.getId());
					dto.setHomeId(room.getHomeId());
					dto.setFromDate(DF.format(fromDate));
					dto.setToDate(DF.format(toDate));
					
					//bookingService.create(dto);
					
				}
			}
		}
		

	}


}
