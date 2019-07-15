package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Book;
import com.briup.common.exception.OrderServiceException;
import com.briup.dao.BookDao;
import com.briup.service.IBookService;
//service层的实现类
@Service
public class BookServiceImpl implements IBookService {
	//注入bookDao，为了使用在service层使用bookDao进行数据查询
	//加入Spring的专用注解，交给Spring管理
@Autowired
	private BookDao bookDao;
	@Override
	//现在可以进行操作listAllBook来查询数据库中的书的信息
	public List<Book> listAllBook() throws OrderServiceException {
		//为什么要编写监听器，因为每个用户都需要使用book的信息
		//查完之后放在session中，每个用户都可以使用
		//编写一个监听器类，来监听application对象的创建和销毁
		   return  bookDao.findAll();
		
	}

	@Override
	public Book findBookById(long id) throws OrderServiceException {
		  
		   return bookDao.findById(id);
	}

}
