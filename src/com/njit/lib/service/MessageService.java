package com.njit.lib.service;

import java.util.List;

import com.njit.lib.base.DaoSupport;
import com.njit.lib.domain.Message;

public interface MessageService extends DaoSupport<Message>{

	List<Message> findLastFive();
	

}
