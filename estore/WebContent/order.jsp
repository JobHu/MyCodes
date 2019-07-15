<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>购物车页面</title>
<link rel="stylesheet" href="css/fullCar.css" />
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />

<style>
	.orderlist_title{
		text-align: center;
		font-size: large;
		font-weight:bolder;
		background-color: #f4f4f4;
		width: 80%;
		margin: 0 auto;
	}
	
	.orderlist_container{
		text-align: center;
		background-color: #f4f4f4;
		width: 80%;
		margin: 10px auto;
	}
	
	.orderlist_header div{
		font-weight: bold;
		text-align: center;
		float: left;
		margin-left: 170px;
	}
	
	.orderlist_content{
		width: 100%;
		padding: 0px;
		margin: 0px;
	}
	
	.orderlist_content div{
		font-weight: bold;
		text-align: center;
		float: left;
		margin-left: 175px;
	}
	
</style>

</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
            <ul class="top_bars">
            	<li><a href="#">退出</a>|</li>
                <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="#"><img src="images/logo.png"  class="oneImg"></a>
        <div class="h3_right">
        	<img src="images/play_03.png" alt="">
        </div>
       
    </div>
    
<!--中间部分div-->
<div class="empty">
	
	<div class="orderlist_title">订单列表</div>
	<div class="orderlist_container">
		<div class="orderlist_header">
            <div>订单时间</div>
            <div>订单金额</div>
            <div>订单时间</div>
            <div>操作</div>
		</div>
	<c:forEach items="${allOrders }" var="order">
	<div class="orderlist_content">
			<div style="margin-left: 195px">${order.id }</div>
			<div>${order.cost }</div>
			<div><fmt:formatDate value="${order.orderdate }" pattern="yyyy-MM-dd"></fmt:formatDate></div>
			<div style="margin-left: 150px">
				<a href="orderDelete.action?order_id=${order.id }">删除</a>
				<a href="orderLines.action?order_id=${order.id }">明细</a>
			</div>
		</div>
	</c:forEach>
		
		
	</div>
	
</div>
     <!--脚部-->
    <div class="footer3">
    	<div class="f3_top">
        	<div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
        	<ul class="f3_center">
            	<li class="f3_mi_li01">
                	<h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                	<h1>客服中心</h1>
                    <img src="images/QRCodes.png">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
         <div class="f3_bottom">
        	<p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a> 
           	</p>
            <p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>
</body>
</html>