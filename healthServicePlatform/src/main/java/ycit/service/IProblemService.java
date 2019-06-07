package ycit.service;

import java.util.List;

import ycit.pojo.Problem;

public interface IProblemService {

	boolean insertProblem(Problem problem);

	List<Problem> queryAllProblem();

	boolean updateThumbs(Integer id);

}
