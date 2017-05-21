<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
			function dorefer(){
				if( validate_form())
				UserFrm.submit();
			}
			
			//验证性别
			function checksex(sex) {
				if (sex != "男" && sex != "女") {
					document.getElementById("sexErr").innerHTML = "<font color='red'>请输入正确的性别！</font>";
					form.sex.focus();
					return false;
				} else {
					document.getElementById("sexErr").innerHTML = "";
					return true;
				}
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
				if(!checksex(sex)) return false;
				if(!isEmail(str)) return false;
				return true;
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
		<form name="UserFrm" action="./UserService" class="userAdd"  method="post">
			<input type="hidden" name="action" value="add" />
			<div class="right_content" align="center">
				<h2>添加会员</h2>
				<table id="input-table" style="width: 40%;">
					<tbody>
						<tr>
							<td>
								<span class="">会员姓名</span>
							</td>
							<td>
								<input name="username" id="" class="info-textfield" type="text" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">会员密码</span>
							</td>
							<td>
								<input name="password" id="" class="info-textfield" type="password" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">会员年龄</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="age"  />
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">会员性别</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="sex" id="sex"  onblur="checksex(this.value)"/>
								<div id = "sexErr"></div>
							</td>
						</tr>
						
						<tr>
							<td>
								<span class="">会员email</span>
							</td>
							<td>
								<input type="text" class="info-textfield" name="email" id="email"  onblur="isEmail(this.value)" />
								<div id = emailErr></div>
							</td>
						</tr>

						<tr>
							<td>

								<span class="">会员简介</span>

							</td>
							<td>
								<input name="remark" id="" class="info-textfield" type="text" />
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
										 <a href="javascript:void(0)" class="bt_green" onclick="dorefer();">添 加 会 员</a>
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
