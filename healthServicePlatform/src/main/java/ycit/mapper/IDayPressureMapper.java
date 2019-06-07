package ycit.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.DayPressure;

public interface IDayPressureMapper {

	int addDayBloodPressure(DayPressure dayPressure);

	DayPressure queryDayBloodPressureByTime(@Param("newDayTime")Date newDayTime);

	DayPressure queryDayBloodPressureByAveragePressure(@Param("bloodPressureAverage")Double bloodPressureAverage);

	DayPressure queryDayBloodPressureByTag(@Param("tag")Long tag);
    
}