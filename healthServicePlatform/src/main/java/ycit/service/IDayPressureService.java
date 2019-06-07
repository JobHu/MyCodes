package ycit.service;

import java.util.Date;

import ycit.pojo.DayPressure;

public interface IDayPressureService {

	boolean addDayBloodPressure(DayPressure dayPressure);

	DayPressure queryDayBloodPressureByTime(Date newDayTime);

	DayPressure queryDayBloodPressureByAveragePressure(Double bloodPressureAverage);

	DayPressure queryDayBloodPressureByTag(Long tag);

}
