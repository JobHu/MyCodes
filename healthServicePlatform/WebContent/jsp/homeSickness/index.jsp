<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家族遗传病的主页</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
		<div style="padding: 60px;">
		<div style="color: silver; font-family: 100px; font-weight: bolder; text-align: center;">家族疾病一览表</div>
		<div style="padding-left: 10px;">
		 <a href="${ctx}/homesickness/toAddHomeSickness" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe654;</i></a>
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
						<col width="50">
						<col width="90">
					</colgroup> 
					<thead>
						<tr>
						    <th>名称</th>
						    <th>类型</th>
							<th>是否遗传</th>
							<th>是否治疗</th>
							<th>发病率</th>
							<th>关系</th>
							<th>姓名</th>
							<th>现状</th>
							<th>发病次数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allHomeSickness}" var="obj">
							<tr>
								<td>${obj.sicknessName}</td>
								<td>${obj.sicknessType}</td>
								<td>${obj.sicknessInheritance}</td>
								<td>${obj.sicknessTreat}</td>
								<td>${obj.sicknessAttack }</td>
								<td>${obj.member.mRelation}</td>
								<td>${obj.member.mName}</td>
								<td>${obj.member.mStatus }</td>
								<td>${obj.member.mSicknessCount }</td>
								<td>
								
								<a href="${ctx}/homesickness/deleteHomeSickness/${obj.member.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a>
								</td>
							</tr>
						</c:forEach>
						<%-- <tr>
							<td>共${allPhysicalExamination.total }条 当前${allPhysicalExamination.pageNum }/${allPhysicalExamination.pages }页
							</td>
							<td colspan="9"><a href="javascript:void(0)" page="first">首页</a> <a href="javascript:void(0)" page="previous">上一页</a> <a
								href="javascript:void(0)" page="next">下一页</a> <a href="javascript:void(0)" page="last">尾页</a>
								<input type="text" value="第几页" style="width:50px;">&nbsp;&nbsp;<button id="going">go</button>
						    </td>
						</tr> --%>
					</tbody>
				</table>
		</div>
		</div>
		<jsp:include page="/jsp/common/foot.jsp"/>
	</div>
	<script src="${ctx}/static/plugins/layui/layui.js"></script>
	<script>
    layui.use(['element','form','jquery'], function(){
    	  var element = layui.element; 
    	  var form = layui.form;
    	  var $ = layui.jquery;
    	  	  
    })
    
    
    </script>
</body>
</html>