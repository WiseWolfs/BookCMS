package com.njit.lib.base;

import java.util.List;

import com.njit.lib.domain.SplitBean;


public interface DaoSupport<T> {
	public void add(T entity);//增加
	public void update(T entity);//改
	public T getById(Long id);//查
	public void delete(Long id);
	public List<T> findAll();
	//查询分页列表
	public List<T> findSinglePage(SplitBean splitBean);

}
