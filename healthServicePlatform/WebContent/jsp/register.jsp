<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<style type="text/css">
form {
	width: 300px;
	margin: auto;
	margin-top: 5%;
}
</style>
</head>
<body>
	<div class="layui-container">
		<form class="layui-form" action="${ctx}/user/register">
		<div class="layui-form-item">
	              <h2 style="color: graytext;">健康信息服务平台注册页面</h2>
	           </div>
			<div class="layui-form-item">
				
				<div class="layui-input-inline">
					<input type="text" name="usercode" required lay-verify="required"
						placeholder="请输入用户账户" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				
				<div class="layui-input-inline">
					<input type="text" name="username" required lay-verify="required"
						placeholder="请输入用户名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				
				<div class="layui-input-inline">
					<input type="password" name="password" required
						lay-verify="required" placeholder="请输入用户密码" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				
				<div class="layui-input-inline">
					<input type="password" name="confirmPwd" required
						lay-verify="required" placeholder="请确认密码" autocomplete="off"
						class="layui-input">
				</div>
			</div>
				<div class="layui-form-item">
				
				<div class="layui-input-inline">
					<input type="text" name="phone" required
						lay-verify="required" placeholder="请输入电话" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
			
				<div class="layui-input-inline">
					<input type="radio" name="sex" value="男" title="男"> <input
						type="radio" name="sex" value="女" title="女" checked>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-inline">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script src="${ctx}/static/plugins/layui/layui.js"></script>
	<script>
		//Demo
		layui.use(['form','layer'], function() {
			var form = layui.form;
			var layer = layui.layer;
			
				var msg = "${msg}";
				if(msg != ''){
					 layer.msg(msg, {icon: 5});
				}
			

			//监听提交
			/*  form.on('submit(formDemo)', function(data){
			   layer.msg(JSON.stringify(data.field));
			   return false;
			 }); */
		});
	</script>
</body>
</html>