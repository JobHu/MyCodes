package ycit.mapper;

import java.util.List;

import ycit.dto.HourPressureDTO;
import ycit.pojo.HourPressure;

public interface IHourPressureMapper {

	List<HourPressure> queryTwentyFourPressure(HourPressureDTO hourPressureDTO);

	int addHourBloodPressure(HourPressure hourPressure);
    
}