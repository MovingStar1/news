package com.news.service;

import java.util.List;
import com.news.Dao.IPageDaoImpl;
import com.news.Dao.PageDao;
import com.news.entity.News;
import com.news.entity.Page;
import com.news.jdbc.sql_data;

public class INewsServiceImpl extends sql_data implements NewsService {
	//∑÷“≥ºØ∫œ
	public Page NewsPageAll(int currentPage, int pageSize) {
		Page page=new Page();
		PageDao pd=new IPageDaoImpl();
		int count=pd.getAllNewsCount();
		page.setTotalCount(count);
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		List<News> list=pd.getNewsByPage(currentPage, pageSize);
		page.setList(list);
		return page;
	}

}
