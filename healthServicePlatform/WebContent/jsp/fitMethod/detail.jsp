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
			
			 <div class="layui-form-item">
			      <a href="${ctx}/fitMethod/queryAllFitMethod/1" style="color: blue;padding-left: 40px;">返回</a>
			 </div>
			
			<textarea rows="40" cols="10"  class="layui-textarea">${fitMethod.fitDescription}</textarea>
				
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