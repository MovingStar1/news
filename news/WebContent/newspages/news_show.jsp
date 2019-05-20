<%@ page language="java" import="java.util.*,java.sql.*,com.news.entity.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>新闻详细页</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
</script>

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
  <div id="status">管理员：${username}登录  &#160;&#160;&#160;&#160; <a href="../login.jsp">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
</script>


<table>

    <tr>       
         <td>标题:</td><td>${news.title}</td> 
         <td>内容:</td><td>${news.content}</td> 
         <td>作者:</td><td>${news.autor}</td> 
         <td>时间:</td><td>${news.date}</td> 
         <td>类别:</td><td>${news.type}</td>     	
    </tr>
</table>
<a href="main.jsp">返回</a>
  </div>
</div>



<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
