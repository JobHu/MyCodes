<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有的健身方法</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
		<div style="padding: 15px;">
	
		<form action="${ctx}/fitMethod/queryFitMethodByName" method="post" class="layui-form">
		 <input type="hidden" name="pageNo" value="1">
		  <div class="layui-form-item">
				    <div class="layui-input-inline">
				      <input type="text" name="fitName" required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
				    </div>
				    <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
				 </div>
		</form>
		<div style="padding-left: 10px;">
		 <a href="${ctx}/fitMethod/toAddFitMethod" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe654;</i></a>
		</div>
		<table class="layui-table" style="text-align: center;">
					 <colgroup>
						<col width="100">
						<col width="100">
						<col width="100">
						<col width="100">
						<col width="100">
					</colgroup> 
					<thead>
						<tr>
						    <th>编号</th>
						    <th>名称</th>
							<th>类型</th>
							<th>是否需要器材</th>
							<th>详细描述</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfos.list}" var="obj" varStatus="xh">
							<tr>
								<td>${xh.count}</td>
								<td>${obj.fitName}</td>
								<td>${obj.fitType}</td>
								<td>${obj.fitEquipment}</td>
								<td><a href="${ctx}/fitMethod/queryDetailById/${obj.id}" style="color: blue;">查看详细</a></td>
								<%-- <td>${obj.fitDescription}</td> --%>
								
								<%-- <td>
								<a href="${ctx}/physicalExamination/deletePhysicalExamination/${obj.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a>
								<!-- <a href="" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe642;</i></a> -->
								</td> --%>
							</tr>
							
						</c:forEach>
						<tr>
							<td>共${pageInfos.total }条 当前${pageInfos.pageNum }/${pageInfos.pages }页
							</td>
							<td colspan="5"><a href="javascript:void(0)" page="first">首页</a> <a href="javascript:void(0)" page="previous">上一页</a> <a
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
    layui.use(['element','form','jquery','layer'], function(){
    	  var element = layui.element; 
    	  var form = layui.form;
    	  var $ = layui.jquery;
    	  var layer = layui.layer;
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