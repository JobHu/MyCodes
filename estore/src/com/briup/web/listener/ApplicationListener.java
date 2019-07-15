package com.briup.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.briup.bean.Book;
import com.briup.service.IBookService;

//当服务器启动时，将所有书籍信息load出来，存放在application范围
//注意此监听器需要配置在spring的监听器的后面
//因为此监听器需要用到spring容器,所以需要让spring先初始化,然后此监听器再初始化
public class ApplicationListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		try {
			// 获得application对象
			ServletContext application = sce.getServletContext();

			// 使用spring提供的WebApplicationContext获得spring容器对象
			WebApplicationContext container = WebApplicationContextUtils.getWebApplicationContext(application);

			// 从容器中获得要使用的service层接口的实现类
			IBookService bookService = container.getBean(IBookService.class);
			//
			List<Book> list = bookService.listAllBook();
			application.setAttribute("allBooks", list);
			//System.out.println("监听器中查询到的数据：" + list);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
