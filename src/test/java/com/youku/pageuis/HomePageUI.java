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

public class HomePageUI extends BasePageUI{
	/**
	 * 头条
	 */
	public static final CommonUIBean HOME_TAB = new CommonUIBean(GetElementWay.NAME, "头条", "HOME TAB");
	/**
	 * 首页button的集合
	 */
	public static final CommonUIBean HOME_BUTTONS = new CommonUIBean(GetElementWay.CLASS_NAME, "XCUIElementTypeButton", "HOME BUTTONS");
	/**
	 * 首页ScrollView的集合
	 */
	public static final CommonUIBean HOME_SCROLLVIEW = new CommonUIBean(GetElementWay.CLASS_NAME, "XCUIElementTypeScrollView", "首页ScrollView");
	/**
	 * 首页Cell的集合
	 */
	public static final CommonUIBean HOME_CELL = new CommonUIBean(GetElementWay.CLASS_NAME, "XCUIElementTypeCell", "首页Cell");
	
	/**
	 * 头部iPad
	 */
	public static final CommonUIBean HOME_HEAD = new CommonUIBean(GetElementWay.NAME, "iPad", "HOME HEAD");

}