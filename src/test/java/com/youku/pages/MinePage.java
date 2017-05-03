/**
 * 
 */
/**
 * @author roger
 *
 */
package com.youku.pages;

import macaca.java.biz.BasePage;

import com.alibaba.fastjson.JSONObject;
import com.youku.pageuis.MemberPageUI;
import com.youku.pageuis.MinePageUI;
import com.youku.pageuis.SubscribePageUI;

public class MinePage extends BasePage {

	public MinePage(String pageDesc) {
		super(pageDesc);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 点击倒数指定的button
	 * @param index button倒数的索引
	 * @throws Exception 
	 */
	public void oppositeClikBtn(int index) throws Exception {
		int i= driver.countOfElment(MinePageUI.MINEPAGE_BUTTONS);
		driver.onclickBeanAtIndex(MinePageUI.MINEPAGE_BUTTONS, i-index);
	}

}