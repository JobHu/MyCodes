package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.mapper.IFitMethodMapper;
import ycit.pojo.FitMethod;
import ycit.service.IFitMethodService;
@Service("fitMethodService")
public class FitMethodServiceImpl implements IFitMethodService{
	
	@Autowired
	private IFitMethodMapper fitMethodMapper;

	@Override
	public PageInfo<FitMethod> queryAllFitMethod(FitMethod fitMethod, Integer pageNo) {
		
		if(fitMethod == null){
			pageNo =1;
		}
		
		PageHelper.startPage(pageNo, 5);
		
	    List<FitMethod> fitMethods = fitMethodMapper.queryAllFitMethod(fitMethod);
	 
	    PageInfo<FitMethod> pageInfo = new PageInfo<>(fitMethods);
	
		return pageInfo;
	}

	@Override
	public boolean insertFitMethod(FitMethod fitMethod) {
		if (fitMethod != null) {
			
		int row =fitMethodMapper.insertFitMethod(fitMethod);
		return row==1?true:false;
		}
		return false;
	}

	@Override
	public FitMethod queryDetailById(Integer id) {
		return fitMethodMapper.queryDetailById(id);
	}

	@Override
	public List<FitMethod> queryAllMethod() {
		return fitMethodMapper.queryAllMethod();
	}

}
