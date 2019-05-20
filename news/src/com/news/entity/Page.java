package com.news.entity;

import java.util.List;

public class Page {
     private int currentPage;//当前页
     private int totalPage;//总页数
     private int PageSize;//每页显示的数量
     private int totalCount;//总数据
 	 private List<News> list;//当前页的数据集合
     public Page() {
		// TODO Auto-generated constructor stub
	}
     public Page(int currentPage, int totalPage, int pageSize,
    		 int totalCount, List<News> list) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.PageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", PageSize=" + PageSize + ", totalCount=" + totalCount
				+ ", list=" + list + "]";
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return PageSize;
	}
	/*
	 * 总页数=数据总数*页面大小==0?数据总数/页面大小：数据总数/页面大小+1;
	 * 当我们调用了数据总数的set（）和get（）以后，自动算出总页数
	 */
	public void setPageSize(int pageSize) {
		this.PageSize = pageSize;
		//自动计算总页数
		// 总页数=数据总数%页面大小==0?数据总数/页面大小：数据总数/页面大小+1;
		this.totalPage=this.totalCount%this.PageSize==0?this.totalCount/this.PageSize:this.totalCount/this.PageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}

}
