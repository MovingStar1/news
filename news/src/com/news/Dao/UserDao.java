package com.news.Dao;

import com.news.entity.User;

public interface UserDao {
	//ע��
	public boolean User_Reg(User u);
	//��½
	public boolean User_login(String username,String password);
	//��֤�û�
	public boolean User_exiter(String username);
	
}
