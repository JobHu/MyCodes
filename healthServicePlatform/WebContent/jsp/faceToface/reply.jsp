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
			       <th>回复问题</th>
			       <th>回复时间</th>
			       <th>回复人</th>
			       <th>回复内容</th>
			    
			    </tr> 
				
				      <c:forEach  items="${problemCommentReplys}" var="obj">
				         <tr>
				         <td>${obj.problemComment.commentContent}</td>
				         <td><fmt:formatDate value="${obj.commentReplyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				         <td>${obj.user.username}</td>
				         <td>${obj.commentReplyContent}</td>
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