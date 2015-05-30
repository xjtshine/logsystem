package org.woa.logsystem.common;

/**
 * 系统常量类
 * @author Administrator
 *
 */
public class Constants {

	/**
	 * 当天的下载总次数
	 */
	public static final int SYSTEM_DOWNLOAD_TIMES = 1;
	
	/**
	 * 当天每个代理商的下载总次数
	 */
	public static final int AGNET_DOWNLOAD_TIMES =2;
	
	/**
	 * 当天不重复客户端ID的激活总次数
	 */
	public static final int SYSTEM_ACTIVATION_TIMES =3;
	
	/**
	 * 当天不重复客户端ID分每个代理商的激活总次数
	 */
	public static final int AGENT_ACTIVATION_TIMES = 4;
	
	/**
	 * 当天总付费金额
	 */
	public static final int SYSTEM_PAYMENT_TOTAL = 5;
	
	/**
	 * 当天每个代理商的付费金额
	 */
	public static final int AGENT_PAYMENT_TOTAL = 6;
	
	/**
	 * 当天付费客户端ID数除以当天有过登录操作的客户端ID数
	 */
	public static final int SYSTEM_PAYMENT_RATE = 7;
	
}
