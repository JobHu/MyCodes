<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script type="text/javascript" src="js/jquery.js"></script>
<!-- 插入脚本 -->
<script type="text/javascript">

//jquery代码
//jquery是对js封装的一个库
   $(function(){
	   
	   //注意：这里的代码会在整个页面加载完之后运行
	   //给class="update"的超链接添加鼠标的点击事件
	   $(".update").on("click",function(){
		   
		   //这里面就是鼠标点击之后调用的代码
		   //$(this)代表被当前鼠标点击的超链接
		   //$(this)的父元素的父元素的父元素就是要提交的表单
		   $(this).parent().parent().parent().submit();
		   
		   //阻止超链接继续向下执行
		   return false;
		   
	   });
	   
   });


</script>

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
	<div class="peisong"><pre>我的购物车</pre></div>
	<div class="mainCenter">
		<div class="allCheck">
			<p class="leftM">商品</p>
			<p class="rightM">单价(元)</p>
			<p class="leftM">数量</p>
			<p class="leftM">小计(元)</p>
			<p class="leftM">操作</p>
		</div>
		<div class="mainPro">
			<div class="aa">
				<a href="list.jsp" style="margin-left: 18px">继续购物</a>
			</div>
			
			<c:forEach items="${shoppingCart.orderlines }" var="line">
			<div class="bb">
				<img src="images/1.png" >
				 <span>
                   ${line.book.name }
                    <br>
                </span>
                <div class="mm">
                	<span>${line.book.price }</span>
                </div>
                <form action="shoppingCartUpdate.action" method="post">
                <input type="text" value="${line.num }" name="num"/>
                <input type="hidden"  value="${line.book.id }" name="book_id" >
                
                <div class="ri">¥ ${line.book.price * line.num }元</div>
               	<div class="righ">
               		 <div class="rig"><a href="shoppingCartDelete.action?book_id=${line.book.id }">删除</a></div>
               		 <div class="rig"><a href="#" class="update">修改</a></div>
               	</div>
                </form>
			</div>
			</c:forEach>
			
				
		</div>
		<div class="allButtom">
			<a href="confirm.jsp">
			<p class="caozuo">去结算</p>
			</a>
			<span>已选择<font>${shoppingCart.size }</font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：<font>¥ ${shoppingCart.cost }元</font></span>
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
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
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