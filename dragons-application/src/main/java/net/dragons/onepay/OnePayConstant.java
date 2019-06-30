package net.dragons.onepay;

public final class OnePayConstant {
	private OnePayConstant() {
        
	}
	

	public static final String API_DOMAIN = "http://localhost:8080/dragons";
	public static final String TDH_DOMAIN = "http://localhost:3000";
	
//	public static final String API_DOMAIN = "http://api.thedragonshost.com:8080/dragons";
//	public static final String TDH_DOMAIN = "https://tdh.thedragonshost.com";
	
	/*************************************************************************************
							CONSTANT FOR ATM
	*/
	public static final String ONEPAY_ATM_MERCHANT_ID 	= "ONEPAY";
	public static final String ONEPAY_ATM_ACCESS_CODE 	= "D67342C2";
	public static final String ONEPAY_ATM_SECURE_SECRET = "A3EFDFABA8653DF2342E8DAC29B51AF0";
	public static final String ONEPAY_ATM_PROCESS_URL 	= "https://mtf.onepay.vn/onecomm-pay/vpc.op";
	public static final String ONEPAY_ATM_RE_CHECK_URL 	= "https://mtf.onepay.vn/onecomm-pay/Vpcdps.op";
	public static final String ONEPAY_ATM_REFUND_URL 	= "https://mtf.onepay.vn/onecomm-pay/refund.op";
	public static final String ONEPAY_ATM_RETURN_URL 	=  TDH_DOMAIN + "/payment/response/pay_with_atm";
	/*************************************************************************************
	*/
	
	
	
	
	/*************************************************************************************
							CONSTANT FOR OTHER
	*/
	public static final String ONEPAY_MERCHANT_ID 		= "TESTONEPAY";
	public static final String ONEPAY_ACCESS_CODE 		= "6BEB2546";
	public static final String ONEPAY_USER 				= "op01";
	public static final String ONEPAY_PASSWORD 			= "op123456";
	public static final String ONEPAY_PROCESS_URL 		= "https://mtf.onepay.vn/vpcpay/vpcpay.op";
	public static final String ONEPAY_RE_CHECK_URL 		= "https://mtf.onepay.vn/vpcpay/Vpcdps.op";
	public static final String ONEPAY_REFUND_URL 		= "https://mtf.onepay.vn/vpcpay/refund.op";
	public static final String ONEPAY_RETURN_URL 		=  TDH_DOMAIN + "/payment/response/pay_with_non_atm";
	public static final String ONEPAY_SECURE_SECRET 	= "6D0870CDE5F24F34F3915FB0045120DB";
	/*************************************************************************************
	*/
}
