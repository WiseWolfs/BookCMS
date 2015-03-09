package com.njit.lib.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.Role;
import com.njit.lib.domain.User;
import com.njit.lib.service.UserService;
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{
	@Override
	public void add(User entity) {
		//封装默认属性
		entity.setDonateCount(0);
		entity.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		if(entity.getQq()==null){
			entity.setQq(0L);
		}
		Role role = (Role)getSession().createQuery(
							"FROM Role r WHERE r.name ='普通用户' ")
							.uniqueResult();
		entity.setRole(role);
		//TODO 从这里就可以看出来，我们将注册和管理员添加用户放在一个action中，看上去简洁了不少，但是注册的时候，要填很多信息
		//但是添加用户不需要，这就需要写多个if这样的判断！
		//设置address的name（将值串起来）
		if(entity.getAddress()!=null){
			
			entity.getAddress().setName(entity.getAddress()+"");
		}else{
			entity.setAddress(null);
		}
		if(entity.getPassword()!=null){
			//密码进行加密处理
			entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));
		}
		if(entity.getImageName()==null){
			entity.setImageName("default.png");
		}
		System.out.println(entity.getName()+"-------name到底有无乱码");
		super.add(entity);
	}

	public void initPass(User user) {
		user.setPassword(DigestUtils.md5Hex("123456"));
		super.update(user);
		
	}

	public User findUserByLoginNameAndPassword(String loginName, String password) {
		String md5Pass = DigestUtils.md5Hex(password);
		User user = (User)super.getSession().createQuery(
							"FROM User u WHERE u.loginName =? AND u.password =? ")
							.setParameter(0, loginName)
							.setParameter(1, md5Pass)
							.uniqueResult();
		return user;
	}


}
