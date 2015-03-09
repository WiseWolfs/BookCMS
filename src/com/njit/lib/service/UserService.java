package com.njit.lib.service;


import com.njit.lib.base.DaoSupport;
import com.njit.lib.domain.User;

public interface UserService extends DaoSupport<User>{
	/**
	 * 初始化密码 
	 */
	void initPass(User user);
	/**
	 * 登陆验证
	 * @param loginName
	 * @param password
	 * @return
	 */
	User findUserByLoginNameAndPassword(String loginName, String password);

}
