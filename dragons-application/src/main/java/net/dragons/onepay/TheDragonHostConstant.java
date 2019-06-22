package net.dragons.onepay;

public final class TheDragonHostConstant {
	
	private TheDragonHostConstant() {
        
	}
	
	public static final int PAGE_SIZE = 20;
	public static final String ADMIN_EMAIL = "";
	
	public static int PAYMENT_STATUS_PROCESSING = 1;
	public static int PAYMENT_STATUS_FAILED = 1;
	public static int PAYMENT_STATUS_SUCCESS = 0;
	
	public static int PAY_WITH_ATM 			= 0;
	public static int PAY_WITH_NON_ATM 		= 1; 
	
	public static String PAYMENT_SUCCESS_MESSAGE 			= "Payment Success";
	public static String PAYMENT_PROCESSING_MESSAGE 		= "Payment Processing";
	public static String PAYMENT_FAILED_MESSAGE 			= "Payment Failed";
	
	public static String ADMIN_UPDATE_ROOM_SUCCESS_MESSAGE 	= "Update Room Successfully";
	public static String ADMIN_UPDATE_ROOM_FAILED_MESSAGE 	= "Update Room Failed";
	
	
	public static String ADMIN_BOOKING_EMAIL_TITLE = "New booking confirmed for your upcoming Saigon trip! You arrives Month day. ";
	
}
