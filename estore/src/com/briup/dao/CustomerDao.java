package com.briup.dao;

import org.springframework.stereotype.Repository;

import com.briup.bean.Customer;
//加入Spring的专用注解Repository，这个类交给Spring管理
//Spring怎么知道dao层类和service层类加入了注解，看Spring的配置文件的头两行
@Repository
public class CustomerDao extends BaseDao<Customer>{
    //这里不需要写任何方法，方法已经从BaseDao中继承过来了
}
