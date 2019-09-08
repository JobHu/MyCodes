<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-注册页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />

<!-- 页面中嵌入javaScript脚本代码 -->
<script type="text/javascript">
//EL表达式 ,EL表达式可以写在页面中的任何位置
//var是java script 中声明一个变量 
var message="${message}";
if(message){
	//如果变量不为空，弹出个框（alert())
	alert(message);
}
</script>
</head>
<body>
	<div class="container2">
    	<div class="header2">
        	<div>
            	<a href="#"><img class="logo" src="images/logon_register.png"></a>
            </div>
            <div>
            	<ul class="tabs">
                	<li class="current"><a href="#">用户注册</a></li>
                </ul>
            </div>
            <div class="tlg">
            	已有账号 <a href="login.jsp">登陆</a>
            </div>
        </div>
        <form action="register.action" method="post">
        <div class="content2">
			<ul class="reg_box">
            	<li>
                	<span><b>*</b>用户名：</span>
                    <input type="text" name="name"/>
                </li>
               <li>
                	<span><b>*</b>密码：</span>
                    <input type="password" name="password"/>
                </li>
                <li>
                	<span><b>*</b>邮编：</span>
                    <input type="text" name="zip"/>
                </li>
                <li>
                	<span><b>*</b>地址：</span>
                    <input type="text" name="address"/>
                </li>
                <li>
                	<span><b>*</b>电话：</span>
                    <input type="text" name="telephone"/>
                </li>
                <li>
                	<span><b>*</b>电子邮箱：</span>
                    <input type="text" name="email"/>
                </li>
            </ul>
			<p>
            	<input type="checkbox" checked/>
                我已阅读并同意
                <a href="#">用户注册协议</a>
            </p>
            <input class="btn_submit" type="submit" value="立即注册"/>
        </div>
        </form>  
   	</div>
</body>
</html>
    