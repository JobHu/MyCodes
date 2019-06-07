<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>添加每日食谱</title>
  <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
  <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 25px;">
			<form class="layui-form" action="${ctx}/dayCookBook/addCookBook" method="post">
				<div class="layui-form-item">
					  <label class="layui-form-label">早中晚</label>
					    <div class="layui-input-inline">
					      <select name="htmedType" lay-verify="required">
					        <option value=""></option>
					        <option value="早餐">早餐</option>
					        <option value="中餐">中餐</option>
					        <option value="晚餐">晚餐</option>
					      </select>
					    </div>
					    <label class="layui-form-label">主食</label>
					<div class="layui-input-inline">
						<input type="text" name="stapleFood" 
							placeholder="输入主食" autocomplete="off" class="layui-input">
					</div>
					    <label class="layui-form-label">创建时间</label>
					      <div class="layui-input-inline">
					        <input type="text" class="layui-input" id="test1" placeholder="年月日" name="dayTime">
					      </div>
						
				</div>
				<div class="layui-form-item">
				 <label class="layui-form-label">是否有蔬菜</label>
					    <div class="layui-input-inline">
					      <select name="whetherVegetables" lay-verify="required">
					        <option value=""></option>
					        <option value="是">是</option>
					        <option value="否">否</option>
					      </select>
					    </div>
					    <label class="layui-form-label">蔬菜</label>
					<div class="layui-input-inline">
						<input type="text" name="vegetables" 
							placeholder="输入蔬菜" autocomplete="off" class="layui-input">
					</div>
					 <label class="layui-form-label">是否有肉类</label>
					    <div class="layui-input-inline">
					      <select name="whetherMeat" lay-verify="required">
					        <option value=""></option>
					        <option value="是">是</option>
					        <option value="否">否</option>
					      </select>
					    </div>	
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">肉类</label>
					<div class="layui-input-inline">
						<input type="text" name="meat" 
							placeholder="输入肉类" autocomplete="off" class="layui-input">
					</div>	
					 <label class="layui-form-label">是否喝酒</label>
					    <div class="layui-input-inline">
					      <select name="whetherDrinking" lay-verify="required">
					        <option value=""></option>
					        <option value="是">是</option>
					        <option value="否">否</option>
					      </select>
					    </div>
					    <label class="layui-form-label">喝酒</label>
					<div class="layui-input-inline">
						<input type="text" name="drinking" 
							placeholder="输入酒类" autocomplete="off" class="layui-input">
					</div>	
				</div>
				<div class="layui-form-item">
				 <label class="layui-form-label">是否有水果</label>
					    <div class="layui-input-inline">
					      <select name="whetherFruit" lay-verify="required">
					        <option value=""></option>
					        <option value="是">是</option>
					        <option value="否">否</option>
					      </select>
					    </div>
					    <label class="layui-form-label">水果</label>
					<div class="layui-input-inline">
						<input type="text" name="fruit" 
							placeholder="输入水果" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">创建时间</label>
					      <div class="layui-input-inline">
					        <input type="text" class="layui-input" id="test2" placeholder="年月日时分秒" name="fruitTime">
					      </div>	
				</div>
					
				 <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit lay-filter="add" style="border-left: 20px;">添加</button>
				    
				      <button class="layui-btn" lay-submit lay-filter="add" style="border-left: 20px;" id="rtn">返回</button>
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
  });
  
  laydate.render({
	    elem: '#test2'
	    ,type: 'datetime'
	  });
  
  $('#rtn').click(function(){
	  window.location = "${ctx}/dayCookBook/queryAllCookBook/1";
  })
  
})
  

</script>
</body>
</html>