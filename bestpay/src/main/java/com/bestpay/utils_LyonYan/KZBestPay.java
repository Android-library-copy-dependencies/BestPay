package com.bestpay.utils_LyonYan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bestpay.app.PaymentTask;
import com.bestpay.tools.CryptTool;
import com.bestpay.tools.Util;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 支付
 * 
 * @author 颜宁<br>
 *         2016年4月15日上午9:21:51<br>
 */
public class KZBestPay {
	private Activity activity;
	private KZBestPayRequestMode mode;
public void setMode(KZBestPayRequestMode mode) {
	this.mode = mode;
}
	public KZBestPay(Activity activity) {
		super();
		this.setActivity(activity);
	}

	/**
	 * 下單并支付接口
	 * 
	 * @author 颜宁<br>
	 *         2016年4月20日下午3:49:32<br>
	 * @param mobile
	 *            手机号
	 * @param type
	 *            支付方式
	 * @param url
	 *            商品信息
	 * @param flowId
	 *            订单流水号
	 * @param orderDesc
	 *            订单描述
	 * @param orderPrice
	 *            订单金额
	 * @param payParamsJson
	 *            支付信息
	 */
	public void bestPayRequest(String mobile, String type, String url, String flowId, String orderDesc,
			String orderPrice, KZBestPayRequestMode payParamsJson) {
		setMode(payParamsJson);
		setModeE(mobile, type, url, flowId, orderDesc, orderPrice);
		bestPayRequest(mode);
	}

	/**
	 * 支付接口
	 * 
	 * @author 颜宁<br>
	 *         2016年4月20日下午3:49:32<br>
	 * @param mobile
	 *            手机号
	 * @param type
	 *            支付方式
	 * @param url
	 *            商品信息
	 * @param flowId
	 *            订单流水号
	 * @param orderDesc
	 *            订单描述
	 * @param orderPrice
	 *            订单金额
	 * @param payParamsJson
	 *            支付信息
	 */
	public void bestPay(String mobile, String type, String url, String flowId, String orderDesc, String orderPrice,
			KZBestPayRequestMode payParamsJson) {
		setMode(payParamsJson);
		setModeE(mobile, type, url, flowId, orderDesc, orderPrice);
		bestPay(mode);
	}

