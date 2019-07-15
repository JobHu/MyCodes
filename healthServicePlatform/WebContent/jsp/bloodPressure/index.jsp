<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>血压监控</title>
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
<%--  <script src="${ctx}/static/plugins/echarts/echarts.js"></script>  --%>
<!-- <script src="https://cdn.bootcss.com/echarts/4.1.0/echarts.common.js"></script> --> 
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</head>
<script type="text/javascript">
		/*  ajax 方式上传文件操作 */  
		$(document).ready(function(){ 
		   $("#btn").click(function(){ if(checkData()){  
		           $('#form1').ajaxSubmit({    
		               url:'uploadExcel/ajax',  
		               dataType: 'text',  
		               success: resutlMsg,  
		               error: errorMsg  
		           });   
		           function resutlMsg(msg){  
		               alert(msg);     
		               $("#upfile").val("");  
		           }  
		           function errorMsg(){   
		               alert("导入excel出错！");      
		           }  
		       }   
		   });  
		});  
		  
		//JS校验form表单信息  
		function checkData(){  
		   var fileDir = $("#upfile").val();  
		   var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
		   if("" == fileDir){  
		       alert("选择需要导入的Excel文件！");  
		       return false;  
		   }  
		   if(".xls" != suffix && ".xlsx" != suffix ){  
		       alert("选择Excel格式的文件导入！");  
		       return false;  
		   }  
		   return true;  
		}   
</script>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="/jsp/common/header.jsp" />
		<div class="layui-body">
		<div style="padding: 60px;">
		   <div class="layui-form-item">
			   <form method="post" enctype="multipart/form-data" id="form1" action="${ctx}/bloodPressure/addBloodPressureHoures" class="layui-form">
		             <label class="layui-form-label">上传文件:</label>
		               <div class="layui-input-inline">
		                   <input id="upfile" type="file" name="upfile" class="layui-input">
		              </div>
		              <div class="layui-input-inline">
		             <button type="submit" onclick="return checkData()" class="layui-btn">提交</button>
		             </div>
		             <!-- <input type="button" value="ajax提交" id="btn" name="btn" >  --> 
             </form>  
			</div>
		   <div class="layui-form-item">
		       <div class="layui-inline">
			      <label class="layui-form-label">天数选择：</label>
			      <div class="layui-input-inline">
			        <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd" name="dayTime">
			      </div>
			      <button type="button" class="layui-btn" id="show">查询</button>
			    </div>
				   
        </div>
				<!-- 准备一个容器放分析的数据 -->
			 <div id="main" style="width: 600px;height:400px;"></div>
			 <div style="width: 600px;height:50px;">
			    <p id="result" style="padding-left: 100px;color: red;"></p>
			 </div>
		</div>
		</div>
		<jsp:include page="/jsp/common/foot.jsp"/>
	</div>
 <!-- echarts对数据进行分析的部分 -->	
<script type="text/javascript">
         $(function(){
        	 var a = [];
        	 var b = [];
        	 var c = [];
        	 //window.location.reload();
        	 $("#show").click(function(){
        		 var dayTime = $("input[type=text]").val();
        		// 基于准备好的dom，初始化echarts实例
                 var myChart = echarts.init(document.getElementById('main'));
        		
             
        		//一天24个小时的血压变化值
            	 $.ajax({  
     				url:"${ctx}/bloodPressure/bloodPressureHoures/"+dayTime,
     	           	type:"POST",
     	           	dataType:"json",
     				success:function(result){
     					 $.each(result.hourPressures, function(index, item) {
     	            		 a.push(item.eachHour);
     	            		 b.push(item.bloodPressureHour); 
     	            		 c.push(item.dayPressure.dayPressure);
     	            		 $("#result").html(item.dayPressure.dayResult);
     	    				});
     					
     	                var option = {
     	                		 title: {
     	                             text: '一天24小时的血压变化'
     	                         },
     	                      tooltip: {},
     	                      legend:{data:['每天血压均值'+c[0]+'mmHg,血压在60~90mmHg为正常']},
     	                		    xAxis: {
     	                		    	name: '小时',
     	                		        type: 'category',
     	                		        data: a
     	                		    },
     	                		    yAxis: {
     	                		    	name: '血压(单位:mmHg)',
     	                		        type: 'value'
     	                		    },
     	                		    series: [{
     	                		        data: b,
     	                		        type: 'line'
     	                		    }]
     	                		};
     	            
     	              myChart.clear();
   	                  myChart.setOption(option); 
   	                  //清空数组
   	                  a = [];
   	                  b = [];
   	                  c = [];
     				}      	   
     			  });
        	 });
         });
</script>

	<script src="${ctx}/static/plugins/layui/layui.js"></script>
	<script>
    layui.use(['element','form','jquery','laydate'], function(){
    	  var element = layui.element; 
    	  var form = layui.form;
    	  var $ = layui.jquery;
    	  var laydate = layui.laydate;
    	  
    	  //常规用法
    	  laydate.render({
    	    elem: '#test1'
    	  });
    	  	  
    })
    
    
    </script>
</body>
</html>