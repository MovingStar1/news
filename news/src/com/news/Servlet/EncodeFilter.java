package com.news.Servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{
    //1.5
	private String encode=null;
	//3
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//2
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(null==request.getCharacterEncoding()){
			request.setCharacterEncoding(encode);
		}
		chain.doFilter(request, response);
	}

	//1
	public void init(FilterConfig config) throws ServletException {
		String en = config.getInitParameter("encode");
		if(encode==null){
			encode=en;
		}
		
	}

}
