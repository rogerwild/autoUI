package com.youku.cases;

import org.junit.Test;

import macaca.java.biz.BaseErrorType;
import macaca.java.biz.ResultGenerator;
import com.youku.pages.HomePage;
import com.youku.pages.VideoDetialPage;
import com.youku.pageuis.HomePageUI;
import com.youku.pageuis.VideoDetialPageUI;
import com.youku.pages.SearchPage;
import com.youku.pages.SearchResultPage;
import com.youku.pageuis.SearchPageUI;
import com.youku.pageuis.SearchResultPageUI;

public class SearchTest extends BaseTest{

	@Test
	public void test_case_1() throws Exception{
		
		//测试首页，是否正常打开
		HomePage homePage = new HomePage("首页");
		homePage.setDriver(driver);
		if(homePage.hasPageShown(HomePageUI.HOME_TAB)){
			//首页截屏
			saveScreen(homePage.pageDesc);
			//页面加载成功日志记录
			ResultGenerator.loadPageSucc(homePage);
			
			//进入搜索首页（点击首页底部toolbar搜索按钮，它是当前页面第8个button）
			homePage.clickButton(7);
		}else{
			//页面加载失败日志记录
			ResultGenerator.loadPageFail(homePage);
			//首页如果加载失败，直接退出测试 return
			return;
		}
		
		//搜索首页
		SearchPage searchPage=new SearchPage("搜索首页");
		searchPage.setDriver(driver);
		if(searchPage.hasPageShown(SearchPageUI.SEARCH_HOTLIST)){
			saveScreen(searchPage.pageDesc);
			ResultGenerator.loadPageSucc(searchPage);
			
			//点击海报图播放视频（当前页面第3个text）
			searchPage.clickText(2);
			
		}else{
			ResultGenerator.loadPageFail(searchPage);
		}
		
		//播放页
		driver.sleep(5000);
		VideoDetialPage player=new VideoDetialPage("播放器");
		player.setDriver(driver);
		if(player.hasPageShown(VideoDetialPageUI.BACK)){
			saveScreen(player.pageDesc);
			ResultGenerator.loadPageSucc(player);
			
			//点击返回按钮
			player.clikBack();
		}else{
			ResultGenerator.loadPageFail(player);
		}
		
		//点击热搜榜文字链（当前页面第6个text），进入搜索结果页
		searchPage.clickText(5);
		SearchResultPage searchResultPage=new SearchResultPage("搜索结果页");
		searchResultPage.setDriver(driver);
		if(searchResultPage.hasPageShown(SearchResultPageUI.SEARCHRESULT_BACK)){
			saveScreen("点击热搜榜文字链进入"+searchResultPage.pageDesc);
			ResultGenerator.loadPageSucc(searchResultPage);
			
			//上下滑动页面
			searchResultPage.scroll();
			//返回搜索首页
			searchResultPage.clikBack();
			
		}else{
			ResultGenerator.loadPageFail(searchResultPage);
		}
		
		//测试kubox，向搜索框输入内容
		searchPage.searchInput("动物世界");
		if(searchPage.hasPageShown(SearchPageUI.SEARCH_KUBOX)){
			saveScreen("kubox");
			ResultGenerator.success("向搜索框中输入关键词", "加载kubox成功");
			
			//点击kubox中的cell
			searchPage.clickKuboxSell();
			if(searchResultPage.hasPageShown(SearchResultPageUI.SEARCHRESULT_BACK)){
				saveScreen("点击kubox中的cell进入"+searchResultPage.pageDesc);
				ResultGenerator.loadPageSucc(searchResultPage);
				
				//返回搜索首页
				searchResultPage.clikBack();
				
			}else{
				ResultGenerator.loadPageFail(searchResultPage);
			}
			
		}else{
			ResultGenerator.fail("向搜索框中输入关键词", "加载kubox失败", BaseErrorType.PAGE_NOT_LOAD);
		}
		
		//测试键盘的搜索键
		searchPage.searchInput("动物世界");
		searchPage.clickKeyboardS();
		searchPage.clickKeyboardS();
		if(searchResultPage.hasPageShown(SearchResultPageUI.SEARCHRESULT_BACK)){
			saveScreen("点击键盘的搜索键进入"+searchResultPage.pageDesc);
			ResultGenerator.loadPageSucc(searchResultPage);
			
			//返回搜索首页
			searchResultPage.clikBack();
			
		}else{
			ResultGenerator.loadPageFail(searchResultPage);
		}
		
		//测试清空搜索历史
		searchPage.clearAll();
		saveScreen("清空所有搜索记录");
		ResultGenerator.customLog("清空所有记录", "");
		
		//测试搜全网按钮
		searchPage.searchInput("动物世界");
		searchPage.clickKeyboardH();
		searchPage.clickSearch();
		if(searchResultPage.hasPageShown(SearchResultPageUI.SEARCHRESULT_BACK)){
			saveScreen("点击搜全网按钮进入"+searchResultPage.pageDesc);
			ResultGenerator.loadPageSucc(searchResultPage);
			
			//返回搜索首页
			searchResultPage.clikBack();
			
		}else{
			ResultGenerator.loadPageFail(searchResultPage);
		}
		
		//测试点击搜索记录
		searchPage.clickHistory();
		if(searchResultPage.hasPageShown(SearchResultPageUI.SEARCHRESULT_BACK)){
			saveScreen("点击搜索记录进入"+searchResultPage.pageDesc);
			ResultGenerator.loadPageSucc(searchResultPage);
			
			//返回搜索首页
			searchResultPage.clikBack();
			
		}else{
			ResultGenerator.loadPageFail(searchResultPage);
		}
		
		//测试删除单条搜索记录
		searchPage.clearOne();
		saveScreen("删除单条搜索记录");
		ResultGenerator.customLog("删除单条搜索记录", "");		
		
	}

}
