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
	
		<form action="${ctx}/fitPlan/queryFitMethodByName" method="post" class="layui-form">
		  <div class="layui-form-item">
				    <div class="layui-input-inline">
				      <input type="text" name="methodName" required  lay-verify="required" placeholder="请输入健身方法" autocomplete="off" class="layui-input">
				    </div>
				    <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
				 </div>
		</form>
		<div style="padding-left: 10px;">
		 <a href="${ctx}/fitPlan/toAddFitPlan" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe654;</i></a>
		</div>
		<table class="layui-table" style="text-align: center;">
					 <colgroup>
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="100">
					</colgroup> 
					<thead>
						<tr>
						    <th>编号</th>
						    <th>健身目的</th>
							<th>健身强度</th>
							<th>健身频率</th>
							<th>健身时间点</th>
							<th>健身方法</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfos.list}" var="obj" varStatus="xh">
							<tr>
								<td>${xh.count}</td>
								<td>${obj.attention}</td>
								<td>${obj.strength}</td>
								<td>${obj.frequency}</td>
								<td>${obj.fixedTime}</td>
								<td>${obj.methodName}</td>
								 <td>
								   <a href="${ctx}/fitPlan/deleteFitPlan/${obj.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a>
								   <a href="${ctx}/fitPlan/toEditFitPlan/${obj.id}" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe642;</i></a> 
								</td>
							</tr>
							
						</c:forEach>
						<tr>
							<td>共${pageInfos.total }条 当前${pageInfos.pageNum }/${pageInfos.pages }页
							</td>
							<td colspan="7"><a href="javascript:void(0)" page="first">首页</a> <a href="javascript:void(0)" page="previous">上一页</a> <a
								href="javascript:void(0)" page="next">下一页</a> <a href="javascript:void(0)" page="last">尾页</a>
								<input type="text" value="第几页" style="width:50px;">&nbsp;&nbsp;<button id="going">go</button>
						    </td>
						</tr>
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