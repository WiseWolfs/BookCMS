	package com.njit.lib.view.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.News;
import com.njit.lib.domain.SplitBean;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class NewsAction extends BaseAction<News>{
	//每请求一次Action，都会是实例化一次Action，将ViewCount的值保存到Map中，当项目终止的时候，viewCount的值写进DB中。
	private Map application =ActionContext.getContext().getApplication();
	//private Long count;

	public NewsAction(){
			//TODO 每请求一次，viewCount的值在原来的基础上+1 TMD还挺麻烦。。。
			/*count = (Long) application.get(model.getId());
			application.put(model.getId(),count.intValue()+1 );
			System.out.println("您当前一共浏览----"+count);*/
		
	}
	
	public String more() throws Exception{
		//准备分页角码信息
		List<News> allList  = newsService.findAll(model.getType());
		SplitBean splitBean = new SplitBean(currentPage, allList);
		ActionContext.getContext().getValueStack().push(splitBean);
		
		//准备分页数据
		List<News> newsList = newsService.findSinglePage(model.getType(), splitBean);
		ActionContext.getContext().put("newsList", newsList);
		return "more";
	}
	
	public String next() throws Exception{
		//SQL:选取id=11的数据的，下一条数据 
		//select * from news where id<11 order by publishTime desc limit 0,1
		News news = newsService.getNext(model.getId(),model.getType());
		ActionContext.getContext().getValueStack().push(news);
		return "toShow";
	}
	
	//上一篇
	public String previous() throws Exception{
	//SQL:选取id=11的数据的，上一条数据
	//select * from news where id>11  order by publishTime  limit 0,1;
		News news = newsService.getPrevious(model.getId(),model.getType());
		ActionContext.getContext().getValueStack().push(news);
		return "toShow";
	}
	
	
	//显示新闻、业界动态的详细内容
	public String show() throws Exception{
		News news = newsService.getById(model.getId());
		//每次浏览都会+1
		news.setViewCount(news.getViewCount()+1);
		newsService.update(news);
		ActionContext.getContext().getValueStack().push(news);
		return "show";
	}
	
	/**列表*/
	public String list() throws Exception {
		//准备分页角码信息
		List<News> allList  = newsService.findAll(model.getType());
		SplitBean splitBean = new SplitBean(currentPage, allList);
		ActionContext.getContext().getValueStack().push(splitBean);
		
		//准备分页数据
		List<News> newsList = newsService.findSinglePage(model.getType(), splitBean);
		ActionContext.getContext().put("newsList", newsList);
		return "list";
	}
	
	/**添加*/
	public String add() throws Exception {
		//封装model
		model.setPublishTime(new Date());
		model.setViewCount(0);//新添加的新闻，阅览数都是0
		//保存到数据库
		newsService.add(model);
		//TODO 没添加到数据中一个新闻，都在Map中为该新闻的阅览数赋一个初始值
		application.put(model.getId(), 0);
		return "toList";
	}
	/**添加页面*/
	public String addUI() throws Exception {
		return "saveUI";
	}
	/**删除*/
	public String delete() throws Exception {
		newsService.delete(model.getId());
		return "toList";
	}
	/**修改*/
	public String update() throws Exception {
		//找到要修改的对象
		News news = newsService.getById(model.getId());
		//设置要修改的属性
		news.setContent(model.getContent());
		news.setPublishTime(new Date());
		news.setTitle(model.getTitle());
		//更新到数据库中
		newsService.update(news);
		
		return "toList";
	}
	/**修改页面*/
	public String updateUI() throws Exception {
		//准备回显数据
		News news = newsService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(news);
		return "saveUI";
	}


}
