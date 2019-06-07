<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>更新健身计划的界面</title>
  <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
  <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 25px;">
			<form class="layui-form" action="${ctx}/fitPlan/editFitPlan" method="post">
			<input type="hidden" name="id" value="${fitPlan.id }">
				<div class="layui-form-item">
					<label class="layui-form-label">健身目的</label>
					<div class="layui-input-inline">
						<input type="text" name="attention" 
							placeholder="输入健身目的" autocomplete="off" class="layui-input" value="${fitPlan.attention }">
					</div>
					<label class="layui-form-label">健身强度</label>
					<div class="layui-input-inline">
						<input type="text" name="strength" 
							placeholder="输入健身强度" autocomplete="off" class="layui-input" value="${fitPlan.strength }">
					</div>
					<label class="layui-form-label">健身频率</label>
					<div class="layui-input-inline">
						<input type="text" name="frequency" 
							placeholder="输入健身频率" autocomplete="off" class="layui-input" value="${fitPlan.frequency }">
					</div>	
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">健身时间点</label>
						<div class="layui-input-inline">
						<input type="text" name="fixedTime" 
							placeholder="输入健身时间点" autocomplete="off" class="layui-input" value="${fitPlan.fixedTime }">
					</div>
					<label class="layui-form-label">健身方法</label>
						<div class="layui-input-inline">
						<input type="text" name="methodName" 
							placeholder="输入健身方法" autocomplete="off" class="layui-input" value="${fitPlan.methodName }">
					</div>
				</div>
				 <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit lay-filter="add" style="border-left: 20px;">修改</button>
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