package net.dragons.constant;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessageConstant {
	
	private static Map<Integer, String> responseMessage() { 
		Map<Integer, String> result = new HashMap<Integer, String>();
		
		result.put(0, "Giao dịch thành công");
		result.put(1, "Giao dịch không thành công. Ngân hàng phát hành thẻ từ chối cấp phép cho giao dịch. Vui lòng liên hệ ngân hàng theo số điện thoại sau mặt thẻ để biết chính xác nguyên nhân Ngân hàng từ chối.");
		result.put(3, "Giao dịch không thành công, có lỗi trong quá trình cài đặt cổng thanh toán. Vui lòng liên hệ với OnePAY để được hỗ trợ (Hotline 1900 633 927)");
		result.put(4, "Giao dịch không thành công, có lỗi trong quá trình cài đặt cổng thanh toán. Vui lòng liên hệ với OnePAY để được hỗ trợ (Hotline 1900 633 927)");
		result.put(5, "Giao dịch không thành công, số tiền không hợp lệ. Vui lòng liên hệ với OnePAY để được hỗ trợ(Hotline 1900 633 927)");
		result.put(6, "Giao dịch không thành công, loại tiền tệ không hợp lệ. Vui lòng liên hệ với OnePAY để được hỗ trợ (Hotline 1900 633 927)");
		result.put(7, "Giao dịch không thành công. Ngân hàng phát hành thẻ từ chối cấp phép cho giao dịch. Vui lòng liên hệ ngân hàng theo số điện thoại sau mặt thẻ để biết chính xác nguyên nhân Ngân hàng từ chối.");
		result.put(8, "Giao dịch không thành công. Số thẻ không đúng. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(9, "Giao dịch không thành công. Tên chủ thẻ không đúng. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(10, "Giao dịch không thành công. Thẻ hết hạn/Thẻ bị khóa. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(11, "Giao dịch không thành công. Thẻ chưa đăng ký sử dụng dịch vụ thanh toán trên Internet. Vui lòng liên hê ngân hàng theo số điện thoại sau mặt thẻ để được hỗ trợ.");
		result.put(12, "Giao dịch không thành công. Ngày phát hành/Hết hạn không đúng. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(13, "Giao dịch không thành công. thẻ/ tài khoản đã vượt quá hạn mức thanh toán. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(21, "Giao dịch không thành công. Số tiền không đủ để thanh toán. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(22, "Giao dịch không thành công. Thông tin tài khoản không đúng. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(23, "Giao dịch không thành công. Tài khoản bị khóa. Vui lòng liên hê ngân hàng theo số điện thoại sau mặt thẻ để được hỗ trợ");
		result.put(24, "Giao dịch không thành công. Thông tin thẻ không đúng. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(25, "Giao dịch không thành công. OTP không đúng. Vui lòng kiểm tra và thực hiện thanh toán lại");
		result.put(253, "Giao dịch không thành công. Quá thời gian thanh toán. Vui lòng thực hiện thanh toán lại");
		result.put(99, "Giao dịch không thành công. Người sử dụng hủy giao dịch");
		
		return result;
	}
	
	public static String getMessage(Integer messageId) {
		Map<Integer, String> messageMap = responseMessage();
		
		return messageMap.get(messageId);
	}
	
	
}
