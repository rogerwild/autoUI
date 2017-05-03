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

public class MemberPageUI extends BasePageUI{
	
	/**
	 * button的集合
	 */
	public static final CommonUIBean MEMBERPAGE_BUTTONS = new CommonUIBean(GetElementWay.CLASS_NAME, "XCUIElementTypeButton", "MEMBERPAGE BUTTONS");
	/**
	 * VIP福利社按钮
	 */
	public static final CommonUIBean SUBSCRIBE_VIPWELLBE = new CommonUIBean(GetElementWay.NAME, "VIP福利社", "VIP福利社按钮");

}