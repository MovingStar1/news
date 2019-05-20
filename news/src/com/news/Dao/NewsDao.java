package com.news.Dao;

import java.util.List;

import com.news.entity.News;

public interface NewsDao {
	//获取所有新闻数据
	public List<News> getAllNews();
	//添加新闻
	public boolean addNews(News ns);
	//修改新闻
	public boolean updateNews(News ns);
	//显示新闻具体内容
	public News showNews(int id);
	//删除新闻	
	public boolean delNews(News ns);

}
