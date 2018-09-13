package com.briup.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShoppingCart;

//监听器类负责session对象的创建和销毁
//在类上面加上webListener注解
@WebListener
public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	
		//获得刚刚创建的session对象
		HttpSession session = se.getSession();
		//创建购物车对象
		ShoppingCart shoppingCart = new ShoppingCart();
		//将shoppingCart放入session中
		session.setAttribute("shoppingCart", shoppingCart);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		
	}
     
}
