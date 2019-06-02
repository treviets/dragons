package net.dragons.service;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.constant.CompletePaymentRequest;
import net.dragons.constant.OnePayConstant;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;
import net.dragons.jpa.entity.CustomerAddress;

public class OnePayService {

	static final char[] HEX_TABLE = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F' };
	private static byte[] decodeHexArray = new byte[103];

	static {
		int i = 0;
		for (byte b : new byte[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' }) {
			decodeHexArray[b] = (byte) i++;
		}
		decodeHexArray['a'] = decodeHexArray['A'];
		decodeHexArray['b'] = decodeHexArray['B'];
		decodeHexArray['c'] = decodeHexArray['C'];
		decodeHexArray['d'] = decodeHexArray['D'];
		decodeHexArray['e'] = decodeHexArray['E'];
		decodeHexArray['f'] = decodeHexArray['F'];
	}

	public static String buildUrl(PayNonATMDto payNonATMDto, CustomerAddress address) {
		Map<String, String> fields = new HashMap<String, String>();

		fields.put("vpc_Merchant", OnePayConstant.ONEPAY_MERCHANT_ID);
		fields.put("vpc_AccessCode", OnePayConstant.ONEPAY_ACCESS_CODE);
		fields.put("vpc_MerchTxnRef", payNonATMDto.getMerchantOrderId());
		fields.put("vpc_OrderInfo", payNonATMDto.getOrderCode());
		fields.put("vpc_Amount", String.valueOf((int) payNonATMDto.getTotalAmount() * 100));
		fields.put("vpc_ReturnURL", OnePayConstant.ONEPAY_RETURN_URL);
		fields.put("vpc_Version", "2");
		fields.put("vpc_Command", "pay");
		fields.put("vpc_Locale", "vn");
		fields.put("vpc_Currency", "VND");
		fields.put("vpc_TicketNo", "149.28.147.158");
		fields.put("AgainLink", OnePayConstant.API_DOMAIN);
		fields.put("Title", "Thanh toan tien dat phong TheDragonsHost");
		fields.put("AVS_Street01", address.getFullTextAddress());
		fields.put("AVS_City", address.getCity().getName());
		fields.put("AVS_StateProv", address.getDistrict().getName());
		fields.put("AVS_PostCode", String.valueOf(address.getDistrict().getId()));
		fields.put("AVS_Country", "VN");

		String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_SECURE_SECRET);
		fields.put("vpc_SecureHash", secureHash);

		StringBuffer buf = new StringBuffer();
		buf.append(OnePayConstant.ONEPAY_PROCESS_URL).append('?');
		appendQueryFields(buf, fields);
		return buf.toString();
	}

	public static String buildUrlForRefund(HttpServletRequest request, String orderCode,
			float totalAmount, CustomerAddress address) {
		Map<String, String> fields = new HashMap<String, String>();

		fields.put("vpc_Merchant", OnePayConstant.ONEPAY_MERCHANT_ID);
		fields.put("vpc_AccessCode", OnePayConstant.ONEPAY_ACCESS_CODE);
		fields.put("vpc_MerchTxnRef", orderCode+"_refund");
		fields.put("vpc_OrgMerchTxnRef", orderCode);
		fields.put("vpc_Amount", String.valueOf((int) totalAmount * 100));
		fields.put("vpc_Version", "2");
		fields.put("vpc_Command", "refund");
		fields.put("vpc_Operator", "manager");

		String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_ATM_SECURE_SECRET);
		fields.put("vpc_SecureHash", secureHash);

