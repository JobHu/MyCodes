package com.briup.bean;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
	private Map<Long,OrderLine> cart = new TreeMap<Long,OrderLine>();
	
	//增加Orderline
	public void addLine(OrderLine line) {
		OrderLine orderline = cart.get(line.getBook().getId());
		if(orderline != null){
			orderline.setNum(orderline.getNum()+line.getNum());
		}
		else{
			cart.put(line.getBook().getId(), line);
		}
		
	}
	
	//删除Orderline
	public void dropLine(Long book_id) {
		cart.remove(book_id);
	}
	
	//获得单个Orderline
	public OrderLine getOrderline(Long book_id){
		return cart.get(book_id);
	}
	
	//更新某个Orderline的数量
	public void updateOrderline(Long book_id,int num){
		OrderLine orderLine = cart.get(book_id);
		if(orderLine!=null){
			orderLine.setNum(num);
		}
	}
	
	//获得所有Orderline
	public Collection<OrderLine> getOrderlines() {
		return cart.values();
	}
	
	//获得购物车总价
	public double getCost() {
		double cost = 0.0;
		Collection<OrderLine> c = getOrderlines();
		for(OrderLine orderline : c){
			cost += orderline.getBook().getPrice() * orderline.getNum();
		}
		return cost;
	}
	
	//清空购物车
	public void removeAll() {
		cart.clear();
	}
	
	//判断购物车是否为空
	public boolean isEmpty(){
		return cart.isEmpty();
	}
	
	public int getSize(){
		return cart.size();
 	}
}