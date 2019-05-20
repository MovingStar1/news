package com.news.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.entity.News;
import com.news.jdbc.sql_data;

public class IPageDaoImpl extends sql_data implements PageDao {

	public List<News> getNewsByPage(int currentPage, int PageSize) {
		News ns=null;
		List<News> list=new ArrayList<News>();
		conn=sql_data.getConnection();
		String sql="select*from news limit ?,?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (currentPage*PageSize)-1);
			pst.setInt(2, PageSize);
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
	public int getAllNewsCount() {
		conn=sql_data.getConnection();
		int count=-1;
		String sql="select count(1) from news";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
				//System.out.println("×ÜÊý£º"+count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sql_data.close(rs, pst, conn);
		}
		return count;
	}
}
