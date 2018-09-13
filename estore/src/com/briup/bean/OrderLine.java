package com.briup.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 订单明细类
 */
@Entity
@Table(name="tbl_orderline")
public class OrderLine implements Serializable{
	private static final long serialVersionUID = -7460852488675734125L;
	private Long id;
	private int num;
	private Book book;
	
	public OrderLine() {}
	
	
	/*oracle数据的ID生产策略*/
//	@Id  
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_OrderLine")     
//	@SequenceGenerator(name="S_OrderLine",sequenceName="my_seq")
	
	/*mysql数据的ID生产策略*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@OneToOne
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", book=" + book + "]";
	}
}
