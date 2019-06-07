<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人体检数据中心</title>
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
				      <a href="${ctx}/physicalExamination/toAddPhysicalExamination" class="layui-btn " style="border-left: 20px;">录入体检信息</a>
				    </div>
				 </div>
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
						    <th>体重(kg)</th>
						    <th>年龄</th>
							<th>血压(mmHg)</th>
							<th>血糖(mmol/l)</th>
							<th>体脂比例</th>
							<th>白细胞红细胞的比例</th>
							<th>心电图</th>
							<th>胸透</th>
							<th>肝功能</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allPhysicalExamination.list}" var="obj">
							<tr>
								<td>${obj.weight}</td>
								<td>${obj.age}</td>
								<td>(${obj.bloodPressure } ,${obj.bloodPressureTwo })</td>
								<td>${obj.bloodSugar}</td>
								<td>${obj.bodyFat }</td>
								<td>${obj.whiteRedProportion }</td>
								<td>${obj.electrocardiogram}</td>
								<td>${obj.chestXRays}</td>
								<td>${obj.liverFunction }</td>
								<td>
								<a href="${ctx}/physicalExamination/deletePhysicalExamination/${obj.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a>
								<!-- <a href="" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe642;</i></a> -->
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td>共${allPhysicalExamination.total }条 当前${allPhysicalExamination.pageNum }/${allPhysicalExamination.pages }页
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
    layui.use(['element','form','jquery','layer'], function(){
    	  var element = layui.element; 
    	  var form = layui.form;
    	  var $ = layui.jquery;
    	  var layer = layui.layer;
    	//=============分页功能的实现=================
  		$('a[page]').click(function(){		
  			
  			var pageNum = 1;
  			var currentPageNum = ${allPhysicalExamination.pageNum};
  			var totalPage = ${allPhysicalExamination.pages};
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
  			window.location = "${ctx}/physicalExamination/personPhysicalExamination/"+pageNum;
  		});
     //分页功能的结束==========================	  
    })
    
    
    </script>
</body>
</html>