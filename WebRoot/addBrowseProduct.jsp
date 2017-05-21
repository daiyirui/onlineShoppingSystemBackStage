<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
			function dorefer(){
				//做表单验证
				
				//提交表单
				BrowseProductFrm.submit();
			}
		</script>
<html>
	<head>
		<title>江理大队 • 学员管理系统 | 添加学员</title>

		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="./js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
		<form name="BrowseProductFrm" action="./BrowseProductService" class="userAdd"  method="post">
			<input type="hidden" name="action" value="add" />
			<div class="right_content" align="center">
				<h2>添加浏览产品</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
								<tr>
							<td>
								<span class="">浏览产品名</span>
							</td>
							<td>
								<input name="browseproductname" id="" class="info-textfield" type="text" />
							</td>
						</tr>
						<tr>
							<td>
								<span class="">产品id</span>
							</td>
							<td>
								<input name="productid" id="" class="info-textfield" type="text" />
							</td>
						</tr>
						<tr>
							<td>
								<span class="">类别id</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="classid" value="" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">人气指数</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="popularity" value="" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">热销指数</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="hotsale" value="" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">关键字</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="keys" value="" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">图片</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="picture" value="" />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">说明</span>
							</td>
							<td>
								<input name="remark" id="" class="info-textfield" type="text" />
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
								<!-- 页码 + 按钮 -->
								<div class="btns-pagenav">
									<!-- 按钮 -->
									<div class="div-btns" style="float: left;">
										<a href="javascript:void(0)" class="bt_green" onclick="dorefer();">添 加 浏览产品</a>
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
