package com.bestpay.utils_LyonYan;

/**
 * 转换翼支付请求参数的json
 * 
 * @author 颜宁<br>
 *         2016年4月20日下午2:58:00<br>
 */
public class KZBestPayRequestMode {
	private String bestpay_MERCHANTID;
	private String bestpay_MERCHANTPWD;
	private String bestpay_CUSTOMERID;
	private String bestpay_KEY;
	private String bestpay_USERIP;
	private String bestpay_BUSITYPE;
	private String bestpay_PRODUCTID;
	private String bestpay_CURTYPE;
	private String bestpay_SERVICE;
	private String bestpay_BACKMERCHANTURL;
	private String bestpay_sign_type;
	private String bestpay_private_key;
	/**
	 * 
	 */
	private String url;
	private String type;
	/**
	 * 订单价格
	 */
	private String orderPrice;
	/**
	 * 订单流水号
	 */
	private String flowId;
	/**
	 * 订单描述
	 */
	private String orderDesc;
	/**
	 * 
	 */
	private String ACCOUNTID;
	/**
	 * 附加参数
	 */
	private String ATTACH = "";
	/**
	 * 
	 */
	private String MAC;

	public String getACCOUNTID() {
		return ACCOUNTID;
	}

	public void setACCOUNTID(String aCCOUNTID) {
		ACCOUNTID = aCCOUNTID;
	}

	public String getUrl() {
		// try {
		// return URLEncoder.encode(url, "utf-8");
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderPrice() {
		/**
		 * test
		 */
//		if (true) {
//			return "0.01";
//		}
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getBestpay_MERCHANTID() {
		return bestpay_MERCHANTID;
	}

	public void setBestpay_MERCHANTID(String bestpay_MERCHANTID) {
		this.bestpay_MERCHANTID = bestpay_MERCHANTID;
	}

	public String getBestpay_MERCHANTPWD() {
		return bestpay_MERCHANTPWD;
	}

	public void setBestpay_MERCHANTPWD(String bestpay_MERCHANTPWD) {
		this.bestpay_MERCHANTPWD = bestpay_MERCHANTPWD;
	}

	public String getBestpay_CUSTOMERID() {
		return bestpay_CUSTOMERID;
	}

	public void setBestpay_CUSTOMERID(String bestpay_CUSTOMERID) {
		this.bestpay_CUSTOMERID = bestpay_CUSTOMERID;
	}

	public String getBestpay_KEY() {
		return bestpay_KEY;
	}

	public void setBestpay_KEY(String bestpay_KEY) {
		this.bestpay_KEY = bestpay_KEY;
	}

	public String getBestpay_USERIP() {
		return bestpay_USERIP;
	}

	public void setBestpay_USERIP(String bestpay_USERIP) {
		this.bestpay_USERIP = bestpay_USERIP;
	}

	public String getBestpay_BUSITYPE() {
		return bestpay_BUSITYPE;
	}

	public void setBestpay_BUSITYPE(String bestpay_BUSITYPE) {
		this.bestpay_BUSITYPE = bestpay_BUSITYPE;
	}

	public String getBestpay_PRODUCTID() {
		return bestpay_PRODUCTID;
	}

	public void setBestpay_PRODUCTID(String bestpay_PRODUCTID) {
		this.bestpay_PRODUCTID = bestpay_PRODUCTID;
	}

	public String getBestpay_CURTYPE() {
		return bestpay_CURTYPE;
	}

	public void setBestpay_CURTYPE(String bestpay_CURTYPE) {
		this.bestpay_CURTYPE = bestpay_CURTYPE;
	}

	public String getBestpay_SERVICE() {
		return bestpay_SERVICE;
	}

	public void setBestpay_SERVICE(String bestpay_SERVICE) {
		this.bestpay_SERVICE = bestpay_SERVICE;
	}

	public String getBestpay_BACKMERCHANTURL() {

//		try {
//			Log.d("Lyon", "pay-->"+bestpay_BACKMERCHANTURL);
//			bestpay_BACKMERCHANTURL = URLEncoder.encode(bestpay_BACKMERCHANTURL, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return bestpay_BACKMERCHANTURL;
	}

	public void setBestpay_BACKMERCHANTURL(String bestpay_BACKMERCHANTURL) {
		this.bestpay_BACKMERCHANTURL = bestpay_BACKMERCHANTURL;
	}

	public String getBestpay_sign_type() {
		return bestpay_sign_type;
	}

	public void setBestpay_sign_type(String bestpay_sign_type) {
		this.bestpay_sign_type = bestpay_sign_type;
	}

	public String getBestpay_private_key() {
		return bestpay_private_key;
	}

	public void setBestpay_private_key(String bestpay_private_key) {
		this.bestpay_private_key = bestpay_private_key;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}

	// 附加字段
	public String getATTACH() {
		return ATTACH;
	}

	public void setATTACH(String aTTACH) {
		ATTACH = aTTACH;
	}
}
