package com.njit.lib.service.impl;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.Article;
import com.njit.lib.domain.User;
import com.njit.lib.service.ArticleService;
@Service
@Transactional
public class ArticleServiceImpl extends DaoSupportImpl<Article> implements ArticleService{
	@Override
	public void add(Article entity) {
		//封装属性
		entity.setPublishTime(new Date());
		entity.setRemarkCount(0);
		entity.setUser((User) ServletActionContext.getRequest().getSession().getAttribute("user"));
		entity.setViewCount(0);
		entity.setRemarks(null);
		super.add(entity);
	}
}
