<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>血糖查看中心</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
		<div style="padding: 15px;">
		<%-- <form action="${ctx}/physicalExamination/personPhysicalExamination" method="post">
		   <input type="hidden" name="pageNum" value="1">
		</form> --%>
		       
		<table class="layui-table" style="text-align: center;">
					 <colgroup>
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">					
					</colgroup> 
					<thead>
						<tr>
						    <th>编号</th>
						    <th>早餐前半时</th>
							<th>早餐后2时</th>
							<th>午餐前半时</th>
							<th>午餐后2时</th>
							<th>晚餐前半时</th>
							<th>午餐后2时</th>
							<th>睡前</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bloodSugars}" var="obj" varStatus="xh">
							<tr>
								<td>${xh.count}</td>
								<td>${obj.breakerHalf}</td>
								<td>${obj.breakTwo}</td>
								<td>${obj.noonHalf}</td>
								<td>${obj.noonTwo}</td>
								<td>${obj.dinnerHalf}</td>
								<td>${obj.dinnerTwo}</td>
								<td>${obj.bedTime}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
		</div>
		<jsp:include page="/jsp/common/foot.jsp" />
	</div>
	<script src="${ctx}/static/plugins/layui/layui.js"></script>
	<script>
    layui.use(['element','form','jquery','layer','laydate'], function(){
    	  var element = layui.element; 
    	  var form = layui.form;
    	  var $ = layui.jquery;
    	  var layer = layui.layer;
    	  var laydate = layui.laydate;
    	
  	
    })
    
    
    
    
    </script>
</body>
</html>