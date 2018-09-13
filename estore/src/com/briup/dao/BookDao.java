package com.briup.dao;

import org.springframework.stereotype.Repository;

import com.briup.bean.Book;
//加上Spring的注解，交给Spring管理
@Repository
public class BookDao extends BaseDao<Book> {
	//这里不需要写任何的东西，来自于继承
}
