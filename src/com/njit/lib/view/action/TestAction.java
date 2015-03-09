package com.njit.lib.view.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport{
	
	private Map application;
	private Map request; 
	private Map session;
	
	
	public TestAction(){
		application = ActionContext.getContext().getApplication();
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		System.out.println("application--------------------"+application);
		System.out.println("request----------------"+request);
		System.out.println("session----------------"+session);
		
	}
	@Override
	public String execute() throws Exception {
		ServletActionContext.getRequest().getSession().setAttribute("userName","test js get Params" );
		return "success";
	}

}
