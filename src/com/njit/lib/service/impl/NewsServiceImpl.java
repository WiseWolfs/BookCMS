package com.njit.lib.service.impl;


import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.News;
import com.njit.lib.domain.SplitBean;
import com.njit.lib.service.NewsService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class NewsServiceImpl extends DaoSupportImpl<News> implements NewsService {

	
	@Override
	public News getById(Long id) {
		return super.getById(id);
	}
	
	public List<News> findAll(int type) {
		List list = getSession().createQuery(
				"FROM News n WHERE n.type=? ORDER BY publishTime DESC")
				.setParameter(0, type)
				.list();
		if(list!=null){
			return list;
		}
		return Collections.EMPTY_LIST;
	}
	
	public List<News> findSinglePage(int type,SplitBean splitBean) {
		return getSession().createQuery(
				"FROM News n WHERE n.type =?")
				.setParameter(0, type)
				.setFirstResult((splitBean.getCurrentPage()-1)*splitBean.getCountPage())
				.setMaxResults(splitBean.getCountPage())
				.list();
	}

	public List findLastFive(int type) {
		return getSession().createQuery(
				"FROM News n WHERE n.type=? ORDER BY n.publishTime DESC")
				.setParameter(0, type)
				.setFirstResult(0)
				.setMaxResults(5)
				.list()
				;
	}

	public News getPrevious(Long id,int type) {
		//select * from news where id>11  order by publishTime limit 0,1;
		Query query =getSession().createQuery(
								"FROM News n WHERE n.id > ? AND n.type = ? ORDER BY n.publishTime ")
								.setParameter(0, id)
								.setParameter(1, type)
								.setFirstResult(0)
								.setMaxResults(1);
		
		return (News) query.uniqueResult();
	}

	public News getNext(Long id, int type) {
		return (News) getSession().createQuery(
							"FROM News n WHERE n.id< ? AND n.type= ? ORDER BY n.publishTime DESC ")
							.setParameter(0, id)
							.setParameter(1, type)
							.setFirstResult(0)
							.setMaxResults(1)
							.uniqueResult();
	}
	

}
