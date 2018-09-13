package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Customer;
import com.briup.common.exception.CustomerServiceException;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerService;

//加入Spring的专用注解Service
@Service
public class CustomerServiceImpl implements ICustomerService {
	// 声明一个Dao层的对象
	@Autowired
	private CustomerDao customerDao;

	@Override
	public void register(Customer customer) throws CustomerServiceException {
		String name = customer.getName();
		// 检查这个用户名在数据库中存在吗
		// 如果在数据库中查询：
		// 如果查到这个数据，说明这个用户名已经被占用,用户不能注册
		// 如果查不到，说明没有被占用，则可以注册

		// 注意的Customer是类名，name是属性名
		String hql = "from Customer c where c.name=?";
		List<Customer> list = customerDao.findByHql(hql, name);
		if (list == null || list.size() == 0) {
			// 不能查到数据的情况
			// 就可以注册
			customerDao.save(customer);
		} else {
			// 能查到数据
			// 不能注册，抛出异常，通知Action
			// 需要自己手动抛出异常,方法声明什么异常，就手动抛出异常，抛出异常的同时，还可以自己设置异常的信息
			throw new CustomerServiceException("用户名被占用");

		}

	}

	@Override
	public Customer login(String name, String password) throws CustomerServiceException {
		String hql = "from Customer c where c.name=?";
		List<Customer> list = customerDao.findByHql(hql, name);

		if (list == null || list.size() == 0 || !list.get(0).getPassword().equals(password)) {

			throw new CustomerServiceException("用户名或密码不正确");
		}
		// 如果用户名和密码都正确，则返回查到的customer对象
		return list.get(0);
	}

	@Override
	public void update(Customer customer) throws CustomerServiceException {

	}

}
