package com.briup.web.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCart;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IBookService;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IBookService bookService;

	private long book_id;
	
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private Map<String, Object> session;

	public long getBook_id() {
		return book_id;
	}

	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}

	// shoppingCartAdd.action
	@Action(value = "/shoppingCartAdd", results = { @Result(name = "success", location = "/shopcart.jsp") })
	public String shoppingCartAdd() {

		try {
			Book book = bookService.findBookById(book_id);
			ShoppingCart shoppingCart = (ShoppingCart) session.get("shoppingCart");
			OrderLine line = new OrderLine();
			line.setBook(book);
			line.setNum(1);
			// 把订单明细对象放入到购物车
			shoppingCart.addLine(line);
		} catch (OrderServiceException e){

			e.printStackTrace();
		}
		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	// shoppingCartDelete.action
	@Action(value = "/shoppingCartDelete", results = { @Result(name = "success", location = "/shopcart.jsp") })
	public String shoppingCartDelete() {
		// 从session中获取shoppingCart放在shoppingCart中
		ShoppingCart shoppingCart = (ShoppingCart) session.get("shoppingCart");
		shoppingCart.dropLine(book_id);

		return SUCCESS;

	}

	// shoppingCartUpdate.action
	@Action(value = "/shoppingCartUpdate", results = { @Result(name = "success", location = "/shopcart.jsp") })
	public String shoppingCartUpdate() {

		ShoppingCart shoppingCart = (ShoppingCart) session.get("shoppingCart");
		shoppingCart.updateOrderline(book_id, num);

		return SUCCESS;

	}

}
