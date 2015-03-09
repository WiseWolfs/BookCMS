package com.njit.lib;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njit.lib.service.NewsService;


public class SpringTest {
	private ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testSpring() throws Exception {
		NewsService ua = (NewsService) ac.getBean("newsServiceImpl");
		System.out.println(ua);
	}
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sessionFactory);
		
	}
	@Test
	public void testTransaction() throws Exception {
		ServiceTest st = (ServiceTest) ac.getBean("serviceTest");
		st.saveTwoUsers();
	}
	

}
