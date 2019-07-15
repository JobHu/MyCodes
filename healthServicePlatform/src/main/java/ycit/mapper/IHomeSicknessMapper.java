package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.HomeSickness;

public interface IHomeSicknessMapper {

	List<HomeSickness> queryHomeSickness(@Param("userId")Integer id);

	int insertHomeSickness(HomeSickness homeSickness);

	boolean deleteHomeSickness(@Param("memberId")Integer id);

}