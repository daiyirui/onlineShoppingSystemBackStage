<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <title>江西理工大学 • 学生管理系统 |  header</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  



  
  <script type="text/javascript">

  function gettime(){
	  var time = new Date( ); //获得当前时间
	  var year = time.getFullYear( );//获得年、月、日
	  var month = time.getMonth( )+1;
	  var date = time.getDate( ); //获得日期
	  var day = time.getDay();		//获得星期
	  var hour = time.getHours( ); //获得小时、分钟、秒 
	  var minute = time.getMinutes( ); 
	  var second = time.getSeconds( ); 

	  
	  
	  if (minute < 10) //如果分钟只有1位，补0显示 
		  minute="0"+minute; 
		  if (second < 10) //如果秒数只有1位，补0显示 
		  second="0"+second; 
		  /*设置文本框的内容为当前时间*/ 
		  document.getElementById("t").innerHTML =year+"-"+month+"-"+date+"  "+hour+":"+minute+":"+second; 
	  
	  
  	/* var date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
  		document.getElementById("t").innerHTML =date; */
  		window.setTimeout("gettime()",1000);
  	}
  </script>
   <body onload="gettime();">
	<div class="header">
        <div class="logo" align="center"><img src="images/logo.png" alt="" title="" border="0" /></div>
        <div class="header_menu">
            <div class="header_left">管理员&nbsp; | <a href="./LoginService?action=update" target="mainFrame" >修改个人资料</a></div>
            <div class="header_center" id="t"> </div>
			<div class="header_right">
				<a href="welcome.html" target="mainFrame" class="home">首页</a> | 
				
				<a href="./LoginService?action=exit" target="_top" class="logout">退出</a>
			</div>
        </div>
    </div>
</body>
</html>
