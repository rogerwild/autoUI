package com.youku.cases;

import org.junit.Test;

import macaca.java.biz.BaseErrorType;
import macaca.java.biz.ResultGenerator;

import com.youku.pages.DownLoadCenterPage;
import com.youku.pages.HomePage;
import com.youku.pages.MemberPage;
import com.youku.pages.MinePage;
import com.youku.pages.VideoDetialPage;
import com.youku.pageuis.DownLoadCenterUI;
import com.youku.pageuis.HomePageUI;
import com.youku.pageuis.MemberPageUI;
import com.youku.pageuis.MinePageUI;
import com.youku.pageuis.VideoDetialPageUI;
import com.youku.pages.SearchPage;
import com.youku.pages.SearchResultPage;
import com.youku.pages.SubscribePage;
import com.youku.pageuis.SearchPageUI;
import com.youku.pageuis.SearchResultPageUI;
import com.youku.pageuis.SubscribePageUI;

public class SmokeTest extends BaseTest{

	@Test
	public void test_case_1() throws Exception{
		
		//测试首页，是否正常打开
		HomePage homePage = new HomePage("首页");
		homePage.setDriver(driver);
		
		//向上滑动页面
		homePage.scrollToBottom();
		
		if(homePage.hasPageShown(HomePageUI.HOME_TAB)){
			//首页截屏
			saveScreen(homePage.pageDesc);
			//页面加载成功日志记录
			ResultGenerator.loadPageSucc(homePage);
			
			//向上滑动页面
			homePage.scrollToBottom();
			saveScreen("滑动页面查看数据");
			homePage.resume();
			
			//点击首页轮播图下方的视频
			homePage.clickCell(2);
			
		}else{
			//页面加载失败日志记录
			ResultGenerator.loadPageFail(homePage);
			//首页如果加载失败，直接退出测试 return
			return;
		}
		
		//播放页
		driver.sleep(5000);
		VideoDetialPage videoDetialPage = new VideoDetialPage("视频详情页");
		videoDetialPage.setDriver(driver);
		if(videoDetialPage.hasPageShown(VideoDetialPageUI.BACK)){
			saveScreen(videoDetialPage.pageDesc);
			ResultGenerator.loadPageSucc(videoDetialPage);
					
			videoDetialPage.clikBack();
			
		}else{
			ResultGenerator.loadPageFail(videoDetialPage);
		}
		
		//切换频道
		for(int i=0;i<3;i++){
			homePage.scrollLeft();
			saveScreen("切换频道页");
		}
		for(int i=0;i<3;i++){
			homePage.scrollRight();
		}
		
		//进入搜索首页（点击首页底部toolbar搜索按钮，它是当前页面倒数第3个button）
		homePage.backClickbutton(3);
		//搜索首页
		SearchPage searchPage=new SearchPage("搜索首页");
		searchPage.setDriver(driver);
		if(searchPage.hasPageShown(SearchPageUI.SEARCH_HOTLIST)){
		saveScreen(searchPage.pageDesc);
			ResultGenerator.loadPageSucc(searchPage);
					
			//向搜索框中输入内容搜索
			searchPage.searchInput("倒霉熊");
			searchPage.clickKeyboardS();
			searchPage.clickKeyboardS();
			
					
		}else{
			ResultGenerator.loadPageFail(searchPage);
		}
		
		//搜索结果页
		SearchResultPage searchResultPage=new SearchResultPage("搜索结果页");
		searchResultPage.setDriver(driver);
		if(searchResultPage.hasPageShown(SearchResultPageUI.SEARCHRESULT_BACK)){
			saveScreen(searchResultPage.pageDesc);
			ResultGenerator.loadPageSucc(searchResultPage);
			
			//上下滑动页面
			searchResultPage.scroll();
			//点击第一个海报图
			searchResultPage.clikButton(3);
			
		}else{
			ResultGenerator.loadPageFail(searchResultPage);
		}
		
		//播放页
		//下载某集视频
		videoDetialPage.downLoad();
		videoDetialPage.toDownLoadCenter();
		
		DownLoadCenterPage downLoadPage = new DownLoadCenterPage("缓存中心");
		downLoadPage.setDriver(driver);
		if(downLoadPage.hasPageShown(DownLoadCenterUI.DOWNLOADCENTER_BACK)){
			saveScreen(downLoadPage.pageDesc);
			ResultGenerator.loadPageSucc(downLoadPage);
			//返回
			downLoadPage.clikBack();
		}else{
			ResultGenerator.loadPageFail(downLoadPage);
		}
		
		//返回
		videoDetialPage.closeDownLoad();
		videoDetialPage.clikBack();
		
		//进入订阅模块
		searchResultPage.oppositeClikBtn(4);
		driver.sleep(2000);
		SubscribePage subscribePage=new SubscribePage("订阅模块");
		subscribePage.setDriver(driver);
		if(subscribePage.hasPageShown(SubscribePageUI.SUBSCRIBE_MYSUBSCRIBE)){
			saveScreen(subscribePage.pageDesc);
			ResultGenerator.loadPageSucc(subscribePage);
			
			
		}else{
			ResultGenerator.loadPageFail(subscribePage);
		}
		
		//进入会员模块
		subscribePage.oppositeClikBtn(2);
		driver.sleep(2000);
		//会员模块
		MemberPage memberPage = new MemberPage("会员模块");
		memberPage.setDriver(driver);
		if(memberPage.hasPageShown(MemberPageUI.SUBSCRIBE_VIPWELLBE)){
			saveScreen(memberPage.pageDesc);
			ResultGenerator.loadPageSucc(memberPage);
			
			
		}else{
			ResultGenerator.loadPageFail(memberPage);
		}
		
		//进入我的模块
		memberPage.oppositeClikBtn(1);
		driver.sleep(2000);
		
		//我的模块		
		MinePage minePage = new MinePage("我的模块");
		minePage.setDriver(driver);
		if(minePage.hasPageShown(MinePageUI.MINEPAGE_SETUP)){
			saveScreen(minePage.pageDesc);
			ResultGenerator.loadPageSucc(minePage);
		}else{
			ResultGenerator.loadPageFail(minePage);
		}
		
				
		
	}

}
