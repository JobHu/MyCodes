<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>减压抗压页面主页</title>
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
		  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <a href="${ctx}/reducePressure/toAddReducePressure" class="layui-btn " style="border-left: 20px;">添加抗压方法</a>
				    </div>
		 </div>
		<%-- <table class="layui-table" style="text-align: center;">
					 <colgroup>
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="90">
					</colgroup> 
					<thead>
						<tr>
						    <th>编号</th>
						    <th>创建时间</th>
							<th>运动时长(分钟)</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfos.list}" var="obj" varStatus="xh">
							<tr>
								<td>${xh.count}</td>
								<td><fmt:formatDate value="${obj.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${obj.movementTime }</td>
								<td>${obj.remark}</td>
								<td>
								<a href="${ctx}/aerobicMovement/deleteAerobicMovement/${obj.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a>
								<!-- <a href="" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe642;</i></a> -->
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td>共${pageInfos.total }条 当前${pageInfos.pageNum }/${pageInfos.pages }页
							</td>
							<td colspan="8"><a href="javascript:void(0)" page="first">首页</a> <a href="javascript:void(0)" page="previous">上一页</a> <a
								href="javascript:void(0)" page="next">下一页</a> <a href="javascript:void(0)" page="last">尾页</a>
								<input type="text" value="第几页" style="width:50px;">&nbsp;&nbsp;<button id="going">go</button>
						    </td>
						</tr>
					</tbody>
				</table> --%>
		  <c:forEach items="${pageInfos.list}" var="obj">
			<div class="layui-collapse" lay-accordion>
				  <div class="layui-colla-item">
				    <h2 class="layui-colla-title">${obj.reducePressureName}</h2>
				    <div class="layui-colla-content">${obj.content }
				    <a href="${ctx}/reducePressure/deleteReducePressure/${obj.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a>
				    </div>
				  </div>
           </div>
		  </c:forEach>
		  <div class="layui-form-item">
			  共${pageInfos.total }条 当前${pageInfos.pageNum }/${pageInfos.pages }页
			  <a href="javascript:void(0)" page="first">首页</a> 
			  <a href="javascript:void(0)" page="previous">上一页</a> 
			  <a href="javascript:void(0)" page="next">下一页</a> 
			  <a href="javascript:void(0)" page="last">尾页</a>
			</div>
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
  			
  			/* $('input[name=pageNum]').val(pageNum);
  			//跟新玩之后整体的提交表单
  			$('form').submit(); */
  			window.location = "${ctx}/reducePressure/queryAllReducePressure/"+pageNum;
  		});
     //分页功能的结束==========================
 
    })
    
    
    </script>
</body>
</html>