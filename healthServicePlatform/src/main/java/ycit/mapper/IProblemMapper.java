package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.Problem;

public interface IProblemMapper {

	int insertProblem(Problem problem);

	List<Problem> queryAllProblem();

	int updateThumbs(@Param("id")Integer id);
    
}