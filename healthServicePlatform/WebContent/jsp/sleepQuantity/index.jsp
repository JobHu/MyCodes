<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>睡眠质量的主页</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
<%--  <script src="${ctx}/static/plugins/echarts/echarts.js"></script>  --%>
<!-- <script src="https://cdn.bootcss.com/echarts/4.1.0/echarts.common.js"></script> --> 
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
		<div style="padding: 60px;">
		<div style="color: silver; font-family: 100px; font-weight: bolder; text-align: center;">最近七天的睡眠质量一览表</div>
		<div style="padding-left: 10px;">
		 <a href="${ctx}/sleep/toAddSleep" class="layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe654;</i></a>
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
					</colgroup> 
					<thead>
						<tr>
						    <th>睡眠时间(小时)</th>
						    <th>睡眠质量</th>
							<th>因素名称</th>
							<th>因素时间点</th>
							<th>心情</th>
							<th>工作状态</th>
							<th>身体状况</th>
							<th>胃口</th>
							<th>集中力</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sleeps}" var="obj">
							<tr>
								<td>${obj.sleepTime}</td>
								<td>${obj.sleepQuantity}</td>
								<td>${obj.factor.name}</td>
								<td>${obj.factor.time}</td>
								<td>${obj.state.mood }</td>
								<td>${obj.state.workState}</td>
								<td>${obj.state.bodyState}</td>
								<td>${obj.state.appetite}</td>
								<td>${obj.state.attention}</td>
								<%-- <td>
								
								<a href="${ctx}/homesickness/deleteHomeSickness/${obj.member.id}" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#xe640;</i></a>
								</td> --%>
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
						<tr>
						<%-- <td colspan="9"><a href="${ctx}/sleep/queryByJson" style="color: blue;">分析一些因素对睡眠的影响</a></td> --%>
						<td  colspan="9"><button id="showResult"  style="color: blue;">分析一些因素对睡眠的影响</button></td>
						</tr>
					</tbody>
				</table>
				<!-- 准备一个容器放分析的数据 -->
			 <div id="main" style="width: 600px;height:400px;"></div>
			 <div id="main1" style="width: 600px;height:400px;"></div>
			 <div id="main2" style="width: 600px;height:400px;"></div>
			 <div id="main3" style="width: 600px;height:400px;"></div>	
		</div>
		</div>
		<jsp:include page="/jsp/common/foot.jsp"/>
	</div>
 <!-- echarts对数据进行分析的部分 -->	
<script type="text/javascript">

  var x = [];
  var y = [];
  var a = [];
  var b = [];
  var c = [];
  var d = [];
  var e = [];
  var f = [];

  $(function(){
	  
	  $("#showResult").click(function(){  
		  $.ajax({  
			url:"${ctx}/sleep/queryByJson",
           	type:"POST",
           	dataType:"json",
			success:function(result){
				 $.each(result.sleeps, function(index, item) {
            		 x.push(item.factor.name);
            		 y.push(item.sleepTime); 
    				});
				// 基于准备好的dom，初始化echarts实例
                 var myChart = echarts.init(document.getElementById('main'));
                 var option = {
                		 title: {
                             text: '睡眠时间和因素之间的关系'
                         },
                      tooltip: {},
                      legend:{data:['影响因子']},
                		    xAxis: {
                		    	name: '影响因素',
                		        type: 'category',
                		        data: x
                		    },
                		    yAxis: {
                		    	name: '睡眠时间(单位：h)',
                		        type: 'value'
                		    },
                		    series: [{
                		        data: y,
                		        type: 'bar'
                		    }]
                		};
                 myChart.setOption(option); 
			}
		  });
		  //因素时间点对睡眠质量的影响
		   $.ajax({  
				url:"${ctx}/sleep/queryByJson",
	           	type:"POST",
	           	dataType:"json",
				success:function(result){
					 $.each(result.sleeps, function(index, item) {
	            		 c.push(item.factor.time);
	            		 d.push(item.sleepQuantity); 
	    				});
					// 基于准备好的dom，初始化echarts实例
	                 var myChart = echarts.init(document.getElementById('main1'));
	                 var option = {
	                		 title: {
	                             text: '睡眠质量和因素时间点的关系'
	                         },
	                      tooltip: {},
	                      legend:{data:['因素时间点']},
	                		    xAxis: {
	                		    	name: '因素时间点',
	                		        type: 'category',
	                		        data: c
	                		    },
	                		    yAxis: {
	                		    	name: '睡眠质量(100制)',
	                		        type: 'value'
	                		    },
	                		    series: [{
	                		        data: d,
	                		        type: 'bar'
	                		    }]
	                		};
	                 myChart.setOption(option); 
				}
			  });
		  //身体状况和睡眠质量的关系
		  $.ajax({  
				url:"${ctx}/sleep/queryByJson",
	           	type:"POST",
	           	dataType:"json",
				success:function(result){
					 $.each(result.sleeps, function(index, item) {
	            		 a.push(item.state.bodyState);
	            		 b.push(item.sleepQuantity); 
	    				});
					// 基于准备好的dom，初始化echarts实例
	                 var myChart = echarts.init(document.getElementById('main2'));
	                 var option = {
	                		 title: {
	                             text: '身体状况和睡眠质量之间的关系'
	                         },
	                      tooltip: {},
	                      legend:{data:['身体状况']},
	                		    xAxis: {
	                		    	name: '身体状况',
	                		        type: 'category',
	                		        data: a
	                		    },
	                		    yAxis: {
	                		    	name: '睡眠质量(100制)',
	                		        type: 'value'
	                		    },
	                		    series: [{
	                		        data: b,
	                		        type: 'line'
	                		    }]
	                		};
	                 myChart.setOption(option); 
				}
			  });
		  //睡眠质量和睡眠时间之间的关系
		  $.ajax({  
				url:"${ctx}/sleep/queryByJson",
	           	type:"POST",
	           	dataType:"json",
				success:function(result){
					 $.each(result.sleeps, function(index, item) {
	            		 e.push(item.sleepTime);
	            		 f.push(item.sleepQuantity); 
	    				});
					// 基于准备好的dom，初始化echarts实例
	                 var myChart = echarts.init(document.getElementById('main3'));
	                 var option = {
	                		 title: {
	                             text: '睡眠时间和睡眠质量之间的关系'
	                         },
	                      tooltip: {},
	                      legend:{data:[]},
	                		    xAxis: {
	                		    	name: '睡眠时间',
	                		        type: 'category',
	                		        data: e
	                		    },
	                		    yAxis: {
	                		    	name: '睡眠质量(100制)',
	                		        type: 'value'
	                		    },
	                		    series: [{
	                		        data: f,
	                		        type: 'line'
	                		    }]
	                		};
	                 myChart.setOption(option); 
				}
			  });
	  });
	  
  });
   

</script>

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