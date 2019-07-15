package com.briup.service;

import java.util.List;

import com.briup.bean.Book;
import com.briup.common.exception.OrderServiceException;
public interface IBookService {
	//查找所有书籍
	List<Book> listAllBook() throws OrderServiceException;
	//通过ID查找书籍
	Book findBookById(long id) throws OrderServiceException;
}
