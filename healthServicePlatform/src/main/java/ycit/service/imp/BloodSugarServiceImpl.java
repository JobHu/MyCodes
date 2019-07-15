package ycit.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.mapper.IBloodSugarMapper;
import ycit.pojo.BloodSugar;
import ycit.service.IBloodSugarService;
@Service("bloodSugarService")
public class BloodSugarServiceImpl implements IBloodSugarService{

	@Autowired
	private IBloodSugarMapper bloodSugarMapper;
	@Override
	public PageInfo<BloodSugar> queryAllBloodSugars(Page page) {
		if(page != null){
			PageHelper.startPage(page.getPageNum(), 5);
		List<BloodSugar> allBloodSugars = bloodSugarMapper.queryAllBloodSugars(page);
		PageInfo<BloodSugar> pageInfo = new PageInfo<>(allBloodSugars);
		return pageInfo;
		}
		return null;
	}
	@Override
	public boolean addBloodSugar(BloodSugar bloodSugar) {
		if (bloodSugar != null) {
			int row =  bloodSugarMapper.addBloodSugar(bloodSugar);
			return row==1?true:false;
		}
		return false;
	}
	@Override
	public BloodSugar queryBloodSugarById(Integer id) {
		return bloodSugarMapper.queryBloodSugarById(id);
	}
	@Override
	public boolean updateBloodSugar(BloodSugar bloodSugar) {
		int row = bloodSugarMapper.updateBloodSugar(bloodSugar);
		return row==1?true:false ;
	}
	@Override
	public List<BloodSugar> queryBloodSugarByDayTime(Date date) {
		return bloodSugarMapper.queryBloodSugarByDayTime(date);
	}

}
