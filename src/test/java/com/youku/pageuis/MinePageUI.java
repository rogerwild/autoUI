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

public class MinePageUI extends BasePageUI{
	
	/**
	 * button的集合
	 */
	public static final CommonUIBean MINEPAGE_BUTTONS = new CommonUIBean(GetElementWay.CLASS_NAME, "XCUIElementTypeButton", "MINEPAGE BUTTONS");
	/**
	 * 设置按钮
	 */
	public static final CommonUIBean MINEPAGE_SETUP = new CommonUIBean(GetElementWay.NAME, "设置", "设置按钮");

}