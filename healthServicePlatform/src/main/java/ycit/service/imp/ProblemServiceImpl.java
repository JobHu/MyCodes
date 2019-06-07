package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.mapper.IProblemMapper;
import ycit.pojo.Problem;
import ycit.service.IProblemService;
@Service("problemService")
public class ProblemServiceImpl implements IProblemService{

	@Autowired
	private IProblemMapper problemMapper;
	@Override
	public boolean insertProblem(Problem problem) {
		
		int row = problemMapper.insertProblem(problem);
		return row==1?true:false;
	}
	@Override
	public List<Problem> queryAllProblem() {
		
		return problemMapper.queryAllProblem();
	}
	@Override
	public boolean updateThumbs(Integer id) {
		int row = problemMapper.updateThumbs(id);
		return row==1?true:false;
	}

}
