package com.njit.lib.view.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.Channel;
import com.njit.lib.utils.CloseUtils;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class ChannelAction extends BaseAction<Channel>{
	private File file;
	private String fileName;
	private String contentType;
	
	private String imageName;
	private static void copy(File src,File dest){
		InputStream is  = null;
		OutputStream os = null;
		try {
			is =new BufferedInputStream(new FileInputStream(src));
			os = new BufferedOutputStream(new FileOutputStream(dest));
			byte car[]=new byte[1024];
			int len =0;
			while(-1!=(len=is.read(car))){
				os.write(car, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			CloseUtils.closeAll(is,os);
		}
		
	}
	//添加页面
	public String addUI() throws Exception{
		
		return "saveUI";
	}
	//添加
	public String add() throws Exception{
		String picUrl="";
		if(fileName!=null){
			int pos = fileName.lastIndexOf(".");
			imageName=UUID.randomUUID()+fileName.substring(pos);
			picUrl=ServletActionContext.getServletContext().getRealPath("/uploadImage")+"/"+imageName;
			copy(file,new File(picUrl));
		}
		//封装model
		model.setPicUrl(picUrl);
		model.setImageName(imageName);
		channelService.add(model);
		return "toList";
	}
	//修改页面
	public String updateUI() throws Exception{
		//准备回显数据
		Channel channel = channelService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(channel);
		return "saveUI";
	}
	//修改
	public String update() throws Exception{
		//找到要修改的对象
		Channel channel = channelService.getById(model.getId());
		//设置要修改的属性
		String picUrl="";
		if(fileName!=null){
			int pos = fileName.lastIndexOf(".");
			imageName=UUID.randomUUID()+fileName.substring(pos);
			picUrl=ServletActionContext.getServletContext().getRealPath("/uploadImage")+"/"+imageName;
			copy(file,new File(picUrl));
		}
		channel.setPicUrl(picUrl);
		channel.setProfile(model.getProfile());
		channel.setType(model.getType());
		channel.setImageName(imageName);
		//更新到数据库中
		channelService.update(channel);
		return "toList";
	}
	//删除
	public String delete() throws Exception{
		channelService.delete(model.getId());
		return "toList";
	}
	//列表
	public String list() throws Exception{
		//准备
		List<Channel> channelList= channelService.findAll(model.getType());
		ActionContext.getContext().put("channelList", channelList);
		return "list";
	}
	public void setFileContentType(String contentType){
		this.contentType = contentType;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public void setFileFileName(String fileName){
		this.fileName = fileName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
