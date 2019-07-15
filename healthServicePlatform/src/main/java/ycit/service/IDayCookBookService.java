package ycit.service;

import java.io.InputStream;

import com.github.pagehelper.PageInfo;

import ycit.pojo.DayCookBook;

//每日食谱的服务类
public interface IDayCookBookService {

	PageInfo<DayCookBook> queryAllCookBook(Integer pageNo);

	boolean insertCookBook(DayCookBook dayCookBook);

	PageInfo<DayCookBook> queryBookCookByHtmedType(String htmedType,Integer pageNo);

	InputStream getInputStream();

	boolean deleteDayCookBookById(Integer id);

}
