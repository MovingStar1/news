<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="./js/jquery-1.12.4.js"></script>
<script type="text/javascript">
 function reg() { 
   var name=$("#name").val();
   var pwd=$("pwd").val();
   if(name==""||pwd==""){
	   alert("用户名密码不能为空！");
   }
}
 $(document).ready(function(){
	 $("#name").blur(function(){
		 var username=$("#name").val();
		 $.ajax({
			  url:"UserServlet?action=finduser",
		      data:"username="+username,
		      type:"get",
		      dataType:"text",
		      success:function(data){
		    	  if("true"==data){
		    		  alert("用户已存在");
		    	  }else{
		    		  alert("用户可用");
		    	  }
		      },
		      error:function(){
		    	  alert("系统异常");
		      }
		  })
	 });
 });
 
  
</script>
<body>

     <form action="UserServlet?action=reg" method="post">
    <table border="0"  align="center">
      <tr> 
      <td>用户名</td>
            <td> <input type="text" name="username" id="name"></td>
      </tr>
      <tr>
      <td>密码</td>
      <td><input type="password" name="pwd" id="pwd"> </td>
      </tr>
       <tr><td><input type="submit" value="提交" onclick="reg();"/></td></tr>
    </table>
</form>
</body>
</html>