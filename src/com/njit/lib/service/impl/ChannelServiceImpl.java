package com.njit.lib.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.Channel;
import com.njit.lib.service.ChannelService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class ChannelServiceImpl extends DaoSupportImpl<Channel> implements ChannelService {

	public List<Channel> findAll(int type) {
		return getSession().createQuery(
				"FROM Channel c WHERE c.type =?")
				.setParameter(0, type)
				.list();
	}

}
