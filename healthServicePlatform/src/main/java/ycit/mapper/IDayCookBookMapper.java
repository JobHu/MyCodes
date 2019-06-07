package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.DayCookBook;

public interface IDayCookBookMapper {

	List<DayCookBook> queryAllCookBook();

	int insertCookBook(DayCookBook dayCookBook);

	List<DayCookBook> queryBookCookByHtmedType(@Param("htmedType")String htmedType);

	int deleteDayCookBookById(@Param("id")Integer id);
   
}