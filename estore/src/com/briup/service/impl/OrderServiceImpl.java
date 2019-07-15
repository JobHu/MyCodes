package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.OrderForm;
import com.briup.common.exception.OrderServiceException;
import com.briup.dao.OrderDao;
import com.briup.service.IOrderService;
 @Service
public class OrderServiceImpl implements IOrderService {
	 
	@Autowired
	private OrderDao orderDao;

	@Override
	public void saveOrder(OrderForm order) throws OrderServiceException {
		 orderDao.save(order);
		
	}

	@Override
	public void delOrder(Long orderid) throws OrderServiceException {
		orderDao.delete(orderid);
	}

	@Override
	public List<OrderForm> listAllOrder(Long customerid) throws OrderServiceException {
		  
		
		String hql ="from OrderForm o where o.customer.id=?";
		 return orderDao.findByHql(hql,customerid);
		
	}

	@Override
	public OrderForm findOrderById(Long orderid) throws OrderServiceException {
		
		   return orderDao.findById(orderid);
	}

}
