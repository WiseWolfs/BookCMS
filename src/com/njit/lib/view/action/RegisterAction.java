package com.njit.lib.view.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.User;
import com.njit.lib.utils.CloseUtils;
@Controller
@Scope("prototype")
public class RegisterAction extends BaseAction<User> {
	
	private File file;
	private String fileName;
	private String contentType;
	
	/**
	 * 注册页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		return "addUI";
	}
	/**
	 * 注册成功
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		String imageName="";
		//如果没有上传图像，则给一个默认的图像
		if(fileName==null){
			String picUrl  =ServletActionContext.getServletContext().getRealPath("/uploadImage")+"/default.png";
			model.setPicUrl(picUrl);
		}else{
			//封装属性
			int pos = fileName.lastIndexOf(".");
			imageName =new Date().getTime()+fileName.substring(pos);
			String picUrl =ServletActionContext.getServletContext().getRealPath("/uploadImage")+"/"+imageName;
			File imageFile = new File(picUrl);
			System.out.println(file.getName()+imageFile.getName());
			copy(file,imageFile);
			model.setPicUrl(picUrl);
			model.setImageName(imageName);
			
		}
		
		//保存到数据库
		userService.add(model);
		return "success";
	}
	private static void copy(File src,File dest){
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			byte[] car = new byte[1024];
			int len =0;
			while(-1!=(len=is.read(car))){
				os.write(car,0,len);
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
	
	public User getModel() {
		return model;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	/**
	 * 这两个set是隐式的参数获取，xx+FileName,XX+contentType
	 * @param contextType
	 */
	public void setFileContentType(String contextType){
		this.contentType = contextType;
	}
	
	public void setFileFileName(String fileName){
		this.fileName  = fileName;
	}
	public void setModel(User model) {
		this.model = model;
	}
	

}
