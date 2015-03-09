package com.njit.lib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import com.njit.lib.domain.User;

public class HibernateTest {
	private SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(new User());
		session.getTransaction().commit();
	}

}
