package com.njit.lib.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.Advertisement;
import com.njit.lib.domain.SplitBean;
import com.njit.lib.service.AdvertisementService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class AdvertisementServiceImpl extends DaoSupportImpl<Advertisement> implements AdvertisementService {
	/**
	 * 首页有5各个动态展示的广告栏
	 */
	@Override
	public List<Advertisement> findSinglePage(SplitBean splitBean) {
		return getSession().createQuery(
				"FROM Advertisement t ORDER BY t.position DESC ")
				.setFirstResult((splitBean.getCurrentPage()-1)*splitBean.getCountPage())
				.setMaxResults(splitBean.getCountPage())
				.list();
	}
	@Override
	public void add(Advertisement entity) {
		super.add(entity);
		//只有保存到数据库中才会生成id，否则抛出空指针异常
		entity.setPosition(entity.getId().intValue());
		super.update(entity);
	}
	
	public List<Advertisement> findTopFive() {
		return getSession().createQuery(
			"FROM Advertisement a ORDER BY a.position DESC")
			.setFirstResult(0)
			.setMaxResults(5)
			.list()
			;
	}

	public Advertisement getUp(Long id) {
		//SQL: select * from advertisement where position>1 order by position  limit 0,1;
		return (Advertisement) getSession().createQuery(
				"FROM Advertisement a where a.position > ? ORDER BY a.position ")
				.setParameter(0, super.getById(id).getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
	}
	public Advertisement getDown(Long id) {
		//SQL：select * from advertisement where position<1 order by position desc limit 0,1;
		return (Advertisement) getSession().createQuery(
							"FROM Advertisement a where a.position < ? ORDER BY a.position DESC ")
							.setParameter(0, super.getById(id).getPosition())
							.setFirstResult(0)
							.setMaxResults(1)
							.uniqueResult();
	}





}
