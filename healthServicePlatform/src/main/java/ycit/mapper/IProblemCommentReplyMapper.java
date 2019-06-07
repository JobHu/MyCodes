package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.ProblemCommentReply;

public interface IProblemCommentReplyMapper {

	int insertProblemCommentReply(ProblemCommentReply problemCommentReply);

	List<ProblemCommentReply> queryAllProblemCommentReply(@Param("id")Integer id);
   
}