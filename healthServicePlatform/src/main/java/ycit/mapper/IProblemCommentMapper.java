package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.ProblemComment;

public interface IProblemCommentMapper {

	int insertProblemComment(ProblemComment problemComment);

	List<ProblemComment> queryAllProblemComment(@Param("id")Integer id);
    
}