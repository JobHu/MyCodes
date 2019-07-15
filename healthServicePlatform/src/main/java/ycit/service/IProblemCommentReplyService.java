package ycit.service;

import java.util.List;

import ycit.pojo.ProblemCommentReply;

public interface IProblemCommentReplyService {

	boolean insertProblemCommentReply(ProblemCommentReply problemCommentReply);

	List<ProblemCommentReply> queryAllProblemCommentReply(Integer id);

}
