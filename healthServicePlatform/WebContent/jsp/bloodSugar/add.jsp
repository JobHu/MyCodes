<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title></title>
  <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 25px;">
			<form class="layui-form" action="${ctx}/bloodSugar/addBloodSugar" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">早餐前半小时</label>
					<div class="layui-input-inline">
						<input type="text" name="breakerHalf" 
							placeholder="输入早餐前半小时" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">早餐后2小时</label>
					<div class="layui-input-inline">
						<input type="text" name="breakTwo" 
							placeholder="输入早餐后2小时" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">午餐前半小时</label>
					<div class="layui-input-inline">
						<input type="text" name="noonHalf" 
							placeholder="输入午餐前半小时" autocomplete="off" class="layui-input">
					</div>	
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">午餐后2小时</label>
						<div class="layui-input-inline">
							<input type="text" name="noonTwo" 
								placeholder="输入午餐后2小时" autocomplete="off" class="layui-input">
						</div>
						<label class="layui-form-label">晚餐前半小时</label>
						<div class="layui-input-inline">
							<input type="text" name="dinnerHalf" 
								placeholder="输入晚餐前半小时" autocomplete="off" class="layui-input">
						</div>
						<label class="layui-form-label">晚餐后两小时</label>
						<div class="layui-input-inline">
							<input type="text" name="dinnerTwo" 
								placeholder="输入晚餐后两小时" autocomplete="off" class="layui-input">
						</div>
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">睡前</label>
					<div class="layui-input-inline">
						<input type="text" name="bedTime" 
								placeholder="输入睡前" autocomplete="off" class="layui-input">
					</div>
					  <label class="layui-form-label">日期</label>
					<div class="layui-input-inline">
			        <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd" name="dayTime">
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