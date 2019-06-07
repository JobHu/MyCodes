<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>添加遗传病</title>
  <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 <jsp:include page="/jsp/common/header.jsp"></jsp:include>
  <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 25px;">
			<form class="layui-form" action="${ctx}/homesickness/addHomeSickness" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">名称</label>
					<div class="layui-input-inline">
						<input type="text" name="sicknessName" 
							placeholder="输入疾病名称" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">类型</label>
					<div class="layui-input-inline">
						<input type="text" name="sicknessType" 
							placeholder="输入疾病类型" autocomplete="off" class="layui-input">
					</div>
					<label class="layui-form-label">遗传性</label>
					<div class="layui-input-inline">
						<select name="sicknessInheritance" lay-verify="required">
						        <option value=""></option>
						        <option value="有">有</option>
						        <option value="无">无</option>			        
						      </select>	
					</div>	
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">可治</label>
						<div class="layui-input-inline">
						      <select name="sicknessTreat" lay-verify="required">
						        <option value=""></option>
						        <option value="可以">可以</option>
						        <option value="不可以">不可以</option>			        
						      </select>
                        </div>
						<label class="layui-form-label">发病率</label>
						<div class="layui-input-inline">
							<input type="text" name="sicknessAttack" 
								placeholder="输入发病率" autocomplete="off" class="layui-input">
						</div>
						<label class="layui-form-label">关系</label>
						<div class="layui-input-inline">
							<input type="text" name="mRelation" 
								placeholder="输入与本人的关系" autocomplete="off" class="layui-input">
						</div>
				</div>
				<div class="layui-form-item">
					    <label class="layui-form-label">姓名</label>
					<div class="layui-input-inline">
						<input type="text" name="mName" 
								placeholder="输入姓名" autocomplete="off" class="layui-input">
					</div>
					  <label class="layui-form-label">现状</label>
					<div class="layui-input-inline">
						<select name="mStatus" lay-verify="required">
						        <option value=""></option>
						        <option value="治疗">治疗</option>
						        <option value="治愈">治愈</option>	
						        <option value="死亡">死亡</option>		        
						 </select>
					</div>
					  <label class="layui-form-label">发病次数</label>
					<div class="layui-input-inline">
						<input type="text" name="mSicknessCount" 
								placeholder="输入发病次数" autocomplete="off" class="layui-input">
					</div>
					  
				</div>
				 <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit lay-filter="add" style="border-left: 20px;">添加</button>
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
layui.use(['form','jquery'], function(){
  var form = layui.form;
  var $ = layui.jquery;
  
  
  
})
  

</script>
</body>
</html>