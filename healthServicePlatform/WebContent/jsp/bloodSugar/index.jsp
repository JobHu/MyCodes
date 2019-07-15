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
		         <div class="layui-form-item">
				    <div class="layui-input-block">
				      <a href="${ctx}/bloodSugar/toAddBloodSugar" class="layui-btn " style="border-left: 20px;">录入血糖数据</a>
				    </div>    
				 </div>
				 <form class="layui-form" action="${ctx}/bloodSugar/queryBloodSugarByDayTime">
				    <div class="layui-form-item">
				     <label class="layui-form-label">日期</label>
					<div class="layui-input-inline">
			        <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd" name="dayTime" >
			       </div>
			        <div class="layui-input-inline">
                      <button class="layui-btn" lay-submit lay-filter="demo1">查询</button>
                   </div>
				    </div>
				 </form>
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
						<col width="50">
						<col width="90">
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
							<th>日期</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfos.list}" var="obj" varStatus="xh">
							<tr>
								<td>${xh.count}</td>
								<td>${obj.breakerHalf}</td>
								<td>${obj.breakTwo}</td>
								<td>${obj.noonHalf}</td>
								<td>${obj.noonTwo}</td>
								<td>${obj.dinnerHalf}</td>
								<td>${obj.dinnerTwo}</td>
								<td>${obj.bedTime}</td>
								<td><fmt:formatDate value="${obj.dayTime}" pattern="yyyy-MM-dd"/></td>
								
								<td>
							<%-- 	<a href="${ctx}/physicalExamination/deletePhysicalExamination/${obj.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a> --%>
								 <a href="${ctx}/bloodSugar/toEditBloodSugar/${obj.id}" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe642;</i></a>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td>共${pageInfos.total }条 当前${pageInfos.pageNum }/${pageInfos.pages }页
							</td>
							<td colspan="9"><a href="javascript:void(0)" page="first">首页</a> <a href="javascript:void(0)" page="previous">上一页</a> <a
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
  			
  			/* $('input[name=pageNum]').val(pageNum);
  			//跟新玩之后整体的提交表单
  			$('form').submit(); */
  			window.location = "${ctx}/bloodSugar/queryAllBloodSugar/"+pageNum;
  		});
     //分页功能的结束==========================	
    	 
  	//常规用法
  	  laydate.render({
  	    elem: '#test1'
  	  });
    })
    
    
    
    
    </script>
</body>
</html>