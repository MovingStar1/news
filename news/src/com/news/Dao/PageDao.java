package com.news.Dao;

import java.util.List;

import com.news.entity.News;

public interface PageDao {
	//获取分页集合
	public List<News> getNewsByPage(int currentPage,int PageSize);
	//获取总数据条数
	public int getAllNewsCount();
	

}
