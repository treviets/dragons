package net.dragons.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompletePaymentRequest {
	
	@JsonProperty("vpc_OrderInfo")
	private String vpcOrderInfo;
	
	@JsonProperty("vpc_3DSECI")
	private String vpc3DSECI;
	
	@JsonProperty("vpc_AVS_Street01")
	private String vpcAVSStreet01;
	
	@JsonProperty("vpc_Merchant")
	private String vpcMerchant;
	
	@JsonProperty("vpc_Card")
	private String vpcCard;
	
	@JsonProperty("vpc_AcqResponseCode")
	private String vpcAcqResponseCode;
	
	@JsonProperty("vpc_CurrencyCode")
	private String vpcCurrencyCode;
	
	@JsonProperty("AgainLink")
	private String againLink;
	
	@JsonProperty("vpc_AVS_Country")
	private String vpcAVSCountry;
	
	@JsonProperty("vpc_AuthorizeId")
	private String vpcAuthorizeId;
	
	@JsonProperty("vpc_3DSenrolled")
	private String vpc3DSenrolled;
	
	@JsonProperty("vpc_RiskOverallResult")
	private String vpcRiskOverallResult;
	
	@JsonProperty("vpc_ReceiptNo")
	private String vpcReceiptNo;
	
	@JsonProperty("vpc_TransactionNo")
	private String vpcTransactionNo;
	
	@JsonProperty("vpc_AVS_StateProv")
	private String vpcAVSStateProv;
	
	@JsonProperty("vpc_TxnResponseCode")
	private String vpcTxnResponseCode;
	
	@JsonProperty("vpc_VerToken")
	private String vpcVerToken;
	
	@JsonProperty("vpc_Amount")
	private String vpcAmount;
	
	@JsonProperty("vpc_BatchNo")
	private String vpcBatchNo;
	
	@JsonProperty("vpc_Version")
	private String vpcVersion;
	
	@JsonProperty("vpc_AVSResultCode")
	private String vpcAVSResultCode;
	
	@JsonProperty("vpc_VerStatus")
	private String vpcVerStatus;
	
	@JsonProperty("vpc_Command")
	private String vpcCommand;
	
	@JsonProperty("vpc_Message")
	private String vpcMessage;
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("vpc_3DSstatus")
	private String vpc3DSstatus;
	
	@JsonProperty("vpc_SecureHash")
	private String vpcSecureHash;
	
	@JsonProperty("vpc_CardNum")
	private String vpcCardNum;
	
	@JsonProperty("vpc_AVS_PostCode")
	private String vpcAVSPostCode;
	
	@JsonProperty("vpc_CSCResultCode")
	private String vpcCSCResultCode;
	
	@JsonProperty("vpc_MerchTxnRef")
	private String vpcMerchTxnRef;
	
	@JsonProperty("vpc_VerType")
	private String vpcVerType;
	
	@JsonProperty("vpc_VerSecurityLevel")
	private String vpcVerSecurityLevel;
	
	@JsonProperty("vpc_3DSXID")
	private String vpc3DSXID;
	
	@JsonProperty("vpc_AVS_City")
	private String vpcAVSCity;
	
	@JsonProperty("vpc_Locale")
	private String vpcLocale;
	
	@JsonProperty("vpc_CommercialCard")
	private String vpcCommercialCard;

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
	 * @return the vpc3DSECI
	 */
	public String getVpc3DSECI() {
		return vpc3DSECI;
	}

	/**
	 * @param vpc3dseci the vpc3DSECI to set
	 */
	public void setVpc3DSECI(String vpc3dseci) {
		vpc3DSECI = vpc3dseci;
	}

	/**
	 * @return the vpcAVSStreet01
	 */
	public String getVpcAVSStreet01() {
		return vpcAVSStreet01;
	}

	/**
	 * @param vpcAVSStreet01 the vpcAVSStreet01 to set
	 */
	public void setVpcAVSStreet01(String vpcAVSStreet01) {
		this.vpcAVSStreet01 = vpcAVSStreet01;
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
	 * @return the vpcCard
	 */
	public String getVpcCard() {
		return vpcCard;
	}

	/**
	 * @param vpcCard the vpcCard to set
	 */
	public void setVpcCard(String vpcCard) {
		this.vpcCard = vpcCard;
	}

	/**
	 * @return the vpcAcqResponseCode
	 */
	public String getVpcAcqResponseCode() {
		return vpcAcqResponseCode;
	}

	/**
	 * @param vpcAcqResponseCode the vpcAcqResponseCode to set
	 */
	public void setVpcAcqResponseCode(String vpcAcqResponseCode) {
		this.vpcAcqResponseCode = vpcAcqResponseCode;
	}

	/**
	 * @return the againLink
	 */
	public String getAgainLink() {
		return againLink;
	}

	/**
	 * @param againLink the againLink to set
	 */
	public void setAgainLink(String againLink) {
		this.againLink = againLink;
	}

	/**
	 * @return the vpcAVSCountry
	 */
	public String getVpcAVSCountry() {
		return vpcAVSCountry;
	}

	/**
	 * @param vpcAVSCountry the vpcAVSCountry to set
	 */
	public void setVpcAVSCountry(String vpcAVSCountry) {
		this.vpcAVSCountry = vpcAVSCountry;
	}

	/**
	 * @return the vpcAuthorizeId
	 */
	public String getVpcAuthorizeId() {
		return vpcAuthorizeId;
	}

	/**
	 * @param vpcAuthorizeId the vpcAuthorizeId to set
	 */
	public void setVpcAuthorizeId(String vpcAuthorizeId) {
		this.vpcAuthorizeId = vpcAuthorizeId;
	}

	/**
	 * @return the vpc3DSenrolled
	 */
	public String getVpc3DSenrolled() {
		return vpc3DSenrolled;
	}

	/**
	 * @param vpc3dSenrolled the vpc3DSenrolled to set
	 */
	public void setVpc3DSenrolled(String vpc3dSenrolled) {
		vpc3DSenrolled = vpc3dSenrolled;
	}

	/**
	 * @return the vpcRiskOverallResult
	 */
	public String getVpcRiskOverallResult() {
		return vpcRiskOverallResult;
	}

	/**
	 * @param vpcRiskOverallResult the vpcRiskOverallResult to set
	 */
	public void setVpcRiskOverallResult(String vpcRiskOverallResult) {
		this.vpcRiskOverallResult = vpcRiskOverallResult;
	}

	/**
	 * @return the vpcReceiptNo
	 */
	public String getVpcReceiptNo() {
		return vpcReceiptNo;
	}

	/**
	 * @param vpcReceiptNo the vpcReceiptNo to set
	 */
	public void setVpcReceiptNo(String vpcReceiptNo) {
		this.vpcReceiptNo = vpcReceiptNo;
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
	 * @return the vpcAVSStateProv
	 */
	public String getVpcAVSStateProv() {
		return vpcAVSStateProv;
	}

	/**
	 * @param vpcAVSStateProv the vpcAVSStateProv to set
	 */
	public void setVpcAVSStateProv(String vpcAVSStateProv) {
		this.vpcAVSStateProv = vpcAVSStateProv;
	}

	/**
	 * @return the vpcTxnResponseCode
	 */
	public String getVpcTxnResponseCode() {
		return vpcTxnResponseCode == null ? "" : vpcTxnResponseCode;
	}

	/**
	 * @param vpcTxnResponseCode the vpcTxnResponseCode to set
	 */
	public void setVpcTxnResponseCode(String vpcTxnResponseCode) {
		this.vpcTxnResponseCode = vpcTxnResponseCode;
	}

	/**
	 * @return the vpcVerToken
	 */
	public String getVpcVerToken() {
		return vpcVerToken;
	}

	/**
	 * @param vpcVerToken the vpcVerToken to set
	 */
	public void setVpcVerToken(String vpcVerToken) {
		this.vpcVerToken = vpcVerToken;
	}

	/**
	 * @return the vpcAmount
	 */
	public String getVpcAmount() {
		return vpcAmount;
	}
	
	public float getTotalAmount() {
		return Float.parseFloat(vpcAmount) / 100;
	}

	/**
	 * @param vpcAmount the vpcAmount to set
	 */
	public void setVpcAmount(String vpcAmount) {
		this.vpcAmount = vpcAmount;
	}

	/**
	 * @return the vpcBatchNo
	 */
	public String getVpcBatchNo() {
		return vpcBatchNo;
	}

	/**
	 * @param vpcBatchNo the vpcBatchNo to set
	 */
	public void setVpcBatchNo(String vpcBatchNo) {
		this.vpcBatchNo = vpcBatchNo;
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
	 * @return the vpcAVSResultCode
	 */
	public String getVpcAVSResultCode() {
		return vpcAVSResultCode;
	}

	/**
	 * @param vpcAVSResultCode the vpcAVSResultCode to set
	 */
	public void setVpcAVSResultCode(String vpcAVSResultCode) {
		this.vpcAVSResultCode = vpcAVSResultCode;
	}

	/**
	 * @return the vpcVerStatus
	 */
	public String getVpcVerStatus() {
		return vpcVerStatus;
	}

	/**
	 * @param vpcVerStatus the vpcVerStatus to set
	 */
	public void setVpcVerStatus(String vpcVerStatus) {
		this.vpcVerStatus = vpcVerStatus;
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
	 * @return the vpcMessage
	 */
	public String getVpcMessage() {
		return vpcMessage;
	}

	/**
	 * @param vpcMessage the vpcMessage to set
	 */
	public void setVpcMessage(String vpcMessage) {
		this.vpcMessage = vpcMessage;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the vpc3DSstatus
	 */
	public String getVpc3DSstatus() {
		return vpc3DSstatus;
	}

	/**
	 * @param vpc3dSstatus the vpc3DSstatus to set
	 */
	public void setVpc3DSstatus(String vpc3dSstatus) {
		vpc3DSstatus = vpc3dSstatus;
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

	/**
	 * @return the vpcCardNum
	 */
	public String getVpcCardNum() {
		return vpcCardNum;
	}

	/**
	 * @param vpcCardNum the vpcCardNum to set
	 */
	public void setVpcCardNum(String vpcCardNum) {
		this.vpcCardNum = vpcCardNum;
	}

	/**
	 * @return the vpcAVSPostCode
	 */
	public String getVpcAVSPostCode() {
		return vpcAVSPostCode;
	}

	/**
	 * @param vpcAVSPostCode the vpcAVSPostCode to set
	 */
	public void setVpcAVSPostCode(String vpcAVSPostCode) {
		this.vpcAVSPostCode = vpcAVSPostCode;
	}

	/**
	 * @return the vpcCSCResultCode
	 */
	public String getVpcCSCResultCode() {
		return vpcCSCResultCode;
	}

	/**
	 * @param vpcCSCResultCode the vpcCSCResultCode to set
	 */
	public void setVpcCSCResultCode(String vpcCSCResultCode) {
		this.vpcCSCResultCode = vpcCSCResultCode;
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
	 * @return the vpcVerType
	 */
	public String getVpcVerType() {
		return vpcVerType;
	}

	/**
	 * @param vpcVerType the vpcVerType to set
	 */
	public void setVpcVerType(String vpcVerType) {
		this.vpcVerType = vpcVerType;
	}

	/**
	 * @return the vpcVerSecurityLevel
	 */
	public String getVpcVerSecurityLevel() {
		return vpcVerSecurityLevel;
	}

	/**
	 * @param vpcVerSecurityLevel the vpcVerSecurityLevel to set
	 */
	public void setVpcVerSecurityLevel(String vpcVerSecurityLevel) {
		this.vpcVerSecurityLevel = vpcVerSecurityLevel;
	}

	/**
	 * @return the vpc3DSXID
	 */
	public String getVpc3DSXID() {
		return vpc3DSXID;
	}

	/**
	 * @param vpc3dsxid the vpc3DSXID to set
	 */
	public void setVpc3DSXID(String vpc3dsxid) {
		vpc3DSXID = vpc3dsxid;
	}

	/**
	 * @return the vpcAVS_City
	 */
	public String getVpcAVSCity() {
		return vpcAVSCity;
	}

	/**
	 * @param vpcAVS_City the vpcAVS_City to set
	 */
	public void setVpcAVSCity(String vpcAVSCity) {
		this.vpcAVSCity = vpcAVSCity;
	}

	public String getVpcLocale() {
		return vpcLocale;
	}

	public void setVpcLocale(String vpcLocale) {
		this.vpcLocale = vpcLocale;
	}

	public String getVpcCommercialCard() {
		return vpcCommercialCard;
	}

	public void setVpcCommercialCard(String vpcCommercialCard) {
		this.vpcCommercialCard = vpcCommercialCard;
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
	
}
