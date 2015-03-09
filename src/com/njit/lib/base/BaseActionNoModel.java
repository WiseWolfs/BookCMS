package com.njit.lib.base;

import javax.annotation.Resource;

import com.njit.lib.service.AdvertisementService;
import com.njit.lib.service.ArticleService;
import com.njit.lib.service.ChannelService;
import com.njit.lib.service.MessageService;
import com.njit.lib.service.NewsService;
import com.njit.lib.service.RemarkService;
import com.njit.lib.service.UserService;

public class BaseActionNoModel {
	//========================Service
	@Resource
	protected UserService userService;
	@Resource
	protected AdvertisementService advertisementService;
	@Resource
	protected ChannelService channelService;
	@Resource
	protected NewsService newsService;
	@Resource
	protected MessageService messageService;
	@Resource
	protected RemarkService remarkService;
	@Resource
	protected ArticleService articleService;
	
	//============分页信息
	protected int currentPage=1;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
