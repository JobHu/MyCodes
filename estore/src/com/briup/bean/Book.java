package com.briup.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 书籍类
 */
@Entity
@Table(name="tbl_book")
public class Book implements Serializable{
	private static final long serialVersionUID = -368818489154570669L;
	
	private Long id;
	private String name;
	private double price;
	
	public Book() {}
	
	/*oracle数据的ID生产策略*/
//	@Id  
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_Book")     
//	@SequenceGenerator(name="S_Book",sequenceName="my_seq")
	/*mysql数据的ID生产策略*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
