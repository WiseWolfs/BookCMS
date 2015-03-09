package com.njit.lib.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.domain.SplitBean;
@SuppressWarnings("unchecked")
//TODO 这里不能加service什么的不能实例化
@Transactional
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {
	@Resource
	protected SessionFactory sessionFactory;
	private Class<T> clazz;
	//获取子类的真实类型
	public DaoSupportImpl(){
		ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
		System.out.println(clazz.getName()+"-------------->已经实例化");
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void add(T entity) {
		getSession().save(entity);
		
	}

	public List<T> findSinglePage(SplitBean splitBean) {
		return getSession().createQuery(
		"FROM "+clazz.getSimpleName())
		.setFirstResult((splitBean.getCurrentPage()-1)*splitBean.getCountPage())
		.setMaxResults(splitBean.getCountPage())
		.list();
	}

	public List<T> findAll() {
		return getSession().createQuery(
				"FROM "+clazz.getSimpleName())
				.list();
	}


	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(Long id) {
		getSession().delete(getById(id));
		
	}

	public T getById(Long id) {
		if(id==null){
			return null;
		}else{
			return (T) getSession().get(clazz, id);
		}
	}




}
