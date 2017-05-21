<%@page import="com.jxust.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	
	User user=(User)request.getAttribute("user");
%>

<html>
	<head>
		<title>江理大队 • 学员管理系统 | 添加学员</title>

		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="./js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<script type="text/javascript">
	function dorefer(){
				if( validate_form())
				UserFrm.submit();
			}
					
			//验证email
	function isEmail(str){
       var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
       if(!reg.test(str)){
            document.getElementById("emailErr").innerHTML = "<font color='red'>邮箱格式不正确！</font>";
			form.sex.focus();
            return false;

        }
        document.getElementById("emailErr").innerHTML = "";
        return true;
}

			function validate_form() {
				if(!isEmail(str)) return false;
				return true;
			}
	</script>
	
	<body>
		<form name="doUpdateFrm" action="./UserService" class="userAdd"  method="post">
			<input type="hidden" name="action" value="doUpdate" />
			<input type="hidden" name="userid" value="<%=user.getUserid()%>">
			<div class="right_content" align="center">
				<h2>修改会员信息</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">会员姓名</span>
							</td>
							<td>
								<input name="username" id="" readonly="readonly" class="info-textfield" type="text" value="<%=user.getUsername() %>" />
							</td>
						</tr>
						<tr>
							<td>
								<span class="">会员密码</span>
							</td>
							<td>
								<input name="password" id="" class="info-textfield" type="password" value="<%=user.getUserpassword() %>" />
							</td>
						</tr>
						<tr>
							<td>
								<span class="">会员年龄</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="age" value="<%=user.getAge() %>" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">会员email</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="email" id="email" class="email" value="<%=user.getEmail() %>" onblur="isEmail(this.value)" />
								<div id = "emailErr"></div>
							</td>
						</tr>
						<tr>
							<td>
								<span class="">会员类型</span>
							</td>
							<td>
								<input type="text" readonly="readonly" class="info-textfield" name="type" value="<%=user.getType() %>" />
							</td>
						</tr>
						<tr>
							<td>
								<span class="">会员简介</span>
							</td>
							<td>
								<input name="remark" id="" class="info-textfield" type="text" value="<%=user.getRemark() %>" />
							</td>
						</tr>
						
					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td colspan="2" class="">
								<script type="text/javascript">
								function reset() {
									$(".userAdd")[0].reset();
								}
								function submit() {
									$(".userAdd").submit();
								}
								</script>
								<div class="btns-pagenav">
									<div class="div-btns" style="float: left;">
										 <a href="javascript:void(0)" class="bt_green" onclick="dorefer();">修改 会员</a>
										 <a href="javascript:void(0)" class="bt_green" onclick="javascript:history.go(-1);">返回</a>
									</div>
								</div>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>
		<div class="clear"></div>
	</body>
</html>
