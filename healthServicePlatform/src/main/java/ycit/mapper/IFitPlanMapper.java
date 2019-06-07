package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.FitPlan;

public interface IFitPlanMapper {

	List<FitPlan> queryFitPlan(@Param("uId")Integer userId);

	int insertFitPlan(FitPlan fitPlan);

	int deletePlan(@Param("id")Integer id);

	FitPlan selectFitPlanById(@Param("id")Integer id);

	int updateFitPlan(FitPlan fitPlan);

	List<FitPlan> queryFitPlanByMethodName(@Param("methodName")String methodName);
   
}