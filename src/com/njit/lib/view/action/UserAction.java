package com.njit.lib.view.action;

import java.util.List;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.Role;
import com.njit.lib.domain.SplitBean;
import com.njit.lib.domain.User;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	private Long roleId;
	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	//用户资料
	public String show() throws Exception{
		User user  = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		return "show";
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		model.setRole(roleService.getById(roleId));
		userService.add(model);
		return "toList";
	}
	/**
	 * 登陆界面	
	 * @return
	 * @throws Exception
	 */
	public String loginUI() throws Exception{
		return "loginUI";
	}
	/**
	 * 登陆成功,记得要把user保存在session中
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		User user = userService.findUserByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		if(user==null){
			this.addFieldError("error", "用户名或者密码错误！请重新输入");
			return "loginUI";
		}else{
			ActionContext.getContext().getSession().put("user", user);
			String roleName =user.getRole().getName();
			if(roleName.indexOf("管理员")!=-1){
				return "toIndex";//转到admin目录下的首页
			}else{
				return "MyLibrary";//转到我的图书馆
			}
			
		}
		
	}
	//我的图书馆
	public String MyLibrary() throws Exception{
		return "MyLibrary";
		
	}
	//管理员后台页面
	public String index() throws Exception{
		return "index";
	}
	
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		//从session中移除user属性
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	/**
	 * 初始化密码
	 * @return
	 * @throws Exception
	 */
	public String initPass() throws Exception{
		//获取要修改的对象
		User user = userService.getById(model.getId());
		userService.initPass(user);
		return "toList";
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		//准备数据---》角色列表
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		
		return "addUI";
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		//1、找到要修改的对象
		User user= userService.getById(model.getId());
		//2、设置要修改的属性
		user.setPassword(DigestUtils.md5Hex(model.getPassword()));
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		
		//3、更新到数据库
		userService.update(user);
		return "toList";
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String updateUI() throws Exception {
		//准备回显数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		//准备数据---角色数据
		List<Role> roleList  = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "updateUI";
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		/*//准备数据
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);*/
		
		//准备分页角码信息
		List<User> allList = userService.findAll();
		SplitBean splitBean = new SplitBean(currentPage, allList);
		ActionContext.getContext().getValueStack().push(splitBean);
		//准备分页列表数据
		List<User> userList = userService.findSinglePage(splitBean);
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	
	public User getModel() {
		return model;
	}
	
	

}
