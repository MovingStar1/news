<%@ page language="java" import="java.util.*,java.sql.*,com.news.entity.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<% 
    Page pg=(Page)session.getAttribute("pg");
if(pg==null){
	out.print("<script>alert('您还没有登录，请登录...'); window.location='../login.jsp'</script>");
}
%>
<head>
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：${username}登录  &#160;&#160;&#160;&#160; <a href="../login.jsp">login out</a>    |    <a href="../newspages/news_add.jsp">添加新闻</a></div>

  <div id="channel"> </div>  <div></div>
</div>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
</script>
    <ul class="classlist">
      		<c:forEach var ="i" items="${list}">
      	<li><a href="../NewsServlet?action=show&id=${i.id}">${i.title}</a><span><a href="../NewsServlet?action=del&id=${i.id}">删除新闻</a>              
      	<a href="../newspages/news_update.jsp?&id=${i.id}">修改新闻</a> 作者:${i.autor} 时间:${i.date} 类别:${i.type}</span></li>
      	</c:forEach>
    </ul> 

<!-- 分页部分 -->
<c:choose>
<c:when test="${pg==null}">
<%out.print("<script>alert('您还没有登录，请登录...'); window.location='../login.jsp'</script>"); %>
</c:when>
<c:when test="${pg.getTotalPage()%2==0}"> 
<c:choose>
<c:when test="${pg.getCurrentPage()==1}">
         <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()+1%>">下一页</a>
         <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getTotalPage()-1%>">尾页</a>
         <span style="color:blue">[${pg.getCurrentPage()}/${pg.getTotalPage()-1}]</span>
</c:when>
<c:when test="${pg.getCurrentPage()==pg.getTotalPage()-1}">
         <a href="../NewsServlet?action=xianshi&currentPage=1">首页</a>
         <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()-1%>">上一页</a>
         <span style="color:blue">[${pg.getCurrentPage()}/${pg.getTotalPage()-1}]</span>
</c:when>
<c:otherwise>
 <a href="../NewsServlet?action=xianshi&currentPage=1">首页</a>
 <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()-1%>">上一页</a>
 <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()+1%>">下一页</a>
 <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getTotalPage()-1%>">尾页</a>
 <span style="color:blue">[${pg.getCurrentPage()}/${pg.getTotalPage()-1}]</span>
</c:otherwise>
</c:choose>
</c:when>
</c:choose>








<c:choose>
<c:when test="${pg==null }">
<%out.print("<script>alert('您还没有登录，请登录...'); window.location='../login.jsp'</script>"); %>
</c:when>
<c:when test="${pg.getTotalPage()%2!=0}">
<c:choose>
<c:when test="${pg.getCurrentPage()==1}">
         <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()+1%>">下一页</a>
         <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getTotalPage()-1%>">尾页</a>
         <span style="color:blue">[${pg.getCurrentPage()}/${pg.getTotalPage()-1}]</span>
</c:when>
<c:when test="${pg.getCurrentPage()==pg.getTotalPage()-1}">
         <a href="../NewsServlet?action=xianshi&currentPage=1">首页</a>
         <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()-1%>">上一页</a>
         <span style="color:blue">[${pg.getCurrentPage()}/${pg.getTotalPage()-1}]</span>
</c:when>
<c:otherwise>
 <a href="../NewsServlet?action=xianshi&currentPage=1">首页</a>
 <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()-1%>">上一页</a>
 <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getCurrentPage()+1%>">下一页</a>
 <a href="../NewsServlet?action=xianshi&currentPage=<%=pg.getTotalPage()-1%>">尾页</a>
  <span style="color:blue">[${pg.getCurrentPage()}/${pg.getTotalPage()-1}]</span>
</c:otherwise>
</c:choose>
</c:when>
</c:choose>





  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
