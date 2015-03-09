package com.njit.lib.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.njit.lib.service.AdvertisementService;
import com.njit.lib.service.ArticleService;
import com.njit.lib.service.ChannelService;
import com.njit.lib.service.MessageService;
import com.njit.lib.service.NewsService;
import com.njit.lib.service.RemarkService;
import com.njit.lib.service.RoleService;
import com.njit.lib.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private Class<T> clazz;
	protected T model;
	public BaseAction() {
		ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz =(Class<T>) pt.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public T getModel() {
		return model;
		
	}
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
	@Resource
	protected RoleService roleService;
	//============分页信息
	protected int currentPage=1;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
