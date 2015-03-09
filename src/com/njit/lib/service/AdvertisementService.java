package com.njit.lib.service;

import java.util.List;

import com.njit.lib.base.DaoSupport;
import com.njit.lib.domain.Advertisement;
import com.njit.lib.domain.SplitBean;

public interface AdvertisementService extends DaoSupport<Advertisement>{

	List<Advertisement> findTopFive();
	//获取上一条记录
	Advertisement getUp(Long id);
	//获取下一条记录
	Advertisement getDown(Long id);

	

}
