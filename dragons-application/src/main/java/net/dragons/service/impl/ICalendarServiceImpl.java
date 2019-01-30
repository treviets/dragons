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
import net.fortuna.ical4j.model.Property;


@Service
public class ICalendarServiceImpl implements ICalendarService {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
	
	public void loadICalendarFile() {
		CalendarBuilder builder = new CalendarBuilder();
		
		try {
			
			FileInputStream fin = new FileInputStream("D:\\Projects\\Workspace\\the_dragon\\example.ics");
			Calendar calendar = builder.build(fin);
			
			for (Iterator<?> itr = calendar.getComponents().iterator(); itr.hasNext();) {
				Component component = (Component) itr.next();

				Property pStart = component.getProperty("DTSTART");
				if (pStart != null) {
					String strStart = pStart.getValue();
				}
				
				Property pEnd = component.getProperty("DTEND");
				if (pEnd != null) {
					String strEnd = pEnd.getValue();
				}
	
				Property pSummary = component.getProperty("SUMMARY");
				if (pSummary != null) {
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	

}
