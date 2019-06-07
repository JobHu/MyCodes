<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>评论的评论</title>
  <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
  <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 25px;">
			<form class="layui-form" action="${ctx}/problem/problemCommentReply" method="post">
				<input type="hidden" name="commentId" value="${pCId}"/>
					<div class="layui-form-item">
					<label class="layui-form-label">回复内容</label>
			      <div class="layui-input-inline">
			        <div class="layui-input-inline">
                         <textarea name="commentReplyContent" placeholder="请输入回复内容" class="layui-textarea"></textarea>
                   </div>
			      </div>	
				</div>
					<div class="layui-form-item">
					<label class="layui-form-label">回复的时间</label>
			      <div class="layui-input-inline">
			        <input type="text" class="layui-input" id="test1" placeholder="年月日时分秒" name="commentReplyTime">
			      </div>	
				</div>
				 <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit lay-filter="add" style="border-left: 20px;">提交</button>
				    </div>
				 </div>
			</form>
			   
				
			</div>
		</div>
  
 <jsp:include page="/jsp/common/foot.jsp"></jsp:include>
</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use(['form','jquery','laydate'], function(){
  var form = layui.form;
  var $ = layui.jquery;
  var laydate = layui.laydate;
  
//日期时间选择器
  laydate.render({
    elem: '#test1'
    ,type: 'datetime'
  });
  
  
})
  

</script>
</body>
</html>