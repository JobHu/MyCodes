<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体检数据分析页面</title>
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
	 
	 <!-- 准备一个容器 -->
	 <div id="main" style="width: 600px;height:400px;">
	 </div>
	 <div id="main1" style="width: 600px;height:400px;">
	 </div>
	 <div id="main2" style="width: 600px;height:400px;">
	 </div>
	 <div id="main3" style="width: 600px;height:400px;">
	 </div>
	
		</div>
		</div>
		<jsp:include page="/jsp/common/foot.jsp"/>
	</div>
	
	<!--echarts部分  -->	
	<script type="text/javascript">

		

        //定义横坐标的值
        var x = [];
        //定义纵坐标的值
        var y = [];
        //血糖
        var a =[];
        var b =[];
        //体脂
        var c =[];
        var d =[];
        //体重
        var e =[];
        var f =[];
        
        $(function(){
        	
        	 $.ajax({
             	url:"${ctx}/physicalExamination/physicalExaminationAnysical",
             	type:"POST",
             	dataType:"json",
                success:function(result){
          	   // alert(result.allPhysicalExamination.length);
            	/* for(var i=0;i<result.allPhysicalExamination.length;i++){	
            		 x.push(getDateTime(ConvertJSONDateToJSDate(result.allPhysicalExamination[i].physicalTime)));
            		 y.push(result.allPhysicalExamination[i].bloodPressure); 
                	} */
                	 $.each(result.allPhysicalExamination, function(index, item) {
                		 x.push(getDateTime(ConvertJSONDateToJSDate(item.physicalTime)));
                		 y.push(item.bloodPressure); 
        				});	
                	
                	// 基于准备好的dom，初始化echarts实例
                     var myChart = echarts.init(document.getElementById('main'));
                     var  option = {
                    		title: {
                                   text: '血压数据分析图表'
                               },
                            tooltip: {},
                            legend:{data:['血压最好在75mmHg,在60~90之间正常']},
                    	    xAxis: {
                    	        name:'时间',
                    	    	type: 'category',
                    	        data: x
                    	    },
                    	    yAxis: {
                    	    	 name:'血压(单位:mmHg)',
                    	    	 type: 'value'
                    	    },
                    	    series: [{
                    	         data: y,
                    	         type:'line'
                    	    }]
                    	}; 
                        myChart.setOption(option);               	
                 }
             	
             });
        	 //血糖的变化
        	  $.ajax({
             	url:"${ctx}/physicalExamination/physicalExaminationAnysical",
             	type:"POST",
             	dataType:"json",
                success:function(result){
          	   // alert(result.allPhysicalExamination.length);
            	/* for(var i=0;i<result.allPhysicalExamination.length;i++){	
            		 x.push(getDateTime(ConvertJSONDateToJSDate(result.allPhysicalExamination[i].physicalTime)));
            		 y.push(result.allPhysicalExamination[i].bloodPressure); 
                	} */
                	 $.each(result.allPhysicalExamination, function(index, item) {
                		 a.push(getDateTime(ConvertJSONDateToJSDate(item.physicalTime)));
                		 b.push(item.bloodSugar); 
        				});	
                	
                	// 基于准备好的dom，初始化echarts实例
                     var myChart = echarts.init(document.getElementById('main1'));
                     var  option = {
                    		title: {
                                   text: '血糖数据分析图表'
                               },
                            tooltip: {},
                            legend:{data:['血糖最好在5mmol/l,在3.1~6.9之间正常']},
                    	    xAxis: {
                    	        name:'时间',
                    	    	type: 'category',
                    	        data: a
                    	    },
                    	    yAxis: {
                    	    	 name:'血糖(单位:mmmol/l)',
                    	    	 type: 'value'
                    	    },
                    	    series: [{
                    	    	   itemStyle : {  
                                       normal : {  
                                           lineStyle:{  
                                               color:'#00FF00'  
                                           }  
                                       }  
                                   },  
                    	         data: b,
                    	         type:'line'
                    	    }]
                    	}; 
                        myChart.setOption(option);               	
                 }
             	
             });
        	 //体脂的变化
        	 $.ajax({
             	url:"${ctx}/physicalExamination/physicalExaminationAnysical",
             	type:"POST",
             	dataType:"json",
                success:function(result){
          	   // alert(result.allPhysicalExamination.length);
            	/* for(var i=0;i<result.allPhysicalExamination.length;i++){	
            		 x.push(getDateTime(ConvertJSONDateToJSDate(result.allPhysicalExamination[i].physicalTime)));
            		 y.push(result.allPhysicalExamination[i].bloodPressure); 
                	} */
                	 $.each(result.allPhysicalExamination, function(index, item) {
                		 c.push(getDateTime(ConvertJSONDateToJSDate(item.physicalTime)));
                		 d.push(item.bodyFat); 
        				});	
                	
                	// 基于准备好的dom，初始化echarts实例
                     var myChart = echarts.init(document.getElementById('main2'));
                     var  option = {
                    		title: {
                                   text: '体脂数据分析图表'
                               },
                            tooltip: {},
                            legend:{data:['体脂最好在0.8,在0.6~0.9之间正常']},
                    	    xAxis: {
                    	        name:'时间',
                    	    	type: 'category',
                    	        data: c
                    	    },
                    	    yAxis: {
                    	    	 name:'体脂率%',
                    	    	 type: 'value'
                    	    },
                    	    series: [{
                    	    	   itemStyle : {  
                                       normal : {  
                                           lineStyle:{  
                                               color:'#00FFBB'  
                                           }  
                                       }  
                                   },  
                    	         data: d,
                    	         type:'line'
                    	    }]
                    	}; 
                        myChart.setOption(option);               	
                 }
             	
             });
        	 //体重的变化
        	 $.ajax({
              	url:"${ctx}/physicalExamination/physicalExaminationAnysical",
              	type:"POST",
              	dataType:"json",
                 success:function(result){
           	   // alert(result.allPhysicalExamination.length);
             	/* for(var i=0;i<result.allPhysicalExamination.length;i++){	
             		 x.push(getDateTime(ConvertJSONDateToJSDate(result.allPhysicalExamination[i].physicalTime)));
             		 y.push(result.allPhysicalExamination[i].bloodPressure); 
                 	} */
                 	 $.each(result.allPhysicalExamination, function(index, item) {
                 		 e.push(getDateTime(ConvertJSONDateToJSDate(item.physicalTime)));
                 		 f.push(item.weight); 
         				});	
                 	
                 	// 基于准备好的dom，初始化echarts实例
                      var myChart = echarts.init(document.getElementById('main3'));
                      var  option = {
                     		title: {
                                    text: '体重数据分析图表'
                                },
                             tooltip: {},
                             legend:{data:['体重看情况']},
                     	    xAxis: {
                     	        name:'时间',
                     	    	type: 'category',
                     	        data: e
                     	    },
                     	    yAxis: {
                     	    	 name:'体重单位:kg',
                     	    	 type: 'value'
                     	    },
                     	    series: [{
                     	    	   itemStyle : {  
                                        normal : {  
                                            lineStyle:{  
                                                color:'#0FFFBB'  
                                            }  
                                        }  
                                    },  
                     	         data: f,
                     	         type:'line'
                     	    }]
                     	}; 
                         myChart.setOption(option);               	
                  }
              	
              });
        });
        
          
        //时间的转换  
        function getDateTime(date) {
			    var year = date.getFullYear();
			    var month = date.getMonth() + 1;
			    var day = date.getDate();
			    return year + "-" + month + "-" + day;
                }
      //调用的是这个方法
		function ConvertJSONDateToJSDate(jsondate) {
		    var date = new Date(parseInt(jsondate,10));
		    return date;
		}
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