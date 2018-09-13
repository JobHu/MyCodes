package com.briup.web.action;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCart;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IOrderService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	@Autowired
	private IOrderService  orderService;

	private List<OrderForm> allOrders;
	private  Long  order_id;
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public List<OrderForm> getAllOrders() {
		return allOrders;
	}
	public void setAllOrders(List<OrderForm> allOrders) {
		this.allOrders = allOrders;
	}

	@Action(value="/orderSubmit",results={@Result(name="success",location="/order.jsp"),
	})
	public String orderSubmit(){
		
		   Customer customer = (Customer) session.get("customer");
		   ShoppingCart shoppingCart = (ShoppingCart) session.get("shoppingCart");
		   
		   OrderForm orderForm = new OrderForm();
		   double cost = shoppingCart.getCost();
		   Collection<OrderLine> orderlines = shoppingCart.getOrderlines();
		   orderForm.setCost(cost);
		   orderForm .setOrderdate(new Date());
		   orderForm .setCustomer(customer);
		   orderForm.setLines(orderlines);
		      
		   
		   try {
			    orderService.saveOrder(orderForm);
			
			   allOrders = orderService.listAllOrder(customer.getId());
			
		} catch (OrderServiceException e) {
		
			e.printStackTrace();
		}
		  return SUCCESS;
		
	}
	
	@Action(value="/orderDelete",results={@Result(name="success",location="/order.jsp"),
	})
	public String orderDelete(){

		   Customer customer = (Customer) session.get("customer");
		
		try {
			orderService.delOrder(order_id);
			allOrders = orderService.listAllOrder(customer.getId());
			
			
			
		} catch (OrderServiceException e) {
			
			e.printStackTrace();
		}
		
		return SUCCESS;
		
	}
	
	@Action(value="/orderLines",results={@Result(name="success",location="/orderlines.jsp"),
	})
	public String orderLineFind(){
		
		try {
			OrderForm order = orderService.findOrderById(order_id);
			session.put("order", order);
		} catch (OrderServiceException e) {
			
			e.printStackTrace();
		}
		
		
		return SUCCESS;
		
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
}
