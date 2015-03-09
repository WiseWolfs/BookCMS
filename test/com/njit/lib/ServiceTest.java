package com.njit.lib;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.domain.User;
@Service
@Transactional
public class ServiceTest {
	@Resource
	private SessionFactory sessionFactory;
	@Test
	public void saveTwoUsers(){
		Session session =sessionFactory.getCurrentSession();
		session.save(new User());
	//	int a =1/0;
		session.save(new User());
		
	}

}
