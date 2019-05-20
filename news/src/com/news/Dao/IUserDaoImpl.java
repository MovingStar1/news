package com.news.Dao;

import java.sql.SQLException;

import com.news.entity.User;
import com.news.jdbc.sql_data;
public class IUserDaoImpl extends sql_data implements UserDao {
	
	public boolean User_Reg(User u) {
		boolean flag=false;
		conn=sql_data.getConnection();
		String sql="insert into user(username,pwd)value(?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPwd());
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
	public boolean User_login(String username,String password) {
		boolean flag=false;
		conn=sql_data.getConnection();
		String sql="select*from user where username=? and pwd=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,username);
			pst.setString(2,password);
			rs=pst.executeQuery();
			if(rs.next()){
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
	//验证用户
	public boolean User_exiter(String username) {
		boolean flag=false;
		conn=sql_data.getConnection();
		String sql="select * from user where username=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			rs=pst.executeQuery();
			if(rs.next()){
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

}
