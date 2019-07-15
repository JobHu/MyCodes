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
			<form class="layui-form" action="${ctx}/physicalExamination/addPhysicalExamintion" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">年龄</label>
					<div class="layui-input-inline">
						<input type="text" name="age" 
							placeholder="输入年龄" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">血糖</label>
					<div class="layui-input-inline">
						<input type="text" name="bloodSugar" 
							placeholder="输入血糖（mmol/l）" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">收缩压</label>
					<div class="layui-input-inline">
						<input type="text" name="bloodPressure" 
							placeholder="输入收缩血压（mmHg）" autocomplete="off" class="layui-input">
					</div>	
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">体重</label>
						<div class="layui-input-inline">
							<input type="text" name="weight" 
								placeholder="输入体重(kg)" autocomplete="off" class="layui-input">
						</div>
						<label class="layui-form-label">白红细胞的比例</label>
						<div class="layui-input-inline">
							<input type="text" name="whiteRedProportion" 
								placeholder="输入白红细胞的比例" autocomplete="off" class="layui-input">
						</div>
						<label class="layui-form-label">肺功能</label>
						<div class="layui-input-inline">
							<input type="text" name="liverFunction" 
								placeholder="输入肺功能情况" autocomplete="off" class="layui-input">
						</div>
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">体脂</label>
					<div class="layui-input-inline">
						<input type="text" name="bodyFat" 
								placeholder="输入体脂比例" autocomplete="off" class="layui-input">
					</div>
					  <label class="layui-form-label">心电图</label>
					<div class="layui-input-inline">
						<input type="text" name="electrocardiogram" 
								placeholder="输入心电图情况" autocomplete="off" class="layui-input">
					</div>
					  <label class="layui-form-label">胸透</label>
					<div class="layui-input-inline">
						<input type="text" name="chestXRays" 
								placeholder="输入胸透的情况" autocomplete="off" class="layui-input">
					</div>
					  
				</div>
				
				<div class="layui-form-item">
				      <label class="layui-form-label">舒张压</label>
					<div class="layui-input-inline">
						<input type="text" name="bloodPressureTwo" 
								placeholder="输入舒张压" autocomplete="off" class="layui-input">
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