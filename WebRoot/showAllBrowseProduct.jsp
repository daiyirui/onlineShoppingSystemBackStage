<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jxust.entity.BrowseProduct"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<BrowseProduct> browseProducts=(List<BrowseProduct>)request.getAttribute("bpts");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	
	<script type="text/javascript">
		function doDelete(id){
			if(confirm("是否删除此会员信息?")){
				document.location.href="./BrowseProductService?id="+id+"&action=delete";
			}
		}
		function doModify(id){
			location.href="./BrowseProductService?id="+id+"&action=update";
		}
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
						<th scope="col" class="rounded">浏览产品id</th>
						<th scope="col" class="rounded">浏览产品名</th>
						<th scope="col" class="rounded">产品id</th>
						<th scope="col" class="rounded">类别id</th>
						<th scope="col" class="rounded">人气度</th>
						<th scope="col" class="rounded-q4">热销度</th>
						<th scope="col" class="rounded-q4">关键字</th>
						<th scope="col" class="rounded-q4">图片</th>
						<th scope="col" class="rounded-q4">说明</th>
						<th scope="col" class="rounded-q4">操作</th>
					</tr>
				</thead>
				<tbody>
				<%
					for(int i=0;i<browseProducts.size();i++){
				%>
					<tr>
						<td><%=browseProducts.get(i).getBrowseproductid()%></td>
						<td><%=browseProducts.get(i).getBrowseproductname()%></td>
						<td><%=browseProducts.get(i).getProductid() %></td>
						<td><%=browseProducts.get(i).getClassid() %></td>
						<td><%=browseProducts.get(i).getPopularity() %></td>
						<td><%=browseProducts.get(i).getHotsale() %></td>
						<td width="250px"><%=browseProducts.get(i).getKeywords() %></td>
						<td><%=browseProducts.get(i).getPicture() %></td>
						<td><%=browseProducts.get(i).getRemark() %></td>
						<td>
							<a href="javascript:doModify(<%=browseProducts.get(i).getBrowseproductid() %>);"><img src = "./images/update.png"></a> 
							<a href="javascript:doDelete(<%=browseProducts.get(i).getBrowseproductid() %>);"><img src = "./images/delete.png"></a>
			 			</td>
					</tr>
				<%
					}
				%>
					
					
				</tbody>
			</table>
		</div>
		<div class="clear"></div>
	</body>
</html>
