<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>健身计划的页面</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
		<div style="padding: 15px;">
	   <a href="${ctx}/fitPlan/queryFitPlan/1" style="color: blue; padding-left: 40px;">返回</a>
		<table class="layui-table" style="text-align: center;">
					 <colgroup>
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
						    <th>健身目的</th>
							<th>健身强度</th>
							<th>健身频率</th>
							<th>健身时间点</th>
							<th>健身方法</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${fitPlan}" var="obj" varStatus="xh">
							<tr>
								<td>${xh.count}</td>
								<td>${obj.attention}</td>
								<td>${obj.strength}</td>
								<td>${obj.frequency}</td>
								<td>${obj.fixedTime}</td>
								<td>${obj.methodName}</td>
								 
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
    	//=============分页功能的实现=================
  		$('a[page]').click(function(){		
  			
  			var pageNum = 1;
  			var currentPageNum = ${pageInfos.pageNum};
  			var totalPage = ${pageInfos.pages};
  			var choosePage = $(this).attr('page');
  			switch(choosePage){
  			case "first":
  				pageNum = 1;
  				break;
  			case "previous":
  				pageNum = currentPageNum -1 ;
  				if(pageNum < 1){
  					pageNum = 1;
  				}
  				break;
  			case "next":
  				pageNum = currentPageNum +1;
  				if(pageNum > totalPage){
  					pageNum = totalPage;
  				}
  				break;
  			case "last":
  				pageNum = totalPage;
  				break;
  			}
  			
  			/*  $('input[name=pageNo]').val(pageNum);
  			//跟新玩之后整体的提交表单
  			$('form').submit(); */ 
  			 window.location = "${ctx}/fitMethod/queryAllFitMethod/"+pageNum; 
  		});
     //分页功能的结束==========================	  
  		
     
    })
    
    
    </script>
</body>
</html>