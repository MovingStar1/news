package com.news.Servlet;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.Dao.INewsDaoImpl;
import com.news.Dao.IPageDaoImpl;
import com.news.Dao.NewsDao;
import com.news.Dao.PageDao;
import com.news.entity.News;
import com.news.entity.Page;
import com.news.service.INewsServiceImpl;
import com.news.service.NewsService;

public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewsDao ns=new INewsDaoImpl();
	PageDao pd=new IPageDaoImpl();
	Page pg=new Page();
	
    public NewsServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		if("xianshi".equals(action)){
		HttpSession session=request.getSession();
		String cPage=request.getParameter("currentPage");
		if(cPage==null){
			cPage="1";
		}
		int currentPage=Integer.parseInt(cPage);
		String cPageSize=request.getParameter("PageSize");
		if(cPageSize==null){
			cPageSize="8";
		}
		int PageSize=Integer.parseInt(cPageSize);
		NewsService ns=new INewsServiceImpl();
		Page pg=ns.NewsPageAll(currentPage, PageSize);
        List<News> list=pg.getList();
        session.setAttribute("pg", pg);
		session.setAttribute("list", list);
		response.sendRedirect("./newspages/main.jsp");
		}else if("addnews".equals(action)){
			Date currentTime = new Date();  
			String ntitle=request.getParameter("ntitle");
			String ncontent=request.getParameter("ncontent");
			String nauthor=request.getParameter("nauthor");
			Date date=currentTime;		
			String type=request.getParameter("ntid");
			News news=new News(ntitle,ncontent,nauthor,date,type);
			if(ns.addNews(news)){
				response.sendRedirect("./NewsServlet?action=xianshi");
			}
		}else if("updateNews".equals(action)){
			Date currentTime=new Date();
			String ntitle=request.getParameter("ntitle");
			String ncontent=request.getParameter("ncontent");
			String nauthor=request.getParameter("nauthor");
			Date date=currentTime;
			String type=request.getParameter("ntid");
			String cid=request.getParameter("id");
			int id=Integer.parseInt(cid);
			News news=new News(ntitle,ncontent, nauthor,date,type, id);
			if(ns.updateNews(news)){
				response.sendRedirect("./NewsServlet?action=xianshi");
			}
		}else if("show".equals(action)){
			HttpSession session=request.getSession();
			String cid=request.getParameter("id");
			int id=Integer.parseInt(cid);
			News news=ns.showNews(id);
			session.setAttribute("news", news);
			response.sendRedirect("./newspages/news_show.jsp");
		}else if("del".equals(action)){
			String cid=request.getParameter("id");
			int id=Integer.parseInt(cid);
			News news=new News(id);
			if(ns.delNews(news)){
				System.out.println("É¾³ý³É¹¦");
				response.sendRedirect("./NewsServlet?action=xianshi");
			}
		}

	}

}
