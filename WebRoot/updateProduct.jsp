<%@page import="com.jxust.entity.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	
	Product product=(Product)request.getAttribute("product");
%>

<html>
	<head>
		<title>江理大队 • 学员管理系统 | 添加学员</title>

		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="./js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
		<form name="doUpdateFrm" action="./ProductServlet"   method="post">
			<input type="hidden" name="action" value="doUpdate" />
			<input type="hidden" name="productid" value="<%=product.getProductid()%>">
			<div class="right_content" align="center">
				<h2>修改产品</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">产品名称</span>
							</td>
							<td>
								<input name="productname" value="<%=product.getProductname()%>" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">类别id</span>
							</td>
							<td>
								<input type="text" name="classid" class="info-textfield" value ="<%=product.getClassid()%>"/>
							</td>
						</tr>
						<tr>
							<td>
								<span class="">单价</span>
							</td>
							<td>
								<input name="price" value ="<%=product.getPrice() %>" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">产品数量</span>
							</td>
							<td>
								<input type="text" name="number" class="info-textfield" value ="<%=product.getNumber() %>"/>
							</td>
						</tr>
						<tr>
							<td>
								<span class="">产品图片</span>
							</td>
							<td>
								<input name="picture" id="" class="info-textfield" type="text" value ="<%=product.getPicture() %>"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">备注</span>
							</td>
							<td>
								<input type="text" name="remark" class="info-textfield" value ="<%=product.getRemark() %>"/>
							</td>
						</tr>
						<tr>
							<td>
								<span class="">折扣</span>
							</td>
							<td>
								<input type="text" name="discount" class="info-textfield" value ="<%=product.getDiscount() %>"/>
							</td>
						</tr>
						<tr>
							<td>
								<span class="">交易数量</span>
							</td>
							<td>
								<input type="text" name="tradenumber" class="info-textfield" value ="<%=product.getTradenumber() %>"/>
							</td>
						</tr>
						<tr>
							<td>
								<span class="">评价数量</span>
							</td>
							<td>
								<input type="text" name="evaluatenumber" class="info-textfield" value ="<%=product.getEvaluatenumber() %>"/>
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
										<a href="javascript:void(0)" class="bt_green" onclick="submit();">修改产品</a>
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