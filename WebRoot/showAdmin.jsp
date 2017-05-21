<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jxust.entity.User"%>
<%@page import="com.jxust.dao.Impl.UserManagerImpl"%>
<%@page import="com.jxust.dao.UserManager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	User user=(User)request.getAttribute("user");
%>

<html>
  <head>    
    <title>江理大队 • 学员管理系统 | 展示全部学员界面</title>	
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jconfirmaction.jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.ask').jConfirmAction();
		});
	</script>
	<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<!-- 会员样式-->
	<style>
	#popupcontent{   position: absolute;   visibility: hidden;   overflow: hidden;   border:1px solid #CCC;   background-color:#F9F9F9;   border:1px solid #333;   padding:5px;}
	</style>
	
	<script>
	var baseText = null; function showPopup(w,h){   var popUp = document.getElementById("popupcontent");    popUp.style.top = "350px";   popUp.style.left = "250px";   popUp.style.width = w + "px";   popUp.style.height = h + "px";    if (baseText == null) baseText = popUp.innerHTML;   popUp.innerHTML = baseText +       "<div id=\"statusbar\"></div>";    var sbar = document.getElementById("statusbar");   sbar.style.marginTop = (parseInt(h)-60) + "px";   popUp.style.visibility = "visible";}
	function hidePopup(){   var popUp = document.getElementById("popupcontent");   popUp.style.visibility = "hidden";}
	</script>

<!-- 取单样式-->
<style>
#popupcontent1{   position: absolute;   visibility: hidden;   overflow: hidden;   border:1px solid #CCC;   background-color:#F9F9F9;   border:1px solid #333;   padding:5px;}
</style>
<script>
var baseText1 = null; function showPopup1(w,h){   var popUp1 = document.getElementById("popupcontent1");    popUp1.style.top = "350px";   popUp1.style.left = "250px";   popUp1.style.width = w + "px";   popUp1.style.height = h + "px";    if (baseText1 == null) baseText1 = popUp1.innerHTML;   popUp1.innerHTML = baseText1 +       "<div id=\"statusbar1\"></div>";    var sbar1 = document.getElementById("statusbar1");   sbar1.style.marginTop = (parseInt(h)-60) + "px";   popUp1.style.visibility = "visible";}
function hidePopup1(){   var popUp1 = document.getElementById("popupcontent1");   popUp1.style.visibility = "hidden";}
</script>
<META content="MSHTML 6.00.2900.2838" name=GENERATOR>
	
	
</head>
	<body>
		<div class="right_content" style="overflow:hidden;">
			<table id="rounded-corner">
				<thead>
					<tr>
						<th scope="col" class="rounded">管理员id</th>
						<th scope="col" class="rounded">管理员姓名</th>
						<th scope="col" class="rounded">管理员年龄</th>
						<th scope="col" class="rounded">管理员联系</th>
						<th scope="col" class="rounded-q4">管理员说明</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=user.getUserid()%></td>
						<td><%=user.getUsername() %></td>
						<td><%=user.getAge() %></td>
						<td><%=user.getEmail() %></td>
						<td><%=user.getRemark() %></td>
					</tr>		
				</tbody>
			</table>
		</div>
		<div class="clear"></div>
	</body>
</html>
