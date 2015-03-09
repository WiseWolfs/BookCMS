package com.njit.lib.view.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jws.WebParam.Mode;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.Message;
import com.njit.lib.domain.Remark;
import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.commons.beanutils.converters.LongConverter;
@Controller
@Scope("prototype")
public class RemarkAction extends BaseAction<Remark> {
	/**列表*/
	public String list() throws Exception {
		//准备数据
		//1，找到message对象
		Message message = messageService.getById(model.getId());
		//2，找到对象中的remark集合
		Set<Remark> remarks = message.getRemarks();
		List<Remark> messRemarkList= new ArrayList<Remark>(remarks);
		//3.保存到actionContext中
		ActionContext.getContext().put("messRemarkList", messRemarkList);
		ActionContext.getContext().getValueStack().push(message);
		//TODO 这里的list前面加了mess，因为这个action中还可以准备article的内容
	
		return "list";
	}
	
	/**添加*/
	public String add() throws Exception {
		//封装model的属性
		System.out.println(model.getId()+"message -----------");
		Message message = messageService.getById(model.getId());
		model.setMessage(message);
		model.setPublishTime(new Date());
		remarkService.add(model);
		return "toList";
	}
	/**添加页面*/
	public String addUI() throws Exception {
		return "saveUI";
	}
	/**删除*/
	public String delete() throws Exception {
		remarkService.delete(model.getId());
		return "toList";
	}
	/**修改*/
	public String update() throws Exception {
		//1，找到要修改的对象
		Remark remark = remarkService.getById(model.getId());
		//2，设置对象要修改的属性
		remark.setContent(model.getContent());
		//3，更新到数据库中区
		remarkService.update(model);
		return "toList";
	}
	/**修改页面*/
	public String updateUI() throws Exception {
		//准备回显数据
		Remark remark  = remarkService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(remark);
		return "saveUI";
	}



	

}
