package com.njit.lib.view.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.njit.lib.base.BaseAction;
import com.njit.lib.domain.Article;
import com.njit.lib.domain.SplitBean;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class ArticleAction extends BaseAction<Article>{
	
	/**列表*/
	public String list() throws Exception {
		//准备分页页码信息
		List<Article> allList  = articleService.findAll();
		SplitBean splitBean  = new SplitBean(currentPage,allList);
		ActionContext.getContext().getValueStack().push(splitBean);
		//准备分页数据
		List<Article> articleList = articleService.findSinglePage(splitBean);
		ActionContext.getContext().put("articleList", articleList);
		return "list";
	}
	
	/**添加*/
	public String add() throws Exception {
		articleService.add(model);
		return "toList";
	}
	/**添加页面*/
	public String addUI() throws Exception {
		return "saveUI";
	}
	/**删除*/
	public String delete() throws Exception {
		articleService.delete(model.getId());
		return "toList";
	}
	/**修改*/
	public String update() throws Exception {
		//1,找到要修改的对象
		Article article = articleService.getById(model.getId());
		//2，设置要修改的属性
		article.setContent(model.getContent());
		article.setTitle(model.getTitle());
		article.setPublishTime(new Date());
		//3，更新到数据库中
		articleService.update(article);
		return "toList";
	}
	/**修改页面*/
	public String updateUI() throws Exception {
		//准备回显数据
		Article article = articleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(article);
		return "saveUI";
	}


}
