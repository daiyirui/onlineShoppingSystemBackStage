<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jxust.entity.Kind"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	
	Kind kind=(Kind)request.getAttribute("kind");
%>

<html>
	<head>
		<title>江理大队 • 学员管理系统 | 添加学员</title>

		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="./js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
		<form name="doUpdateFrm" action="./KindService" class="userAdd"  method="post">
			<input type="hidden" name="action" value="doUpdate" />
			<input type="hidden" name="kindid" value="<%=kind.getClassid()%>">
			<div class="right_content" align="center">
				<h2>修改商品类别信息</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">类别姓名</span>
							</td>
							<td>
								<input name="kindname" id="" class="info-textfield" type="text" value="<%=kind.getClassname() %>" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">类别说明</span>
							</td>
							<td>
								<input name="remark" id="" class="info-textfield" type="text" value="<%=kind.getRemark() %>" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
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
								<!-- 页码 + 按钮 -->
								<div class="btns-pagenav">
									<!-- 按钮 -->
									<div class="div-btns" style="float: left;">
										<a href="javascript:void(0)" class="bt_green" onclick="submit();">修改类别</a>
										<a href="javascript:void(0)" class="bt_green" onclick="javascript:history.go(-1);">返 回</a>
									</div>
									<!--end 按钮 -->
								</div>
								<!-- / 页码 + 按钮 -->
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>
		<div class="clear"></div>
	</body>
</html>
