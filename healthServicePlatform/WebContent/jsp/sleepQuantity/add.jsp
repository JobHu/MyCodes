<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>添加遗传病</title>
  <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 25px;">
			<form class="layui-form" action="${ctx}/sleep/addSleep" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">睡眠时间</label>
					<div class="layui-input-inline">
						<input type="text" name="sleepTime" 
							placeholder="输入睡眠时间" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">睡眠质量</label>
					<div class="layui-input-inline">
						<input type="text" name="sleepQuantity" 
							placeholder="输入睡眠质量" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">因素名称</label>
					<div class="layui-input-inline">
						<input type="text" name="name" 
							placeholder="输入因素名称" autocomplete="off" class="layui-input">
					</div>	
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">因素的时间点</label>
						<div class="layui-input-inline">
						<input type="text" name="time" 
							placeholder="因素的时间点" autocomplete="off" class="layui-input">
					    </div>
						<label class="layui-form-label">心情</label>
						<div class="layui-input-inline">
							<input type="text" name="mood" 
								placeholder="输入心情" autocomplete="off" class="layui-input">
						</div>
						<label class="layui-form-label">工作状态</label>
						<div class="layui-input-inline">
							<input type="text" name="workState" 
								placeholder="输入工作状态" autocomplete="off" class="layui-input">
						</div>
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">身体状态</label>
					<div class="layui-input-inline">
						<input type="text" name="bodyState" 
								placeholder="输入身体状态" autocomplete="off" class="layui-input">
					</div>
					  <label class="layui-form-label">注意力</label>
					<div class="layui-input-inline">
						<input type="text" name="attention" 
								placeholder="输入注意力" autocomplete="off" class="layui-input">
					</div>
					  <label class="layui-form-label">胃口</label>
					<div class="layui-input-inline">
						<input type="text" name="appetite" 
								placeholder="输入胃口" autocomplete="off" class="layui-input">
					</div>
					  
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
layui.use(['form','jquery'], function(){
  var form = layui.form;
  var $ = layui.jquery;
  
  
  
})
  

</script>
</body>
</html>