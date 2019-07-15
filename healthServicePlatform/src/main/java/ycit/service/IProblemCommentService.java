package ycit.service;

import java.util.List;

import ycit.pojo.ProblemComment;

public interface IProblemCommentService {

	boolean insertProblemComment(ProblemComment problemComment);

	List<ProblemComment> queryAllProblemComment(Integer id);

}
