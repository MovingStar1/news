package com.news.Dao;

import com.news.entity.User;

public interface UserDao {
	//注册
	public boolean User_Reg(User u);
	//登陆
	public boolean User_login(String username,String password);
	//验证用户
	public boolean User_exiter(String username);
	
}
