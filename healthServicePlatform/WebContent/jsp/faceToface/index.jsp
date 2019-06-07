<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线问题交流中心</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
			<div style="padding: 15px;">
			
		    <p style="color: green;font-size: 30px; text-align: center;">欢迎来到在线问题交流中心</p>
		     <div style="padding-top: 30px; padding-left: 150px;">
		      <p style="color: blue;text-align: left;font-size: 20px;" id="putforward">请在线提出问题进行交流？</p>  
		    </div>
			 
			 <table class="layui-table">
			    <tr>
			       <td>问题名称</td>
			       <td>问题内容</td>
			       <td>问题发表时间</td>
			       <td>问题发表人</td>
			       <td>点赞个数</td>
			       <td>操作</td>
			   </tr>
			  
			      <c:forEach  items="${problems}" var="obj">
			       <tr>
			         <td>${obj.problemName}</td>
			         <td>${obj.problemContent}</td>
			         <td> <fmt:formatDate value="${obj.reportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			        
			         <td>${obj.user.username}</td>
			         <td>${obj.thumbs}</td>
			         <td>
			           <a href="${ctx}/problem/comments/${obj.id}" style="color: blue;">评论</a>
			           <a href="${ctx}/problem/queryAllProblemComment/${obj.id}" style="color: green;">查看评论</a>
			           <a href="${ctx}/problem/thumbs/${obj.id}" style="color: red;" id="thumbs">点赞</a>
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
    	  
    	$("#putforward").click(function(){
    		window.location = "${ctx}/problem/toAdd";
    	})
    	
    	/* $("#thumbs").click(function(){
    		$.ajax({
    			type:'post',
    			url:'${ctx}/problem/thumbs',
    			success:function(){
    				
    			}
    		});
    	}) */

  	 
    })
    
    </script>
</body>
</html>