	private String getSign(KZBestPayRequestMode mode) {
		String sign = null;
		StringBuffer md5Buffer = new StringBuffer(getBestPayRequestPreString(mode));
		try {
			Log.d("Lyon", "requestPayP-->" + md5Buffer.toString());
			sign = CryptTool.md5Digest(md5Buffer.toString());

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sign;
	}

	private String getBestPayRequestPreString(KZBestPayRequestMode mode) {
		return new StringBuffer().append("SERVICE=").append(mode.getBestpay_SERVICE()).append("&MERCHANTID=")
				.append(mode.getBestpay_MERCHANTID()).append("&MERCHANTPWD=").append(mode.getBestpay_MERCHANTPWD())
				.append("&SUBMERCHANTID=").append("").append("&BACKMERCHANTURL=")
				.append(mode.getBestpay_BACKMERCHANTURL()).append("&ORDERSEQ=").append(mode.getFlowId())
				.append("&ORDERREQTRANSEQ=").append(mode.getFlowId()).append("&ORDERTIME=").append(getORDERTIME())
				.append("&ORDERVALIDITYTIME=")//.append(getORDERVALIDITYTIME())
				.append("&CURTYPE=")
				.append(mode.getBestpay_CURTYPE()).append("&ORDERAMOUNT=").append(mode.getOrderPrice())
				.append("&SUBJECT=").append(mode.getOrderDesc()).append("&PRODUCTID=")
				.append(mode.getBestpay_PRODUCTID()).append("&PRODUCTDESC=").append(mode.getOrderDesc())
				.append("&CUSTOMERID=").append(mode.getBestpay_CUSTOMERID()).append("&SWTICHACC=").append("true")
				.append("&KEY=").append(mode.getBestpay_KEY()).toString();
	}

	private String getBestPayRequestString(KZBestPayRequestMode mode) {
		if (requestPayString == null) {
			requestPayString =
					getBestPayRequestPreString(mode) + "&PRODUCTAMOUNT=" + mode.getOrderPrice() + "&ATTACHAMOUNT=" + "0"
							+ "&ATTACH=" + mode.getATTACH() + "&USERIP=" + mode.getBestpay_USERIP() + "&DIVDETAILS="
							+ "" + "&ACCOUNTID=" + mode.getACCOUNTID() + "&BUSITYPE=" + mode.getBestpay_BUSITYPE()
							+ "&SIGN=" + getSign(mode) + "&SIGNTYPE=" + mode.getBestpay_sign_type();
		}
		Log.d("Lyon", "requestPay-->" + requestPayString);
		return requestPayString;
	}

	/**
	 * 
	 * @author 颜宁<br>
	 *         2016年5月5日上午11:09:31<br>
	 * @return
	 */
	private String getORDERTIME() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 下單并支付接口
	 * 
	 * @author 颜宁<br>
	 *         2016年4月15日上午10:06:04<br>
	 * @param mode
	 *            支付信息
	 */
	public void bestPayRequest(final KZBestPayRequestMode mode) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String orderResult = Util.order(mode.getBestpay_MERCHANTID(), mode.getFlowId(), mode.getFlowId(),
						getORDERTIME(), mode.getBestpay_KEY(), mode.getOrderPrice(), "", "01", "");
				if (orderResult != null && "00".equals((orderResult.split("&"))[0])) {
					bestPayTool(mode);
				} else {
					activity.runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(activity, "下单失败", Toast.LENGTH_SHORT).show();
						}
					});
				}
			}
		}).start();
	}

	/**
	 * 支付接口
	 * 
	 * @author 颜宁<br>
	 *         2016年4月15日上午10:06:04<br>
	 * @param mode
	 *            支付信息
	 */
	public void bestPay(KZBestPayRequestMode mode) {
		bestPayTool(mode);
	}

	/**
	 * 
	 * @author 颜宁<br>
	 *         2016年4月20日下午3:34:11<br>
	 * @param mobile
	 *            手机号
	 * @param type
	 * @param url
	 * @param flowId
	 * @param orderDesc
	 */
	private void setModeE(String mobile, String type, String url, String flowId, String orderDesc, String orderPrice) {
		mode.setType(type);
		mode.setUrl(url);
		mode.setFlowId(flowId);
		mode.setOrderDesc(orderDesc);
		mode.setOrderPrice(orderPrice);
		mode.setACCOUNTID(mobile);
	}

	/**
	 * 支付接口
	 * 
	 * @author 颜宁<br>
	 *         2016年4月15日上午10:04:32<br>
	 * @param requestBestPay
	 */
	private void bestPayTool(KZBestPayRequestMode mode) {
		final String s = getBestPayRequestString(mode);
		activity.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new PaymentTask(activity).pay(s);
			}
		});
	}

	private String requestPayString;

	/**
	 * Activity回调
	 * 
	 * @author 颜宁<br>
	 *         2016年4月20日下午2:47:07<br>
	 * @param requestCode
	 * @param resultCode
	 * @param data
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		for (onActivityResultListener onActivityResultListener : activityResultListeners) {
			onActivityResultListener.onActivityResult(requestCode, resultCode, data);
		}
	}

	private List<onActivityResultListener> activityResultListeners = new ArrayList<>();

	/**
	 * 回调监听
	 * 
	 * @author 颜宁<br>
	 *         2016年4月20日下午2:50:41<br>
	 * @param activityResultListener
	 */
	public void addActivityResultListener(onActivityResultListener activityResultListener) {
		activityResultListeners.add(activityResultListener);
	}

	/**
	 * 
	 * 回调监听
	 * 
	 * @author 颜宁<br>
	 *         2016年4月20日下午2:51:08<br>
	 * @param activityResultListener
	 */
	public void removeActivityResultListener(onActivityResultListener activityResultListener) {
		activityResultListeners.remove(activityResultListener);
	}

	/**
	 * 监听器
	 * 
	 * @author 颜宁<br>
	 *         2016年4月15日上午10:17:03<br>
	 */
	public interface onActivityResultListener {
		public void onActivityResult(int requestCode, int resultCode, Intent data);
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
