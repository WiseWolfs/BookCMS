package com.njit.lib.service;

import java.util.List;

import com.njit.lib.base.DaoSupport;
import com.njit.lib.domain.Channel;

public interface ChannelService extends DaoSupport<Channel>{

	List<Channel> findAll(int type);

}
