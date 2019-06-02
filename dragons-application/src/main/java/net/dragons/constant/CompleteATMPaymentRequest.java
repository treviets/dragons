package net.dragons.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompleteATMPaymentRequest {
	
	@JsonProperty("vpc_AdditionData")
	private String vpcAdditionData;
	
	@JsonProperty("vpc_Amount")
	private String vpcAmount;
	
	@JsonProperty("vpc_Command")
	private String vpcCommand;
	
	@JsonProperty("vpc_CurrencyCode")
	private String vpcCurrencyCode;
	
	@JsonProperty("vpc_Locale")
	private String vpcLocale;
	
	@JsonProperty("vpc_MerchTxnRef")
	private String vpcMerchTxnRef;
	
	@JsonProperty("vpc_Merchant")
	private String vpcMerchant;
	
	@JsonProperty("vpc_OrderInfo")
	private String vpcOrderInfo;
	
	@JsonProperty("vpc_TransactionNo")
	private String vpcTransactionNo;
	
	@JsonProperty("vpc_TxnResponseCode")
	private String vpcTxnResponseCode;
	
	@JsonProperty("vpc_Version")
	private String vpcVersion;
	
	@JsonProperty("vpc_Message")
	private String vpcMessage;
	
	@JsonProperty("vpc_SecureHash")
	private String vpcSecureHash;

	/**
	 * @return the vpcAdditionData
	 */
	public String getVpcAdditionData() {
		return vpcAdditionData;
	}

	/**
	 * @param vpcAdditionData the vpcAdditionData to set
	 */
	public void setVpcAdditionData(String vpcAdditionData) {
		this.vpcAdditionData = vpcAdditionData;
	}

	/**
	 * @return the vpcAmount
	 */
	public String getVpcAmount() {
		return vpcAmount;
	}

	/**
	 * @param vpcAmount the vpcAmount to set
	 */
	public void setVpcAmount(String vpcAmount) {
		this.vpcAmount = vpcAmount;
	}
	
	public float getTotalAmount() {
		return Float.parseFloat(vpcAmount) / 100;
	}

	/**
	 * @return the vpcCommand
	 */
	public String getVpcCommand() {
		return vpcCommand;
	}

	/**
	 * @param vpcCommand the vpcCommand to set
	 */
	public void setVpcCommand(String vpcCommand) {
		this.vpcCommand = vpcCommand;
	}

	/**
	 * @return the vpcCurrencyCode
	 */
	public String getVpcCurrencyCode() {
		return vpcCurrencyCode;
	}

	/**
	 * @param vpcCurrencyCode the vpcCurrencyCode to set
	 */
	public void setVpcCurrencyCode(String vpcCurrencyCode) {
		this.vpcCurrencyCode = vpcCurrencyCode;
	}

	/**
	 * @return the vpcLocale
	 */
	public String getVpcLocale() {
		return vpcLocale;
	}

	/**
	 * @param vpcLocale the vpcLocale to set
	 */
	public void setVpcLocale(String vpcLocale) {
		this.vpcLocale = vpcLocale;
	}

	/**
	 * @return the vpcMerchTxnRef
	 */
	public String getVpcMerchTxnRef() {
		return vpcMerchTxnRef;
	}

	/**
	 * @param vpcMerchTxnRef the vpcMerchTxnRef to set
	 */
	public void setVpcMerchTxnRef(String vpcMerchTxnRef) {
		this.vpcMerchTxnRef = vpcMerchTxnRef;
	}

	/**
	 * @return the vpcMerchant
	 */
	public String getVpcMerchant() {
		return vpcMerchant;
	}

	/**
	 * @param vpcMerchant the vpcMerchant to set
	 */
	public void setVpcMerchant(String vpcMerchant) {
		this.vpcMerchant = vpcMerchant;
	}

	/**
	 * @return the vpcOrderInfo
	 */
	public String getVpcOrderInfo() {
		return vpcOrderInfo;
	}

	/**
	 * @param vpcOrderInfo the vpcOrderInfo to set
	 */
	public void setVpcOrderInfo(String vpcOrderInfo) {
		this.vpcOrderInfo = vpcOrderInfo;
	}

	/**
	 * @return the vpcTransactionNo
	 */
	public String getVpcTransactionNo() {
		return vpcTransactionNo;
	}

	/**
	 * @param vpcTransactionNo the vpcTransactionNo to set
	 */
	public void setVpcTransactionNo(String vpcTransactionNo) {
		this.vpcTransactionNo = vpcTransactionNo;
	}

	/**
	 * @return the vpcTxnResponseCode
	 */
	public String getVpcTxnResponseCode() {
		return vpcTxnResponseCode;
	}

	/**
	 * @param vpcTxnResponseCode the vpcTxnResponseCode to set
	 */
	public void setVpcTxnResponseCode(String vpcTxnResponseCode) {
		this.vpcTxnResponseCode = vpcTxnResponseCode;
	}

	/**
	 * @return the vpcVersion
	 */
	public String getVpcVersion() {
		return vpcVersion;
	}

	/**
	 * @param vpcVersion the vpcVersion to set
	 */
	public void setVpcVersion(String vpcVersion) {
		this.vpcVersion = vpcVersion;
	}

	/**
	 * @return the vpcSecureHash
	 */
	public String getVpcSecureHash() {
		return vpcSecureHash;
	}

	/**
	 * @param vpcSecureHash the vpcSecureHash to set
	 */
	public void setVpcSecureHash(String vpcSecureHash) {
		this.vpcSecureHash = vpcSecureHash;
	}

	public String getVcpMessage() {
		return vpcMessage == null ? "" : vpcMessage;
	}

	public void setVcpMessage(String vpcMessage) {
		this.vpcMessage = vpcMessage;
	}
}
