package net.dragons.service.impl;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import net.dragons.service.ICalendarService;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;


@Service
public class ICalendarServiceImpl implements ICalendarService {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
	
	public void loadICalendarFile() {
		CalendarBuilder builder = new CalendarBuilder();
		
		try {
			
			FileInputStream fin = new FileInputStream("/listing-31274588.ics");
			Calendar calendar = builder.build(fin);
			
			for (Iterator<?> itr = calendar.getComponents().iterator(); itr.hasNext();) {
				Component component = (Component) itr.next();
				Date start = SDF.parse(component.getProperty("DTSTART").getValue());
	            Date end = SDF.parse(component.getProperty("DTEND").getValue());
	            String summary = component.getProperty("SUMMARY").getValue();
	            
	            System.out.println("added "+start+end+summary);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	

}
