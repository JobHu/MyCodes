<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>添加健身方法的界面</title>
  <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
  <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 25px;">
			<form class="layui-form" action="${ctx}/fitMethod/addFitMethod" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">健身方法名称</label>
					<div class="layui-input-inline">
						<input type="text" name="fitName" 
							placeholder="输入健身方法名称" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">健身方法类型</label>
					<div class="layui-input-inline">
						<input type="text" name="fitType" 
							placeholder="输入健身方法类型" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">是否需要器材</label>
					<div class="layui-input-inline">
						<input type="text" name="fitEquipment" 
							placeholder="输入是否需要器材" autocomplete="off" class="layui-input">
					</div>	
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">详细描述</label>
						<textarea name="fitDescription" required lay-verify="required" placeholder="请输入详细描述" class="layui-textarea"></textarea>
				</div>
				 <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit lay-filter="add" style="border-left: 20px;">添加</button>
				    </div>
				 </div>
			</form>
			   
				
			</div>
		</div>
  
 <jsp:include page="/jsp/common/foot.jsp"></jsp:include>
</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use(['form','jquery','laydate'], function(){
  var form = layui.form;
  var $ = layui.jquery;
  var laydate = layui.laydate;
  
//常规用法
  laydate.render({
    elem: '#test1'
  });
})
  

</script>
</body>
</html>