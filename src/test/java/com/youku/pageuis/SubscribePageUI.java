/**
 * 
 */
/**
 * @author roger
 *
 */
package com.youku.pageuis;

import macaca.java.biz.BasePageUI;
import macaca.java.biz.CommonUIBean;

import macaca.client.common.GetElementWay;

public class SubscribePageUI extends BasePageUI{
	
	/**
	 * button的集合
	 */
	public static final CommonUIBean SUBSCRIBE_BUTTONS = new CommonUIBean(GetElementWay.CLASS_NAME, "XCUIElementTypeButton", "SUBSCRIBE BUTTONS");
	/**
	 * 我的订阅按钮
	 */
	public static final CommonUIBean SUBSCRIBE_MYSUBSCRIBE = new CommonUIBean(GetElementWay.NAME, "我的订阅", "我的订阅按钮");

}