		StringBuffer buf = new StringBuffer();
		buf.append(OnePayConstant.ONEPAY_ATM_REFUND_URL).append('?');
		appendQueryFields(buf, fields);
		return buf.toString();
	}
	
	public static String buildUrlATM(PayATMDto payATMDto) {
		Map<String, String> fields = new HashMap<String, String>();

		fields.put("vpc_Merchant", OnePayConstant.ONEPAY_ATM_MERCHANT_ID);
		fields.put("vpc_AccessCode", OnePayConstant.ONEPAY_ATM_ACCESS_CODE);
		fields.put("vpc_MerchTxnRef", payATMDto.getMerchantOrderId());
		fields.put("vpc_OrderInfo", payATMDto.getOrderCode());
		fields.put("vpc_Amount", String.valueOf((int) payATMDto.getTotalAmount() * 100));
		fields.put("vpc_ReturnURL", OnePayConstant.ONEPAY_ATM_RETURN_URL);
		fields.put("vpc_Version", "2");
		fields.put("vpc_Command", "pay");
		fields.put("vpc_Locale", "vn");
		fields.put("vpc_Currency", "VND");
		fields.put("vpc_TicketNo", "149.28.147.158");
		fields.put("AgainLink", OnePayConstant.API_DOMAIN);
		fields.put("Title", "Thanh toan tien dat phong TheDragonsHost");

		String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_ATM_SECURE_SECRET);
		System.out.println(secureHash);
		fields.put("vpc_SecureHash", secureHash);

		StringBuffer buf = new StringBuffer();
		buf.append(OnePayConstant.ONEPAY_ATM_PROCESS_URL).append('?');
		appendQueryFields(buf, fields);
		return buf.toString();
	}

	public static String buildUrlForSupplier(HttpServletRequest request, String transactionCode, float amount) {
		Map<String, String> fields = new HashMap<String, String>();

		fields.put("vpc_Merchant", OnePayConstant.ONEPAY_MERCHANT_ID);
		fields.put("vpc_AccessCode", OnePayConstant.ONEPAY_ACCESS_CODE);
		fields.put("vpc_MerchTxnRef", transactionCode);
		fields.put("vpc_OrderInfo", transactionCode);
		fields.put("vpc_Amount", String.valueOf((int) amount * 100));
		fields.put("vpc_ReturnURL", OnePayConstant.ONEPAY_RETURN_URL);
		fields.put("vpc_Version", "2");
		fields.put("vpc_Command", "pay");
		fields.put("vpc_Locale", "vn");
		fields.put("vpc_Currency", "VND");
		fields.put("vpc_TicketNo", "149.28.147.158");
		fields.put("AgainLink", OnePayConstant.API_DOMAIN);
		fields.put("Title", "Nap tien vao vi Needii");

		String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_SECURE_SECRET);
		fields.put("vpc_SecureHash", secureHash);

		StringBuffer buf = new StringBuffer();
		buf.append(OnePayConstant.ONEPAY_PROCESS_URL).append('?');
		appendQueryFields(buf, fields);
		return buf.toString();
	}

	public static String buildUrlATMForSupplier(HttpServletRequest request, String transactionCode, float amount) {
		Map<String, String> fields = new HashMap<String, String>();

		fields.put("vpc_Merchant", OnePayConstant.ONEPAY_ATM_MERCHANT_ID);
		fields.put("vpc_AccessCode", OnePayConstant.ONEPAY_ATM_ACCESS_CODE);
		fields.put("vpc_MerchTxnRef", transactionCode);
		fields.put("vpc_OrderInfo", transactionCode);
		fields.put("vpc_Amount", String.valueOf((int) amount * 100));
		fields.put("vpc_ReturnURL", OnePayConstant.ONEPAY_RETURN_URL);
		fields.put("vpc_Version", "2");
		fields.put("vpc_Command", "pay");
		fields.put("vpc_Locale", "vn");
		fields.put("vpc_Currency", "VND");
		fields.put("vpc_TicketNo", "149.28.147.158");
		fields.put("AgainLink", OnePayConstant.API_DOMAIN);
		fields.put("Title", "Nap tien vao vi Needii");

		String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_ATM_SECURE_SECRET);
		fields.put("vpc_SecureHash", secureHash);

		StringBuffer buf = new StringBuffer();
		buf.append(OnePayConstant.ONEPAY_ATM_PROCESS_URL).append('?');
		appendQueryFields(buf, fields);
		return buf.toString();
	}

	public static boolean validateResultTest(HttpServletRequest request) {
		boolean isValid = false;

		Map<String, String> fields = new HashMap<>();
		for (Enumeration<String> enum1 = request.getParameterNames(); enum1.hasMoreElements();) {
			String fieldName = (String) enum1.nextElement();
			String fieldValue = request.getParameter(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0)) {
				fields.put(fieldName, fieldValue);
			}
		}

		String vpc_Txn_Secure_Hash = null2unknown((String) fields.remove("vpc_SecureHash"));
		String hashValidated = null;
		if (fields.get("vpc_TxnResponseCode") != null || fields.get("vpc_TxnResponseCode") != "No Value Returned") {
			String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_SECURE_SECRET);
			if (vpc_Txn_Secure_Hash.equalsIgnoreCase(secureHash)) {
				hashValidated = "CORRECT";
			} else {
				hashValidated = "INVALID HASH";
			}
		} else {
			hashValidated = "INVALID HASH";
		}

		String title = null2unknown((String) fields.get("Title"));
		String amount = null2unknown((String) fields.get("vpc_Amount"));
		String message = null2unknown((String) fields.get("vpc_Message"));
		String orderInfo = null2unknown((String) fields.get("vpc_OrderInfo"));
		String merchantID = null2unknown((String) fields.get("vpc_Merchant"));
		String merchTxnRef = null2unknown((String) fields.get("vpc_MerchTxnRef"));
		String transactionNo = null2unknown((String) fields.get("vpc_TransactionNo"));
		String txnResponseCode = null2unknown((String) fields.get("vpc_TxnResponseCode"));
		String transStatus = "";
		if (hashValidated.equals("CORRECT") && txnResponseCode.equals("0")) {
			transStatus = "Giao dịch thành công";
		} else if (hashValidated.equals("INVALID HASH") && txnResponseCode.equals("0")) {
			transStatus = "Giao dịch Pendding";
		} else {
			transStatus = "Giao dịch thất bại";
		}

		return isValid;
	}

	public static boolean validateATMResult(CompleteATMPaymentRequest result) {
		boolean isValid = false;

		Map<String, String> fields = new HashMap<String, String>();

		fields.put("vpc_AdditionData", result.getVpcAdditionData());
		fields.put("vpc_Amount", result.getVpcAmount());
		fields.put("vpc_Command", result.getVpcCommand());
		fields.put("vpc_CurrencyCode", result.getVpcCurrencyCode());
		fields.put("vpc_Locale", result.getVpcLocale());
		fields.put("vpc_MerchTxnRef", result.getVpcMerchTxnRef());
		fields.put("vpc_Merchant", result.getVpcMerchant());
		fields.put("vpc_OrderInfo", result.getVpcOrderInfo());
		fields.put("vpc_TransactionNo", result.getVpcTransactionNo());
		fields.put("vpc_TxnResponseCode", result.getVpcTxnResponseCode());
		fields.put("vcp_Message", result.getVcpMessage());
		fields.put("vpc_Version", result.getVpcVersion());

		String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_ATM_SECURE_SECRET);
		if (result.getVpcSecureHash().equalsIgnoreCase(secureHash)) {
			isValid = true;
		}

		return isValid;
	}

	

	private static String null2unknown(String in) {
		if (in == null || in.length() == 0) {
			return "No Value Returned";
		} else {
			return in;
		}
	}

	public static String hashAllFields(Map<String, String> fields, String secret) {
		List<String> fieldNames = new ArrayList<>(fields.keySet());
		Collections.sort(fieldNames);
		StringBuffer buf = new StringBuffer();
		Iterator<String> itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = (String) fields.get(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0) && fieldName.indexOf("vpc_") == 0) {
				buf.append(fieldName + "=" + fieldValue);
				if (itr.hasNext()) {
					buf.append('&');
				}
			}
		}
		byte[] mac = null;
		try {
			byte[] b = decodeHexa(secret.getBytes());
			SecretKey key = new SecretKeySpec(b, "HMACSHA256");
			Mac m = Mac.getInstance("HMACSHA256");
			m.init(key);
			m.update(buf.toString().getBytes("UTF-8"));
			mac = m.doFinal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String hashValue = hex(mac);
		return hashValue;
	}

	private static byte[] decodeHexa(byte[] data) throws Exception {
		if (data == null) {
			return null;
		}
		if (data.length % 2 != 0) {
			throw new Exception("Invalid data length:" + data.length);
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte b1, b2;
		int i = 0;
		while (i < data.length) {
			b1 = decodeHexArray[data[i++]];
			b2 = decodeHexArray[data[i++]];
			out.write((b1 << 4) | b2);
		}
		out.flush();
		out.close();
		return out.toByteArray();
	}

	private static String hex(byte[] input) {
		StringBuffer sb = new StringBuffer(input.length * 2);
		for (int i = 0; i < input.length; i++) {
			sb.append(HEX_TABLE[(input[i] >> 4) & 0xf]);
			sb.append(HEX_TABLE[input[i] & 0xf]);
		}
		return sb.toString();
	}

	public static void appendQueryFields(StringBuffer buf, Map<String, String> fields) {
		List<String> fieldNames = new ArrayList<>(fields.keySet());
		Iterator<String> itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = (String) fields.get(fieldName);

			if ((fieldValue != null) && (fieldValue.length() > 0)) {
				try {
					buf.append(URLEncoder.encode(fieldName, "UTF-8"));
					buf.append('=');
					buf.append(URLEncoder.encode(fieldValue, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (itr.hasNext()) {
				buf.append('&');
			}

		}
	}
	
	public static CompleteATMPaymentRequest parseResponseATM(HttpServletRequest request) {
		CompleteATMPaymentRequest responseObject = new CompleteATMPaymentRequest();
		
		responseObject.setVpcAdditionData(request.getParameter("vpc_AdditionData"));
		responseObject.setVpcAmount(request.getParameter("vpc_Amount"));
		responseObject.setVpcCommand(request.getParameter("vpc_Command"));
		responseObject.setVpcCurrencyCode(request.getParameter("vpc_CurrencyCode"));
		responseObject.setVpcLocale(request.getParameter("vpc_Locale"));
		responseObject.setVpcMerchTxnRef(request.getParameter("vpc_MerchTxnRef"));
		responseObject.setVpcMerchant(request.getParameter("vpc_Merchant"));
		responseObject.setVpcOrderInfo(request.getParameter("vpc_OrderInfo"));
		responseObject.setVpcTxnResponseCode(request.getParameter("vpc_TxnResponseCode"));
		responseObject.setVpcTransactionNo(request.getParameter("vpc_TransactionNo"));
		responseObject.setVcpMessage(request.getParameter("vcp_Message"));

		responseObject.setVpcVersion(request.getParameter("vpc_Version"));
		responseObject.setVpcSecureHash(request.getParameter("vpc_SecureHash"));
		return responseObject;
	}
	
	public static CompletePaymentRequest parseResponseNonATM(HttpServletRequest request) {
		CompletePaymentRequest responseObject = new CompletePaymentRequest();
		
		responseObject.setVpcOrderInfo(request.getParameter("vpc_OrderInfo"));
		responseObject.setVpc3DSECI(request.getParameter("vpc_3DSECI"));
		responseObject.setVpcAVSStreet01(request.getParameter("vpc_AVS_Street01"));
		responseObject.setVpcMerchant(request.getParameter("vpc_Merchant"));
		responseObject.setVpcCard(request.getParameter("vpc_Card"));
		responseObject.setVpcAcqResponseCode(request.getParameter("vpc_AcqResponseCode"));
		responseObject.setAgainLink(request.getParameter("AgainLink"));
		responseObject.setVpcAVSCountry(request.getParameter("vpc_AVS_Country"));
		responseObject.setVpcAuthorizeId(request.getParameter("vpc_AuthorizeId"));
		responseObject.setVpc3DSenrolled(request.getParameter("vpc_3DSenrolled"));
		responseObject.setVpcRiskOverallResult(request.getParameter("vpc_RiskOverallResult"));
		responseObject.setVpcReceiptNo(request.getParameter("vpc_ReceiptNo"));
		responseObject.setVpcTransactionNo(request.getParameter("vpc_TransactionNo"));
		responseObject.setVpcAVSStateProv(request.getParameter("vpc_AVS_StateProv"));
		responseObject.setVpcLocale(request.getParameter("vpc_Locale"));
		responseObject.setVpcTxnResponseCode(request.getParameter("vpc_TxnResponseCode"));
		responseObject.setVpcVerToken(request.getParameter("vpc_VerToken"));
		responseObject.setVpcAmount(request.getParameter("vpc_Amount"));
		responseObject.setVpcBatchNo(request.getParameter("vpc_BatchNo"));
		responseObject.setVpcVersion(request.getParameter("vpc_Version"));
		responseObject.setVpcAVSResultCode(request.getParameter("vpc_AVSResultCode"));
		responseObject.setVpcVerStatus(request.getParameter("vpc_VerStatus"));
		responseObject.setVpcCommand(request.getParameter("vpc_Command"));
		responseObject.setVpcMessage(request.getParameter("vpc_Message"));
		responseObject.setTitle(request.getParameter("Title"));
		responseObject.setVpc3DSstatus(request.getParameter("vpc_3DSstatus"));
		responseObject.setVpcSecureHash(request.getParameter("vpc_SecureHash"));
		responseObject.setVpcCardNum(request.getParameter("vpc_CardNum"));
		responseObject.setVpcAVSPostCode(request.getParameter("vpc_AVS_PostCode"));
		responseObject.setVpcCSCResultCode(request.getParameter("vpc_CSCResultCode"));
		responseObject.setVpcMerchTxnRef(request.getParameter("vpc_MerchTxnRef"));
		responseObject.setVpcVerType(request.getParameter("vpc_VerType"));
		responseObject.setVpcVerSecurityLevel(request.getParameter("vpc_VerSecurityLevel"));
		responseObject.setVpc3DSXID(request.getParameter("vpc_3DSXID"));
		responseObject.setVpcAVSCity(request.getParameter("vpc_AVS_City"));
		
		return responseObject;
	}
	
	public static boolean validateNonATMResult(CompletePaymentRequest result) {
		boolean isValid = false;

		Map<String, String> fields = new HashMap<String, String>();

		fields.put("vpc_OrderInfo", result.getVpcOrderInfo());
		fields.put("vpc_3DSECI", result.getVpc3DSECI());
		fields.put("vpc_AVS_Street01", result.getVpcAVSStreet01());
		fields.put("vpc_Merchant", result.getVpcMerchant());
		fields.put("vpc_Card", result.getVpcCard());
		fields.put("vpc_AcqResponseCode", result.getVpcAcqResponseCode());
		fields.put("AgainLink", result.getAgainLink());
		fields.put("vpc_AVS_Country", result.getVpcAVSCountry());
		fields.put("vpc_AuthorizeId", result.getVpcAuthorizeId());
		fields.put("vpc_3DSenrolled", result.getVpc3DSenrolled());
		fields.put("vpc_RiskOverallResult", result.getVpcRiskOverallResult());
		fields.put("vpc_ReceiptNo", result.getVpcReceiptNo());
		fields.put("vpc_TransactionNo", result.getVpcTransactionNo());
		fields.put("vpc_AVS_StateProv", result.getVpcAVSStateProv());
		fields.put("vpc_Locale", result.getVpcLocale());
		fields.put("vpc_TxnResponseCode", result.getVpcTxnResponseCode());
		fields.put("vpc_VerToken", result.getVpcVerToken());
		fields.put("vpc_Amount", result.getVpcAmount());
		fields.put("vpc_BatchNo", result.getVpcBatchNo());
		fields.put("vpc_Version", result.getVpcVersion());
		fields.put("vpc_AVSResultCode", result.getVpcAVSResultCode());
		fields.put("vpc_VerStatus", result.getVpcVerStatus());
		fields.put("vpc_Command", result.getVpcCommand());
		fields.put("vpc_Message", result.getVpcMessage());
		fields.put("Title", result.getTitle());
		fields.put("vpc_3DSstatus", result.getVpc3DSstatus());
		fields.put("vpc_CardNum", result.getVpcCardNum());
		fields.put("vpc_AVS_PostCode", result.getVpcAVSPostCode());
		fields.put("vpc_CSCResultCode", result.getVpcCSCResultCode());
		fields.put("vpc_MerchTxnRef", result.getVpcMerchTxnRef());
		fields.put("vpc_VerType", result.getVpcVerType());
		fields.put("vpc_VerSecurityLevel", result.getVpcVerSecurityLevel());
		fields.put("vpc_3DSXID", result.getVpc3DSXID());
		fields.put("vpc_AVS_City", result.getVpcAVSCity());

		String secureHash = hashAllFields(fields, OnePayConstant.ONEPAY_SECURE_SECRET);
		if (result.getVpcSecureHash().equalsIgnoreCase(secureHash)) {
			isValid = true;
		}

		return isValid;
	}
}
