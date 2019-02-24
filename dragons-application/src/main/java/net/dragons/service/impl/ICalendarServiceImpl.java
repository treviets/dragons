package net.dragons.service.impl;

import java.io.FileInputStream;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import net.dragons.service.ICalendarService;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;

@Service
public class ICalendarServiceImpl implements ICalendarService {

	// private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");

	public void loadICalendarFile() throws Exception {
		//FileInputStream fin = new FileInputStream("D:\\Projects\\Workspace\\the_dragon\\example.ics");
		
		FileInputStream fin = new FileInputStream("D:\\Projects\\Workspace\\the_dragon\\dragon.ics");
		
		CalendarBuilder builder = new CalendarBuilder();
		
		Calendar calendar = builder.build(fin);

		System.out.println("Length of calendar: " + calendar.getComponents().size());

		for (Iterator<?> itr = calendar.getComponents().iterator(); itr.hasNext();) {
			Component component = (Component) itr.next();

			Property pStart = component.getProperty("DTSTART");
			if (pStart != null) {
				String strStart = pStart.getValue();
				System.out.println("Start: " + strStart);
			}

			Property pEnd = component.getProperty("DTEND");
			if (pEnd != null) {
				String strEnd = pEnd.getValue();
				System.out.println("End: " + strEnd);
			}

			Property pSummary = component.getProperty("SUMMARY");
			if (pSummary != null) {

			}
		}

	}

	@Override
	public void loadICalendarWithURL(String url) {

	}

}
