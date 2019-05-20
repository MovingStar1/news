 package com.news.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.Dao.IUserDaoImpl;
import com.news.Dao.UserDao;
import com.news.entity.User;
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao ud=new IUserDaoImpl();
    
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
//		response.setContentType("utf-8");
		if("login".equals(action)){
			String username=request.getParameter("username");
			session.setAttribute("username",username);
			String pwd=request.getParameter("pwd");
			if(ud.User_exiter(username)){
			   if( ud.User_login(username,pwd)){
				   response.sendRedirect("./NewsServlet?action=xianshi");
			   }else{
				   response.sendRedirect("./login.jsp");
			   }
			}else{
				response.sendRedirect("./login.jsp");
			}
			
		}else if("reg".equals(action)){
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			if(ud.User_exiter(username)){
				response.sendRedirect("./reg.jsp");
			}else{
				User u=new User(username,pwd);
			    if(ud.User_Reg(u)){
			    	response.sendRedirect("./login.jsp");
			    }
			}
				
			}else if("finduser".equals(action)){
			PrintWriter out=response.getWriter();
			String username=request.getParameter("username");
			if(ud.User_exiter(username)){
				out.print("true");
				out.flush();
				out.close();
			}
		}
		
		
	}

}
