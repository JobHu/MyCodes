package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.dto.HourPressureDTO;
import ycit.excel.HourBloodPressure;
import ycit.mapper.IHourPressureMapper;
import ycit.pojo.HourPressure;
import ycit.service.IHourPressureService;
@Service("hourPressureService")
public class HourPressureServiceImpl implements IHourPressureService{
	
	@Autowired
	private IHourPressureMapper hourPressureMapper;

	@Override
	public List<HourPressure> queryTwentyFourPressure(HourPressureDTO hourPressureDTO) {
		
		if(hourPressureDTO != null){
			
			return hourPressureMapper.queryTwentyFourPressure(hourPressureDTO);
		}
		
		return null;
	}

	@Override
	public boolean addHourBloodPressure(HourPressure hourPressure) {
		int row = hourPressureMapper.addHourBloodPressure(hourPressure);
		return row==1?true:false;
	}

}
