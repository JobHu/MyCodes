package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.mapper.IProblemCommentMapper;
import ycit.pojo.ProblemComment;
import ycit.service.IProblemCommentService;
@Service("problemCommentService")
public class ProblemCommentServiceImpl implements IProblemCommentService{

	@Autowired
	private IProblemCommentMapper problemCommentMapper;
	@Override
	public boolean insertProblemComment(ProblemComment problemComment) {
		int row = problemCommentMapper.insertProblemComment(problemComment);
		return row==1?true:false;
	}
	@Override
	public List<ProblemComment> queryAllProblemComment(Integer id) {
		
		return problemCommentMapper.queryAllProblemComment(id);
	}

}
