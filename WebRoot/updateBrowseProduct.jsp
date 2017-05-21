<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jxust.entity.BrowseProduct"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	
	BrowseProduct browseProduct=(BrowseProduct)request.getAttribute("browseProduct");
%>

<html>
	<head>
		<title>江理大队 • 学员管理系统 | 添加学员</title>

		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="./js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
		<form name="doUpdateFrm" action="./BrowseProductService" class="userAdd"  method="post">
			<input type="hidden" name="action" value="doUpdate" />
			<input type="hidden" name="browseproductid" value="<%=browseProduct.getBrowseproductid()%>">
			<div class="right_content" align="center">
				<h2>修改浏览产品信息</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">浏览产品名</span>
							</td>
							<td>
								<input name="browseproductname" id="" value="<%=browseProduct.getBrowseproductname() %>" class="info-textfield" type="text" />
							</td>
						</tr>
						<tr>
							<td>
								<span class="">产品id</span>
							</td>
							<td>
								<input name="productid" id="" class="info-textfield" type="text" value="<%=browseProduct.getProductid() %>"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">类别id</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="classid" value="<%=browseProduct.getClassid() %>" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">人气指数</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="popularity" value="<%=browseProduct.getPopularity() %>" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">热销指数</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="hotsale" value="<%=browseProduct.getHotsale() %>" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">关键字</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="keys" value="<%=browseProduct.getKeywords() %>" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">图片</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="picture" value="<%=browseProduct.getPicture() %>" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">说明</span>
							</td>
							<td>
								<input name="remark" id="" class="info-textfield" type="text" value="<%=browseProduct.getRemark() %>" />
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
										<a href="javascript:void(0)" class="bt_green" onclick="submit();">修改 浏览产品</a>
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
