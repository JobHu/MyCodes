package ycit.service;

import java.util.List;

import ycit.dto.HourPressureDTO;
import ycit.pojo.HourPressure;

public interface IHourPressureService {

	List<HourPressure> queryTwentyFourPressure(HourPressureDTO hourPressureDTO);

	boolean addHourBloodPressure(HourPressure hourPressure);

}
