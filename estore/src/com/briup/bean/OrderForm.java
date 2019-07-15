package com.briup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 订单类
 */
@Entity
@Table(name="tbl_orderform")
public class OrderForm implements Serializable{
	private static final long serialVersionUID = -8863320089820635760L;
	private Long id;
	private double cost;
	private Date orderdate;
	private Customer customer;
	private Collection<OrderLine> lines = new ArrayList<OrderLine>();
	
	public OrderForm() {}
	
	/*oracle数据的ID生产策略*/
//	@Id  
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_OrderForm")     
//	@SequenceGenerator(name="S_OrderForm",sequenceName="my_seq")
	
	/*mysql数据的ID生产策略*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	@OneToOne
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	public Collection<OrderLine> getLines() {
		return lines;
	}
	public void setLines(Collection<OrderLine> lines) {
		this.lines = lines;
	}
	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", cost=" + cost + ", orderdate=" + orderdate
				+ ", customer=" + customer + ", lines=" + lines + "]";
	}
}
