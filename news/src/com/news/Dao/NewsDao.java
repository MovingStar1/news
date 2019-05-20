package com.news.Dao;

import java.util.List;

import com.news.entity.News;

public interface NewsDao {
	//��ȡ������������
	public List<News> getAllNews();
	//�������
	public boolean addNews(News ns);
	//�޸�����
	public boolean updateNews(News ns);
	//��ʾ���ž�������
	public News showNews(int id);
	//ɾ������	
	public boolean delNews(News ns);

}
