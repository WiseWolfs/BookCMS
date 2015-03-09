package com.njit.lib.utils;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.njit.lib.domain.Privilege;
import com.njit.lib.service.PrivilegeService;
/**
 * 
 * @author Administrator
 *
 */
public class InitlListener implements ServletContextListener{


	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		PrivilegeService privilegeService =(PrivilegeService) ac.getBean("privilegeServiceImpl");
		Collection<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		//保存到Application中
		arg0.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		System.out.println("allPrivilegeUrls---------->数据已经准备完毕");
		
		
	}

}
