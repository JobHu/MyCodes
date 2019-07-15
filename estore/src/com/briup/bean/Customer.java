package com.briup.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 用户类
 */
@Entity
@Table(name="tbl_customer")
public class Customer implements Serializable{
	private static final long serialVersionUID = -1415977267636644567L;
	private Long id;
	private String name;
	private String password;
	private String zip;
	private String address;
	private String telephone;
	private String email;
	
	public Customer() {}
	
	/*oracle数据的ID生产策略*/
//	@Id  
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_Customer")     
//	@SequenceGenerator(name="S_Customer",sequenceName="my_seq")
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zip=" + zip + ", address="
				+ address + ", telephone=" + telephone + ", email=" + email + "]";
	}
	
}
