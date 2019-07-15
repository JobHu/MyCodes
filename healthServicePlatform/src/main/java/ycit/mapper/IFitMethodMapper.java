package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.FitMethod;

public interface IFitMethodMapper {

	List<FitMethod> queryAllFitMethod(FitMethod fitMethod);

	int insertFitMethod(FitMethod fitMethod);

	FitMethod queryDetailById(@Param("id")Integer id);

	List<FitMethod> queryAllMethod();
   
}