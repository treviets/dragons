package net.dragons.service;

public interface ICalendarService {

	
	void loadICalendarFile() throws Exception;
	
	void loadICalendarWithURL(String url);
}
