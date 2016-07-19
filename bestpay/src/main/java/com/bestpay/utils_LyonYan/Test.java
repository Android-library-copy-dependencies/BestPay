package com.bestpay.utils_LyonYan;

import android.app.Activity;

public class Test {
	public void test(Activity activity) {
		KZBestPay bestPay = new KZBestPay(activity);
		KZBestPayRequestMode mode = new KZBestPayRequestMode();
		mode.setBestpay_BACKMERCHANTURL("http://www.*******.com/pay?best=ss");
		mode.setBestpay_BUSITYPE("04");
		mode.setBestpay_CURTYPE("RMB");
		mode.setBestpay_CUSTOMERID("******");
		mode.setBestpay_KEY("CC6AC85255984A46232CAB6170055D978C2E85A5D8B2459A");
		mode.setBestpay_MERCHANTID("******************");
		mode.setBestpay_MERCHANTPWD("******");
		mode.setBestpay_PRODUCTID("01");
		mode.setBestpay_SERVICE("mobile.security.pay");
		mode.setBestpay_sign_type("MD5");
		mode.setBestpay_USERIP("192.168.0.68");
		String s = String.valueOf(System.currentTimeMillis());
		mode.setFlowId("U" + s);
		mode.setOrderDesc("订单-U" + String.valueOf(System.currentTimeMillis()) + "消费");
		mode.setOrderPrice("99.00");
		mode.setType("sdk_bestpay");
		mode.setACCOUNTID("185******82");
		mode.setUrl("http://www.******.com/pay?best=ss");
		// 下单并支付
		bestPay.bestPayRequest(mode);
	}
}
