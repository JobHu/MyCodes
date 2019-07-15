<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>结算页面</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="css/orderSure.css" />
<style type="text/css">
 .adres{
 	list-style: none;
 	height: 50px;
 	padding: 20px;
 }
 .adres input{
 	width: 30px;
 	height: 10px;
 }
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
            <ul class="top_bars">
            	<li><a href="#">退出</a>|</li>
                <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
            	<li><a href="login.jsp" style="color:red;">请登录</a>|</li>	
            	<li><a href="register.jsp" style="color:red;">请注册</a>|</li>
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
	<p class="orderButtom">订单明细</p>
    <!--中间部分-->
    <div class="content">
    	<div class="contentCenter">
    	<div class="centerTop">
   			<b style="font-size:20px;">收货人信息</b>
   			<p style="font-size:15px;">
				收件人姓名：<input type="text" value="${customer.name }" name="name" disabled="disabled"><br/><br/>
				收件人地址：<input type="text" value="${customer.address  }" name="address" disabled="disabled"><br/><br/>
				收件人电话：<input type="text" value="${customer.telephone }" name="tel" disabled="disabled">
			</p>
   		</div>
   			<p class="singleP"><span style="float: left;padding-left: 550px; "><a href="index.jsp">返回</a></span></p>
    		<div class="bigDiv">
    			<div class="twoDiv">
					<ul class="oneUL">
					<c:forEach items="${order.lines}" var="line">
    					<li>
    						<img src="images/viewBook.png" class="pic">
    						<p>&nbsp;&nbsp;${line.book.name }&nbsp;&nbsp;</p>
    						<p><font>¥ ${line.book.price }</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;× ${line.num }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有货</p>
    						<p><img src="images/sureLogo_14.png" alt=""><span>七天无理由退换货</span></p>

    					</li>
					</c:forEach>
					</ul>

    			</div>
    		</div>
	
    		<div class="money">
    			<span><font>${shoppingCart.size}</font>件商品，总商品金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥<font>${shoppingCart.cost }</font></span>
    		</div>
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