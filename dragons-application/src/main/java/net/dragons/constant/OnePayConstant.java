package net.dragons.constant;

public final class OnePayConstant {
	private OnePayConstant() {
        
	}
	public static final double PI = 3.14159;
	public static final int STATUS_ACTIVE = 1;
	public static final boolean STATUS_HIGHLIGHT = true;
	public static final double PLANCK_CONSTANT = 6.62606896e-34;
	public static final String CMC_DOMAIN_NAME = "http://allin.needii.com.vn";
	public static final String CMC_RESOURCE_DOMAIN = CMC_DOMAIN_NAME + "/needii";

	
	public static final String SOURCE_FLAG_NAME = "/resource/countries/flag/";
	public static final String SOURCE_COUNTRY_NAME = "/resource/countries/";
	public static final String UPLOADED_FOLDER = "webapp/static/images/";
	public static final String SAVE_PATH = "/static/images/uploadimg/";
	public static final String SAVE_BANNER_PATH = "/static/upload/images/banners/";
	public static final String SAVE_LANDING_PATH = "/static/upload/images/landings/";
	public static final String SAVE_CATEGORY_PATH = "/static/upload/images/categories/";
	public static final String SAVE_SUPPLIER_LOGO_PATH = "/static/upload/images/suppliers/";
	public static final String SAVE_SUPPLIER_PATH = "/static/upload/images/suppliers/";
	public static final String SAVE_PRODUCT_THUMBNAIL_PATH = "/static/upload/images/products/thumbnail/";
	public static final String SAVE_PRODUCT_PATH = "/static/upload/images/products/";
	public static final String SAVE_QRCODE_PATH = "/static/qrcode/";
	public static final String SAVE_FLASHSALE_BANNER_PATH = "/static/upload/flashsale/";
	public static final String SAVE_CUSTOMER_PATH = "/static/upload/images/customers/";
	public static final String SAVE_SHIPPERS_PATH = "/static/upload/images/shippers/";
	public static final String SAVE_EXPORT_FILE = "/static/upload";
	public static final String READ_EXPORT_FILE = "/static/upload";
	
	public static final int VERIFY_CODE_LENGTH = 6;
	public static final int REFERENCE_CODE_LENGTH = 9;
	public static final int PAGE_NUMBER = 20;
	public static final String PAGE_NUMBER_REQUEST = "20";
	public static final int DEFAULT_VIETNAMESE_LANGUAGE_ID = 1;
	public static final String DEFAULT_VIETNAMESE_LANGUAGE = "vi";
	public static final String SALT = "Needii-ECommerce";
	
	public static final String SMS_API_KEY = "OOi0c75SzNL3k92aQxK4MfAl_TasoJ0z";
	
	public static final String ONEPAY_ATM_MERCHANT_ID = "ONEPAY";
	public static final String ONEPAY_ATM_ACCESS_CODE = "D67342C2";
	public static final String ONEPAY_ATM_PROCESS_URL = "https://mtf.onepay.vn/onecomm-pay/vpc.op";
	public static final String ONEPAY_ATM_RE_CHECK_URL = "https://mtf.onepay.vn/onecomm-pay/Vpcdps.op";
	public static final String ONEPAY_ATM_REFUND_URL = "https://mtf.onepay.vn/onecomm-pay/refund.op";
	public static final String API_DOMAIN = "http://api.thedragonshost.com:8080";

	public static final String ONEPAY_ATM_RETURN_URL = API_DOMAIN + "/payment/response/by_atm";
	public static final String ONEPAY_ATM_SECURE_SECRET = "A3EFDFABA8653DF2342E8DAC29B51AF0";
	
	public static final String ONEPAY_MERCHANT_ID = "TESTONEPAY";
	public static final String ONEPAY_ACCESS_CODE = "6BEB2546";
	public static final String ONEPAY_USER = "op01";
	public static final String ONEPAY_PASSWORD = "op123456";
	public static final String ONEPAY_PROCESS_URL = "https://mtf.onepay.vn/vpcpay/vpcpay.op";
	public static final String ONEPAY_RE_CHECK_URL = "https://mtf.onepay.vn/vpcpay/Vpcdps.op";
	public static final String ONEPAY_REFUND_URL = "https://mtf.onepay.vn/vpcpay/refund.op";
	
	public static final String ONEPAY_RETURN_URL = API_DOMAIN + "/payment/response";
	public static final String ONEPAY_SECURE_SECRET = "6D0870CDE5F24F34F3915FB0045120DB";
	public static final int CUBIC_METER_CONSTANT = 5000;
	
	public static final boolean ENABLE_OTP = false;

	public static final int OTP_EXPIRE_IN_SECONDS = 180;
	
	public static final String PROMOTION_TYPE_NEEDII_CASH = "NEEDII_CASH";
	public static final String PROMOTION_TYPE_FIX_AMOUNT = "FIX_AMOUNT";
	public static final String PROMOTION_TYPE_PERCENT = "PERCENT";
	
	public static final String AWS_KEY = "AKIAJCGQLD7BOBYZ5JTA";
	public static final String AWS_SECRET = "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";
	
	//SMS
	public static String cmcApiUrl = "http://124.158.6.45/ApiRF/api/sms/Send";
	public static String cmcUsername = "needii";
	public static String cmcPassword = "5Nx4pYrH";
	public static String cmcSender = "CSKH";
	
	public static String dateFormat = "dd-MM-yyyy HH:mm:ss";
	
	public static final String GOOGLE_FIREBASE_JSON_KEY_PATH = "/opt/needii_api/data/fcm_key.json";
	public static final String GOOGLE_FIREBASE_URL = "https://needii-project.firebaseio.com";
	public static final String APNS_FILE_KEY_PATH = "/opt/needii_api/data/apns.p12";
	public static final String APNS_FILE_PASSWORD = "Needii!123";
	
	public static int PERIOD_REFERENCE_APPLY = 90;

}
