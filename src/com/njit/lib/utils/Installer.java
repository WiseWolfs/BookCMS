package com.njit.lib.utils;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.domain.Privilege;
import com.njit.lib.domain.Role;
import com.njit.lib.domain.User;

/**
 * Action中哪些调转的链接需要加上权限控制呢？
 * ---》需要登录后才可以访问的URL，才需要加上权限控制。
 * 一些前端的URL是不需要加上控制权限的，例如：登录、注册、前台页面的展示等。
 * @author Administrator
 *
 */
@Service
@Transactional
public class Installer {
	public Installer(){
		System.out.println("Installer--------->已经实例化");
	}
	@Resource
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		Role admin = new Role("超级管理员", "管理一切");
		Role normal = new Role("普通用户","拥有我的图书馆");
		Set<Privilege> normalPrivils= new HashSet<Privilege>();
		Set<Privilege> privileges = new HashSet<Privilege>();
		Privilege adminParent,normalParent,child1,child2,child3,child4,child5,child6,child7,child8;
		//用户管理
		adminParent= new Privilege("用户管理", "/user_list");
		normalParent= new Privilege("用户管理","");
		child1= new Privilege("用户添加", "/user_add", adminParent);
		child2= new Privilege("用户删除", "/user_delete", adminParent);
		child3= new Privilege("用户修改", "/user_update", adminParent);
		child4= new Privilege("用户查询", "/user_list", adminParent);
		child5= new Privilege("用户资料","/user_show",adminParent);
		child6= new Privilege("我的图书馆","/user_MyLibrary",normalParent);
		child7= new Privilege("管理员后台","/user_index",adminParent);
		child8= new Privilege("初始化密码","/user_initPass",adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		privileges.add(child5);
		privileges.add(child6);
		privileges.add(child7);
		privileges.add(child8);
		
		normalPrivils.add(normalParent);
		normalPrivils.add(child6);
		
		
		//频道管理
		adminParent= new Privilege("频道管理", "/channel_list");
		child1= new Privilege("频道添加", "/channel_add", adminParent);
		child2= new Privilege("频道删除", "/channel_delete", adminParent);
		child3= new Privilege("频道修改", "/channel_update", adminParent);
		child4= new Privilege("频道查询", "/channel_list", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		
		
		//TODO 
		//首页管理(管理员)
		adminParent= new Privilege("首页管理", "/home_index");
		child1= new Privilege("首页顶端", "/home_top", adminParent);
		child2= new Privilege("首页左端", "/home_left", adminParent);
		child3= new Privilege("首页右端", "/home_right", adminParent);
		child4= new Privilege("首页底端", "/home_bottom", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		
		//我的图书馆管理(管理员不具有）
		normalParent= new Privilege("我的图书馆", "/user_MyLibrary");
		child1= new Privilege("页面顶部", "/library_top", normalParent);
		child2= new Privilege("页面右边", "/library_right", normalParent);
		child3= new Privilege("页面左边", "/library_left", normalParent);
		child4= new Privilege("页面底部", "/library_bottom", normalParent);
		
		normalPrivils.add(normalParent);
		normalPrivils.add(child1);
		normalPrivils.add(child2);
		normalPrivils.add(child3);
		normalPrivils.add(child4);
		
		
		//文章管理
		adminParent= new Privilege("文章管理", "/article_list");
		child1= new Privilege("文章添加", "/article_add", adminParent);
		child2= new Privilege("文章删除", "/article_delete", adminParent);
		child3= new Privilege("文章修改", "/article_update", adminParent);
		child4= new Privilege("文章查询", "/article_list", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		
		//留言管理
		adminParent= new Privilege("留言管理", "/message_list");
		child1= new Privilege("留言添加", "/message_add", adminParent);
		child2= new Privilege("留言删除", "/message_delete", adminParent);
		child3= new Privilege("留言修改", "/message_update", adminParent);
		child4= new Privilege("留言查询", "/message_list", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		
		
		//评论管理
		adminParent= new Privilege("评论管理", "/remark_list");
		child1= new Privilege("评论添加", "/remark_add", adminParent);
		child2= new Privilege("评论删除", "/remark_delete", adminParent);
		child3= new Privilege("评论修改", "/remark_update", adminParent);
		child4= new Privilege("评论查询", "/remark_list", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		
		
		
		
		//广告管理
		adminParent= new Privilege("广告管理", "/advertisement_list");
		child1= new Privilege("广告添加", "/advertisement_add", adminParent);
		child2= new Privilege("广告删除", "/advertisement_delete", adminParent);
		child3= new Privilege("广告修改", "/advertisement_update", adminParent);
		child4= new Privilege("广告查询", "/advertisement_list", adminParent);
		child5= new Privilege("广告上移", "/advertisement_up", adminParent);
		child6= new Privilege("广告下移", "/advertisement_down", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		privileges.add(child5);
		privileges.add(child6);
		
		
		
		//角色管理
		adminParent= new Privilege("角色管理", "/role_list");
		child1= new Privilege("角色添加", "/role_add", adminParent);
		child2= new Privilege("角色删除", "/role_delete", adminParent);
		child3= new Privilege("角色修改", "/role_update", adminParent);
		child4= new Privilege("角色查询", "/role_list", adminParent);
		child5= new Privilege("角色上移", "/role_up", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		privileges.add(child5);
		
		
		//新闻管理
		adminParent= new Privilege("新闻管理", "/news_list");
		child1= new Privilege("新闻添加", "/news_add", adminParent);
		child2= new Privilege("新闻删除", "/news_delete", adminParent);
		child3= new Privilege("新闻修改", "/news_update", adminParent);
		child4= new Privilege("新闻查询", "/news_list", adminParent);
		child5= new Privilege("新闻下一条", "/news_next", adminParent);
		child6= new Privilege("新闻上一条", "/news_previous", adminParent);
		child7= new Privilege("新闻内容", "/news_show", adminParent);
		child8= new Privilege("新闻更多", "/news_more", adminParent);
		
		privileges.add(adminParent);
		privileges.add(child1);
		privileges.add(child2);
		privileges.add(child3);
		privileges.add(child4);
		privileges.add(child5);
		privileges.add(child6);
		privileges.add(child7);
		privileges.add(child8);
		
		
		
		
		//保存超级管理员
		admin.setPrivileges(privileges);
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin"));
		user.setRole(admin);
		
		normal.setPrivileges(normalPrivils);
		admin.setPrivileges(privileges);
		
		session.save(admin);
		session.save(normal);
		session.save(user);
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
		//System.out.println(ac);
	}

}
