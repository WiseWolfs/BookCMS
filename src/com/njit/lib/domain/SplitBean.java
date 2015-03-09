package com.njit.lib.domain;

import java.util.List;

/**
 * 分页
 * @author Administrator
 *
 */
public class SplitBean {
	
	//从页面中获得
	private int currentPage = 1;//默认当前页是第一页
	private int countPage = 10;//默认每页显示10条记录
	//根据currentPage得到
	private int beginIndex;//开始页码
	private int endIndex;//结束页码
	//根据list计算得到
	private int pageSum;//总页数
	private int totalRows;//总记录数
	
	
	public SplitBean(int currentPage,List<?> list) {
		super();
		this.currentPage = currentPage;
		totalRows = list.size();
		pageSum=(totalRows+countPage-1)/countPage;
		
		if(pageSum<5){
			beginIndex = 1;
			endIndex = pageSum;
		}else if(currentPage<3){
			beginIndex = 1;
			endIndex = 5;
		}else if(pageSum-currentPage<3){
			beginIndex = pageSum-4;
			endIndex = pageSum;
		}else{
			beginIndex = currentPage-2;
			endIndex = currentPage + 2;
		}
		
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	private int pageNum;//跳转到指定页码
	
	
	
	
	
	
	
}
