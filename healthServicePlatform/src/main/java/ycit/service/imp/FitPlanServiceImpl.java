package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.mapper.IFitPlanMapper;
import ycit.pojo.FitPlan;
import ycit.service.IFitPlanService;
@Service("fitPlanService")
public class FitPlanServiceImpl implements IFitPlanService{

	
	@Autowired
	private IFitPlanMapper fitPlanMapper;
	@Override
	public PageInfo<FitPlan> queryFitPlan(Page page) {
		
	   PageHelper.startPage(page.getPageNum(), 5);
	   List<FitPlan> fitPlans = fitPlanMapper.queryFitPlan(page.getUserId());
	   PageInfo<FitPlan> pageInfo = new PageInfo<>(fitPlans);
		return pageInfo;
	}
	@Override
	public boolean insertFitPlan(FitPlan fitPlan) {
		if (fitPlan != null) {
			int row = fitPlanMapper.insertFitPlan(fitPlan);
			return row==1?true:false;
		}
		return false;
	}
	@Override
	public boolean deleteFitPlan(Integer id) {
		int row = fitPlanMapper.deletePlan(id);
		return row==1?true:false;
	}
	@Override
	public FitPlan selectFitPlanById(Integer id) {
		return fitPlanMapper.selectFitPlanById(id);
	}
	@Override
	public boolean updateFitPlan(FitPlan fitPlan) {
		int row = fitPlanMapper.updateFitPlan(fitPlan);
		return row==1?true:false;
	}
	@Override
	public List<FitPlan> queryFitPlanByMethodName(String methodName) {
		
		return fitPlanMapper.queryFitPlanByMethodName(methodName);
	}

}
