package net.dragons.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	static String source = "1029384756";
	static String target = "6058493721";
	static String phone_regexp = "^(0|84)(9\\d|16[2-9]|3[2-9]|12\\d|8[1-5]|7[06789]|5[2]|86|88|89|186|188|5[689]|199)(\\d{7})$";
	static int NUMBER_PLATE_LENGTH_MIN = 6;

	public static final String phone_prefix = "0";
	public static final String phone_prefix_84 = "84";

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static String getCurrentDate(String... format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		if (format != null && format.length > 0) {
			dateFormat = new SimpleDateFormat(format[0]);
		}
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}

