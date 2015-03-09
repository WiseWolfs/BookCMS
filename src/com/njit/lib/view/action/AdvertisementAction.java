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
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.Advertisement;
import com.njit.lib.domain.SplitBean;
import com.njit.lib.utils.CloseUtils;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AdvertisementAction extends BaseAction<Advertisement>{
	
	private File file;
	private String fileName;
	private String contentType;
	private String imageName;
	
	/**
	 * 上移
	 * @return
	 * @throws Exception
	 */
	public String up() throws Exception{
		//TODO 如果在后面的页面，移动后要to到相应的页面，所以要传一个currentPage参数过去
		//上移
			//1.1找到要移动的数据的上一条记录
		Advertisement upAdvertisement = advertisementService.getUp(model.getId());
		Advertisement advertisement =advertisementService.getById(model.getId());
			//1.2交换两条数据的position的值
		int position =upAdvertisement.getPosition();
		upAdvertisement.setPosition(advertisement.getPosition());
		advertisement.setPosition(position);
			//1.3更新到数据库中区
		advertisementService.update(upAdvertisement);
		advertisementService.update(advertisement);
		return "toList";
	}
	/**
	 * 下移
	 * @return
	 * @throws Exception
	 */
	public String down() throws Exception{
		//下移
			//1.1找到要移动的数据的下一条记录
		Advertisement downAdvertisement = advertisementService.getDown(model.getId());
		Advertisement advertisement =advertisementService.getById(model.getId());
			//1.2交换两条数据的position的值
		int position =downAdvertisement.getPosition();
		downAdvertisement.setPosition(advertisement.getPosition());
		advertisement.setPosition(position);
			//1.3更新到数据库中区
		advertisementService.update(downAdvertisement);
		advertisementService.update(advertisement);
		return "toList";
	}
	
	/**
	 * 将图片复制到指定的位置
	 * @param src
	 * @param dest
	 */
	private static void copy(File src,File dest){
		InputStream is = null;
		OutputStream os = null;
		try {
			is=new BufferedInputStream(new FileInputStream(src));
			os = new BufferedOutputStream(new FileOutputStream(dest));
			byte car[]= new byte[1024];
			int len = 0;
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
	/**增加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		String picUrl="";
		if(fileName!=null){
			int pos = fileName.lastIndexOf(".");
			imageName =UUID.randomUUID()+fileName.substring(pos);
			picUrl=ServletActionContext.getServletContext().getRealPath("/uploadImage"+"/"+imageName);
			File dest = new File(picUrl);
			copy(file,dest);
		}
		
		//封装model
		model.setPicUrl(picUrl);
		model.setPublishTime(new Date());
		model.setImageName(imageName);
		//保存到数据库中
		advertisementService.add(model);
		
		return "toList";
	}
	/**增加页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		return "saveUI";
	}
	/**删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		advertisementService.delete(model.getId());
		return "toList";
	}
	/**修改页面
	 * @return
	 * @throws Exception
	 */
	public String updateUI() throws Exception {
		//准备回显数据
		Advertisement advertisement = advertisementService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(advertisement);
		return "saveUI";
	}
	/**修改
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		//获取要修改的对象
		Advertisement advertisement = advertisementService.getById(model.getId());
		//设置要修改的属性
		String picUrl = "";
		if(fileName!=null){
			int pos = fileName.lastIndexOf(".");
			imageName =UUID.randomUUID()+fileName.substring(pos);
			picUrl=ServletActionContext.getServletContext().getRealPath("/uploadImage"+"/"+imageName);
			File dest = new File(picUrl);
			copy(file,dest);
		}
		
		advertisement.setUrl(model.getUrl());
		advertisement.setPicUrl(picUrl);
		advertisement.setImageName(imageName);
		
		//更新到数据库中
		advertisementService.update(advertisement);
		return "toList";
	}
	/**查询
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		/*//准备数据
		List<Advertisement> advertisementList =advertisementService.findAll();
		ActionContext.getContext().put("advertisementList", advertisementList);*/
		
		//准备分页数据
		List<Advertisement> allList = advertisementService.findAll();
		SplitBean splitBean = new SplitBean(currentPage, allList);
		List<Advertisement> advertisementList= advertisementService.findSinglePage(splitBean);
		ActionContext.getContext().getValueStack().push(splitBean);//准备分页的角码信息
		ActionContext.getContext().put("advertisementList", advertisementList);//准备分页的数据信息
		return "list";
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
	
	public void setFileFileName(String fileName){
		this.fileName= fileName;
	}
	public void setFileContentType(String contentType){
		this.contentType = contentType;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
