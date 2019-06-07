package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.mapper.IProblemCommentReplyMapper;
import ycit.pojo.ProblemCommentReply;
import ycit.service.IProblemCommentReplyService;
@Service("problemCommentReplyService")
public class ProblemCommentReplyServiceImpl implements IProblemCommentReplyService{

	@Autowired
	private IProblemCommentReplyMapper problemCommentReplyMapper;
	@Override
	public boolean insertProblemCommentReply(ProblemCommentReply problemCommentReply) {
		int row = problemCommentReplyMapper.insertProblemCommentReply(problemCommentReply);
		return row==1?true:false;
	}
	@Override
	public List<ProblemCommentReply> queryAllProblemCommentReply(Integer id) {
		
		return problemCommentReplyMapper.queryAllProblemCommentReply(id);
	}

}
