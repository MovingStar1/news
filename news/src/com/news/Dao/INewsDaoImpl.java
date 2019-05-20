package com.news.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.entity.News;
import com.news.jdbc.sql_data;

public class INewsDaoImpl extends sql_data implements NewsDao {
    //获取所有新闻
	public List<News> getAllNews() {
		List<News> list=new ArrayList<News>();
		News ns=null;
		conn=sql_data.getConnection();
		String sql="select*from news";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				ns=new News();
				ns.setId(rs.getInt(1));
				ns.setTitle(rs.getString(2));
				ns.setContent(rs.getString(3));
				ns.setAutor(rs.getString(4));
				ns.setType(rs.getString(5));
				ns.setDate(rs.getDate(6));
				list.add(ns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sql_data.close(rs, pst, conn);
		}
		return list;
	}
    //添加新闻
	public boolean addNews(News ns) {
		boolean flag=false;
		conn=sql_data.getConnection();
		String sql="insert into news(title,content,autor,type,date)value(?,?,?,?,now())";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, ns.getTitle());
			pst.setString(2, ns.getContent());
			pst.setString(3, ns.getAutor());
			pst.setString(4, ns.getType());
			int i=pst.executeUpdate();
			if(i>0){
				flag=true;
				System.out.println("添加成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sql_data.close(rs, pst, conn);
		}
		return flag;
	}
	//修改新闻
	public boolean updateNews(News ns) {
		boolean flag=false;
	    conn=sql_data.getConnection();
	    String sql="update news SET title=?,content=?,autor=?,type=? WHERE id=?";
	    try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, ns.getTitle());
			pst.setString(2, ns.getContent());
			pst.setString(3, ns.getAutor());
			pst.setString(4, ns.getType());
			pst.setInt(5, ns.getId());
			int i=pst.executeUpdate();
			if(i>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sql_data.close(rs, pst, conn);
		}
		return flag;
	}
	//删除新闻
	public boolean delNews(News ns) {
		boolean flag=false;
		conn=sql_data.getConnection();
		String sql="delete from news where id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,ns.getId());
			int i=pst.executeUpdate();
			if(i>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sql_data.close(rs, pst, conn);
		}
		return flag;
	}
	//显示新闻内容
	public News showNews(int id) {
		News news=null;
		conn=sql_data.getConnection();
		String sql="select*from news where id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			rs=pst.executeQuery();
			while(rs.next()){
				news=new News();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setContent(rs.getString(3));
				news.setAutor(rs.getString(4));
				news.setType(rs.getString(5));
				news.setDate(rs.getDate(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sql_data.close(rs, pst, conn);
		}
		return news;
		
	}

}
