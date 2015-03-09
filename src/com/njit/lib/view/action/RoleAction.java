package com.njit.lib.view.action;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.Privilege;
import com.njit.lib.domain.Role;
import com.njit.lib.domain.SplitBean;
import com.njit.lib.domain.User;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	private Long privilegeIds[];
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	/**列表*/
	public String list() throws Exception {
		//准备分页显示数据
		
		//1.1准备分页显示角码
		List<Role> allList = roleService.findAll();
		SplitBean splitBean  = new SplitBean(currentPage, allList);
		ActionContext.getContext().getValueStack().push(splitBean);
		
		//1.2准备分页显示数据
		List<Role> roleList = roleService.findSinglePage(splitBean);
		ActionContext.getContext().put("roleList", roleList);
		
		return "list";
	}
	//设置权限
	public String setPrivilege() throws Exception{
		 return "toList";
	}
	//设置权限页面 
	public String setPrivilegeUI() throws Exception{
		//准备数据--->不在Action中准备，所有的权限应当是不变的，在项目启动的过程中，就应该完全初始化好
		//准备回显数据privilegeIds
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);//传递ID（role的标识符，因为要修改）
		int index=0;
		if(role.getPrivileges()!=null){
			privilegeIds = new Long[role.getPrivileges().size()];
			for(Privilege priv:role.getPrivileges()){
				privilegeIds[index++]=priv.getId();
			}
		}
		
		return "setPrivilegeUI";
	}
	/**添加*/
	public String add() throws Exception {
		roleService.add(model);
		return "toList";
	}
	/**添加页面*/
	public String addUI() throws Exception {
		return "saveUI";
	}
	/**删除*/
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}
	/**修改*/
	public String update() throws Exception {
		//1找到要修改的对象
		Role role = roleService.getById(model.getId());
		//2设置要修改的属性
		role.setDescription(model.getDescription());
		role.setName(model.getName());
		//3跟新到DB中
		roleService.update(role);
		return "toList";
	}
	/**修改页面*/
	public String updateUI() throws Exception {
		//准备回显数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}

}
