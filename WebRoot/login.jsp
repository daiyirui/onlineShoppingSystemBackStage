<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
  
    String msg=" ";
    String tag=request.getParameter("tag");
    if("1".equals(tag)){
    msg="用户名或者密码错误，请重新输入！！！！";
    }
 
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>江西理工大学 • 学生管理系统 | Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="css/login.css" rel="stylesheet" type="text/css" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
	   function checkLogin(){
	     if(document.getElementById("userName").value==""){alert("用户名不能为空");return false;}
	      if(document.getElementById("userPwd").value==""){alert("密码不能为空");return false;}
	       return true;
	   }
	</script>
	
  </head>
  
  <body>
	<div id="login_container">
		<div id="innerlogin" style="margin-top:50px; margin-left:225px; width: 197px">
		<span><font color="red"><%=msg %></font></span>
            <form action="./LoginService"  method="post" onsubmit="return checkLogin()">
               <input type="hidden" name="action" value="login"> 
                <input name="userName" id="userName" type="text" class="logininput" value="" style="width: 160px; height: 35px"/>
                <input name="userPwd" id="userPwd" type="password" class="logininput" value="" style="width: 160px; height: 35px"/>
                <input name="submit" type="submit" class="loginbtn" style="width: 100px; height: 30px"/>
            </form>
		</div>
    </div>
    <div class="login_footer"><p>Copyright © 2016.7 江西理工大学 * 中软实习项目组 All Rights Reserved </p></div>
  </body>
</html>
