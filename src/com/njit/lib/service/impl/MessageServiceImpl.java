package com.njit.lib.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.Message;
import com.njit.lib.domain.User;
import com.njit.lib.service.MessageService;
import com.opensymphony.xwork2.ActionContext;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class MessageServiceImpl extends DaoSupportImpl<Message> implements MessageService{

	@Override
	public void add(Message entity) {
		//封装model的属性
		entity.setPublishTime(new Date());
		entity.setRemarks(null);
		entity.setUser((User) ServletActionContext.getRequest().getSession().getAttribute("user"));
		entity.setAgree(false);
		entity.setAgreeCount(0);
		entity.setDisagreeCount(0);
		super.add(entity);
	}

	
	public List<Message> findLastFive() {
		return getSession().createQuery(
			"FROM Message m ORDER BY m.publishTime DESC ")
			.setFirstResult(0)
			.setMaxResults(5)
			.list();
	}

}
