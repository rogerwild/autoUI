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

public class SearchResultPageUI extends BasePageUI{
	
	/**
	 * 返回按钮
	 */
	public static final CommonUIBean SEARCHRESULT_BACK = new CommonUIBean(GetElementWay.NAME, "search back", "SEARCHRESULT BACK");
	/**
	 * button的集合
	 */
	public static final CommonUIBean SEARCHRESULT_BUTTONS = new CommonUIBean(GetElementWay.CLASS_NAME, "XCUIElementTypeButton", "SEARCHRESULT BUTTONS");

}