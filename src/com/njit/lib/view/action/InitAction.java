package com.njit.lib.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseActionNoModel;
import com.njit.lib.domain.Advertisement;
import com.njit.lib.domain.Channel;
import com.njit.lib.domain.Message;
import com.njit.lib.domain.News;
import com.opensymphony.xwork2.ActionContext;

/**
 * 初始化首页的数据信息
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class InitAction extends BaseActionNoModel{
	public String execute() throws Exception {
		//准备数据
		//1、新闻公告、业界动态,只需要显示最新的5条
		List<News> annoList = newsService.findLastFive(0);//type=0是新闻公告
		List<News> fraList = newsService.findLastFive(1);//type=1是业界动态
		ActionContext.getContext().put("annoList", annoList);
		ActionContext.getContext().put("fraList", fraList);
		
		
		//2、广告
		List<Advertisement> advertisementList = advertisementService.findTopFive();
		ActionContext.getContext().put("advertisementList", advertisementList);
		//3、免费专区、交换专区、爱心捐赠的简介
			//3.1购买专区type=0;
			List<Channel> buyChannel =channelService.findAll(0);
			//3.2交换专区type=1
			List<Channel> swapChannel = channelService.findAll(1);
			//3.3爱心捐赠type=2
			List<Channel> contriChannel = channelService.findAll(2);
			ActionContext.getContext().put("buyChannel", buyChannel);
			ActionContext.getContext().put("swapChannel", swapChannel);
			ActionContext.getContext().put("contriChannel", contriChannel);
			
		
		//4、留言板
		List<Message> messageList = messageService.findLastFive();
			//留言的内容长度大于15将，截取12个字符加上省略号
		for(Message m:messageList){
			if(m.getContent().length()>15){
				m.setContent(m.getContent().substring(0, 12)+"...");
			}
		}
		ActionContext.getContext().put("messageList", messageList);
		//5、爱心榜
		
		//TODO 6、免费、交换、捐赠专区的部分商品展示
		
		//跳转到首页
		return "success";
	}
	

}
