package ycit.service.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.mapper.IDayPressureMapper;
import ycit.pojo.DayPressure;
import ycit.service.IDayPressureService;
@Service("dayPressureService")
public class DayPressureServiceImpl implements IDayPressureService{

	@Autowired
	private IDayPressureMapper dayPressureMapper;
	
	@Override
	public boolean addDayBloodPressure(DayPressure dayPressure) {
		int row = dayPressureMapper.addDayBloodPressure(dayPressure);
		return row==1?true:false;
	}

	@Override
	public DayPressure queryDayBloodPressureByTime(Date newDayTime) {
		return dayPressureMapper.queryDayBloodPressureByTime(newDayTime);
	}

	@Override
	public DayPressure queryDayBloodPressureByAveragePressure(Double bloodPressureAverage) {
		return dayPressureMapper.queryDayBloodPressureByAveragePressure(bloodPressureAverage);
	}

	@Override
	public DayPressure queryDayBloodPressureByTag(Long tag) {
		return dayPressureMapper.queryDayBloodPressureByTag(tag);
	}

}
