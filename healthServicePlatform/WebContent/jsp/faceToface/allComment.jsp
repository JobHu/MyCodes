<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>面对面交流中心</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
			<div style="padding: 15px;">
			
		    <p style="color: green;font-size: 30px; text-align: center;">所有的评论</p>
		    
			 
			 <table class="layui-table" style="text-align: center;"> 
			  
			    <tr>
			       <th>评论内容</th>
			       <th>评论时间</th>
			       <th>评论人</th>
			       <th>评论问题</th>
			       <th>点赞数</th>
			       <th>操作</th>
			    </tr> 
				
				      <c:forEach  items="${problemComments}" var="obj">
				         <tr>
				         <td>${obj.commentContent}</td>
				         <td><fmt:formatDate value="${obj.commentTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				         <td>${obj.user.username}</td>
				         <td>${obj.problem.problemName}</td>
				         <td>${obj.commentThumbs}</td>
				         <td>
				           <a href="${ctx}/problem/toProblemCommentReply/${obj.id}" style="color: blue;">回复</a>
				           <a href="${ctx}/problem/queryAllProblemCommentReply/${obj.id}" style="color: green;">查看回复</a>
				           <a href="" style="color: red;">点赞</a>
				         </td> 
				        </tr>
				      </c:forEach>
				  
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