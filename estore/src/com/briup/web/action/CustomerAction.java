package com.briup.web.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String zip;
	private String address;
	private String telephone;
	private String email;
	// 接口是不能直接使用的，需要有接口的实现类，Spring控制反转，依赖注入，空指针
	// 在需要注入的属性上面加入Spring的专用注解@Autowired
	@Autowired
	private ICustomerService customerService;
	private String message;
	private Map<String, Object> session;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// register.action
	@Action(value = "/register", results = { @Result(name = "success", location = "/login.jsp"),
			@Result(name = "error", location = "/register.jsp") })
	public String register() {
		// 封装成对象
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setZip(zip);
		customer.setAddress(address);
		customer.setTelephone(telephone);
		customer.setEmail(email);

		// 把封装好的对象交给service业务层处理
		try {
			customerService.register(customer);
		} catch (CustomerServiceException e) {
			message = "很遗憾，注册失败：" + e.getMessage();
			e.printStackTrace();
			return ERROR;
		}

		// String com.opensymphony.xwork2.Action.ERROR : "error"
		message = "恭喜你，注册成功";
		return SUCCESS;

	}
     //login.action
	@Action(value = "/login", results = { @Result(name = "success", location = "/index.jsp"),
			@Result(name = "error", location = "/login.jsp") })
	public String login() {
		try {
			Customer customer = customerService.login(name, password);
			//把当前的customer对象放在session中
			session.put("customer", customer);
		} catch (CustomerServiceException e) {
			//登录失败
			message = "很遗憾，登录失败：" + e.getMessage();
			e.printStackTrace();
			return ERROR;
		}
		//登录成功，将返回的customer对象放在session中
		//怎么区分登录状态和非登录状态，根据session中是否有customer对象
		message="登录成功";
		return SUCCESS;

	}

	
	//如果当前Action类实现了SessionAware接口
	//那么struts2框架会自动的调用setSession方法
	//这个session的类型是Map,与servlet中的HttpSession的session一样
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
