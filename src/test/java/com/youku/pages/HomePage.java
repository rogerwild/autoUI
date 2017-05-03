/**
 * 
 */
/**
 * @author roger
 *
 */
package com.youku.pages;

import macaca.client.common.GetElementWay;
import macaca.java.biz.BasePage;

import com.alibaba.fastjson.JSONObject;
import com.youku.pageuis.HomePageUI;

public class HomePage extends BasePage {

	public HomePage(String pageDesc) {
		super(pageDesc);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 点击当前页面指定的button
	 * @param index 要点击的button的index,限可视区域
	 */
	public void clickButton(int index) throws Exception{
		driver.onclickBeanAtIndex(HomePageUI.HOME_BUTTONS,index);
	}
	/**
	 * 点击当前页面倒数指定的某个button
	 * @param index 要点击的button倒数的index,限可视区域
	 * @return 
	 */
	public void backClickbutton(int index) throws Exception{
		driver.onclickBeanAtIndex(HomePageUI.HOME_BUTTONS,driver.countOfElment(HomePageUI.HOME_BUTTONS) - index);
	}
	/**
	 * 滑动到某个element
	 * @param element 控件的名字
	 */
	public void scrollToElement(String element) throws Exception{
		driver.scrollToElementCustom(GetElementWay.NAME, element,true,2000);
	}
	/**
	 * 向上滑动页面
	 */
	public void scrollToBottom() {
		driver.scrollToBottomOrTop(true, true);
	}
	/**
	 * 点击当前页面指定的Cell
	 * @param index 要点击的Cell的index,限可视区域
	 */
	public void clickCell(int index) throws Exception{
		driver.onclickBeanAtIndex(HomePageUI.HOME_CELL,index);
	}
	/**
	 * 左滑页面切换频道
	 * @throws Exception
	 */
	public void scrollLeft() throws Exception{

		JSONObject windowSize = driver.getWindowSize();
		int windowX = windowSize.getIntValue("width");//768
		int windowY = windowSize.getIntValue("height");//1024
		
		int startX =(int) windowX/2;
  		int	endX = startX;
  		int	startY = windowY*4/5;
  		int	endY = windowY*1/5;

		driver.drag(startX, startY, endX, endY, 0.005, 10);
		driver.sleep(2000);

	}
	/**
	 * 右滑页面切换频道
	 * @throws Exception
	 */
	public void scrollRight() throws Exception{

		JSONObject windowSize = driver.getWindowSize();
		int windowX = windowSize.getIntValue("width");//768
		int windowY = windowSize.getIntValue("height");//1024
		
		int startX =(int) windowX/2;
  		int	endX = startX;
  		int	startY = windowY*1/5;
  		int	endY = windowY*4/5;

		driver.drag(startX, startY, endX, endY, 0.005, 10);
		driver.sleep(2000);

	}
	/**
	 * 回到页面顶部
	 * @throws Exception
	 */
	public void resume() throws Exception{

		driver.onclickBean(HomePageUI.HOME_HEAD);

	}

}