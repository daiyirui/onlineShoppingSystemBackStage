<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script 
  		language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js">
  </script>
    <base href="<%=basePath%>">
    
  </head>
  
  <body>
   <form action = "./OrderoServlet" name="findOrder" method = "post">
   <input name = "action" type="hidden" value="findOrder">
   	<div style="text-align:center">
 	 <input name = "d1" id="d1" type="text"/> 
     <img onclick="WdatePicker({el:$dp.$('d1')})" src="My97DatePicker/skin/datePicker.gif"  width="16" height="22" align="absmiddle">
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input name = "d2" id="d2" type="text"/> 
     <img onclick="WdatePicker({el:$dp.$('d2')})" src="My97DatePicker/skin/datePicker.gif"  width="16" height="22" align="absmiddle">
     <input name="submit1" type="submit" />
     </div>
   </form>
  </body>
</html>
