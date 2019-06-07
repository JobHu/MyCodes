package ycit.service;



import java.util.List;

import com.github.pagehelper.PageInfo;

import ycit.pojo.FitMethod;

public interface IFitMethodService {

	PageInfo<FitMethod> queryAllFitMethod(FitMethod fitMethod, Integer pageNo);

	boolean insertFitMethod(FitMethod fitMethod);

	FitMethod queryDetailById(Integer id);

	List<FitMethod> queryAllMethod();

}
