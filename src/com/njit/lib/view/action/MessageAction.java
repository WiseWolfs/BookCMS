package com.njit.lib.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.Message;
import com.njit.lib.domain.SplitBean;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class MessageAction extends BaseAction<Message>{
	//增加
	public String add() throws Exception {
		messageService.add(model);
		return "toList";
	}
	//添加页面
	public String addUI() throws Exception {
		return "saveUI";
	}
	//删除
	public String delete() throws Exception {
		messageService.delete(model.getId());
		return "toList";
	}
	//修改页面
	public String updateUI() throws Exception {
		//准备回显数据
		Message message = messageService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(message);
		return "saveUI";
	}
	//
	public String update() throws Exception {
		//找到要修改的对象
		Message message = messageService.getById(model.getId());
		//设置要修改的属性
		message.setContent(model.getContent());
		//更新到数据库中
		messageService.update(message);
		return "toList";
	}
	//
	public String list() throws Exception {
	/*	//准备数据
		List<Message> messageList= messageService.findAll();
		ActionContext.getContext().put("messageList", messageList);*/
		//准备分页页码信息
		List<Message> allList = messageService.findAll();
		SplitBean splitBean = new SplitBean(currentPage, allList);
		ActionContext.getContext().getValueStack().push(splitBean);
		//准备分页显示数据
		List<Message> messageList = messageService.findAll();
		ActionContext.getContext().put("messageList", messageList);
		return "list";
	}
	public String more() throws Exception{
		//准备分页角码信息
		List<Message> allList=  messageService.findAll();
		SplitBean splitBean = new SplitBean(currentPage, allList);
		ActionContext.getContext().getValueStack().push(splitBean);
		
		//准备分页数据信息
		List<Message> messageList = messageService.findSinglePage(splitBean);
		ActionContext.getContext().put("messageList", messageList);
		return "more";
	}

}
