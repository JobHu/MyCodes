package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.AntiGroup;

public interface IAntiGroupMapper {

	List<AntiGroup> queryAllAntiGroup(@Param("userId")Integer userId);

	int insertAntiGroup(AntiGroup antiGroup);

	int deleteAntiGroup(@Param("id")Integer id);
   
}