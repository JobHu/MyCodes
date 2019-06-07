package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.mapper.IReducePressureMapper;
import ycit.pojo.ReducePressure;
import ycit.service.IReducePressureService;
@Service("reducePressureService")
public class ReducePressureServiceImpl implements IReducePressureService{

	
	@Autowired
	private IReducePressureMapper reducePressureMapper;
	@Override
	public PageInfo<ReducePressure> queryAllReducePressure(Integer pageNo) {
		PageHelper.startPage(pageNo, 5);
		List<ReducePressure> list = reducePressureMapper.queryAllReducePressure();
		PageInfo<ReducePressure> pageInfos = new PageInfo<>(list);
		return pageInfos;
	}
	@Override
	public boolean addReducePressure(ReducePressure reducePressure) {
		int row = reducePressureMapper.addReducePressure(reducePressure);
		return row==1?true:false;
	}
	@Override
	public boolean deleteReducePressure(Integer id) {
		int row = reducePressureMapper.deleteReducePressure(id);
		return row==1?true:false;
	}

}
