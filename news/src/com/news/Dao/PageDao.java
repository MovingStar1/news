package com.news.Dao;

import java.util.List;

import com.news.entity.News;

public interface PageDao {
	//��ȡ��ҳ����
	public List<News> getNewsByPage(int currentPage,int PageSize);
	//��ȡ����������
	public int getAllNewsCount();
	

}
