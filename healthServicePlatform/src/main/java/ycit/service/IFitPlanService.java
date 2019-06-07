package ycit.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.FitPlan;

public interface IFitPlanService {

	PageInfo<FitPlan> queryFitPlan(Page page);

	boolean insertFitPlan(FitPlan fitPlan);

	boolean deleteFitPlan(Integer id);

	FitPlan selectFitPlanById(Integer id);

	boolean updateFitPlan(FitPlan fitPlan);

	List<FitPlan> queryFitPlanByMethodName(String methodName);

}
