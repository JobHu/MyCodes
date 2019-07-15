<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<!--引入layui的css标签  -->
<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
<%-- <script type="text/javascript" src="${ctx}/static/plugins/jquery/jquery.js"> </script>--%>

<style type="text/css">
   form{
    width:300px;
    margin: auto;
    margin-top: 10%;
   }

</style>
</head>
<body>

	<div class="layui-container">
	         
		<form action="${ctx}/user/login" method="post" class="layui-form">
		      <div class="layui-form-item">
	              <h2 style="color: graytext;">健康信息服务平台登录页面</h2>
	           </div>
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<input type="text" name="usercode" required
						placeholder="请输入用户账户" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<input type="password" name="password" required 
					   placeholder="请输入密码" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<input type="text" name="confirmcode" 
						placeholder="请输入验证码(不区分大小写)" autocomplete="off" class="layui-input">
					<canvas id="canvas" width="100" height="43"></canvas>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
					<a href="${ctx}/jsp/register.jsp"><span style="color: red;">如果没有注册，请先点击注册!</span></a>
				</div>
			</div>
		</form>
	</div>
	<!-- js -->
	<script src="${ctx}/static/plugins/layui/layui.js"></script>
	<script>
	
	layui.use(['form','layer','jquery'], function() {
			var form = layui.form;
			var layer = layui.layer;
			var $ = layui.jquery;
			
				var msg = "${msg}";
				if(msg != ''){
					 layer.msg(msg, {icon: 5});
				}
			
				$(function(){
			        var show_num = [];
			        draw(show_num);

			        $("#canvas").on('click',function(){
			            draw(show_num);
			        })
			        $(".layui-btn").on('click',function(){
			            var val = $("input[name=confirmcode]").val().toLowerCase();
			            var num = show_num.join("");
			            if(val==''){
			               layer.msg('请输入验证码！');
			                $(".layui-input").val('');
			                draw(show_num);
			            }else if(val == num){
			                //$(".layui-input").val('');
			                draw(show_num);

			            }else{
			                layer.msg('验证码错误！请重新输入！');
			                $(".layui-input").val('');
			                draw(show_num);
			            }
			        })
			    })

			    function draw(show_num) {
			        var canvas_width=$('#canvas').width();
			        var canvas_height=$('#canvas').height();
			        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
			        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
			        canvas.width = canvas_width;
			        canvas.height = canvas_height;
			        var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
			        var aCode = sCode.split(",");
			        var aLength = aCode.length;//获取到数组的长度
			        
			        for (var i = 0; i <= 3; i++) {
			            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
			            var deg = Math.random() * 30 * Math.PI / 180;
			            var txt = aCode[j];//得到随机的一个内容
			            show_num[i] = txt.toLowerCase();
			            var x = 10 + i * 20;//文字在canvas上的x坐标
			            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
			            context.font = "bold 23px 微软雅黑";

			            context.translate(x, y);
			            context.rotate(deg);

			            context.fillStyle = randomColor();
			            context.fillText(txt, 0, 0);

			            context.rotate(-deg);
			            context.translate(-x, -y);
			        }
			        for (var i = 0; i <= 5; i++) { //验证码上显示线条
			            context.strokeStyle = randomColor();
			            context.beginPath();
			            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
			            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
			            context.stroke();
			        }
			        for (var i = 0; i <= 30; i++) { //验证码上显示小点
			            context.strokeStyle = randomColor();
			            context.beginPath();
			            var x = Math.random() * canvas_width;
			            var y = Math.random() * canvas_height;
			            context.moveTo(x, y);
			            context.lineTo(x + 1, y + 1);
			            context.stroke();
			        }
			    }

			    function randomColor() {//得到随机的颜色值
			        var r = Math.floor(Math.random() * 256);
			        var g = Math.floor(Math.random() * 256);
			        var b = Math.floor(Math.random() * 256);
			        return "rgb(" + r + "," + g + "," + b + ")";
			    }
			//监听提交
			/*  form.on('submit(formDemo)', function(data){
			   layer.msg(JSON.stringify(data.field));
			   return false;
			 }); */
		});
	</script>
</body>
</html>