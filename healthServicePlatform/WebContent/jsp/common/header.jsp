<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>  -->

 <div class="layui-header">
    <div class="layui-logo">健康信息服务平台</div>
   
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                  ${myuser.username }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="${ctx}/user/logout">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed" >
          <a class="" href="javascript:void(0)">健康档案</a>
          <dl class="layui-nav-child">
            <dd><a href="${ctx}/physicalExamination/personPhysicalExamination/1">体检数据</a></dd>
            <dd><a href="${ctx}/homesickness/queryHomeSickness">家族健康史</a></dd>
            <dd><a href="${ctx}/jsp/physicalExamination/analysis.jsp">体检数据分析</a></dd> 
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">健康数据</a>
          <dl class="layui-nav-child">
            <dd><a href="${ctx}/sleep/query">睡眠质量监控</a></dd>
            <dd><a href="${ctx}/jsp/bloodPressure/index.jsp">血压监控</a></dd>
            <dd><a href="${ctx}/bloodSugar/queryAllBloodSugar/1">血糖监控</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a class="" href="javascript:;">健身计划</a>
          <dl class="layui-nav-child">
            <dd><a href="${ctx}/fitMethod/queryAllFitMethod/1">健身方法</a></dd>
            <dd><a href="${ctx}/fitPlan/queryFitPlan/1">个人健身计划</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a class="" href="javascript:;">健身数据</a>
          <dl class="layui-nav-child">
            <dd><a href="${ctx}/antiGroup/queryAllAntiGroup/1">抗组运动</a></dd>
            <dd><a href="${ctx}/aerobicMovement/queryAerobicMovement/1">有氧运动</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a class="" href="javascript:;">健康中心</a>
          <dl class="layui-nav-child">
            <dd><a href="${ctx}/dayCookBook/queryAllCookBook/1">每日食谱</a></dd>
            <dd><a href="${ctx}/reducePressure/queryAllReducePressure/1">减压抗压</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a class="" href="javascript:;">在线交流</a>
          <dl class="layui-nav-child">
            <dd><a href="${ctx}/problem/queryAllProblem">在线问题</a></dd>  
          </dl>
        </li>
      </ul>
    </div>
  </div>
<!--   </body>
</html> --> 