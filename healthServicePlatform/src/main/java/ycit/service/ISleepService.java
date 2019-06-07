package ycit.service;

import java.util.List;

import ycit.dto.SleepAndFactorAndState;
import ycit.pojo.Sleep;

public interface ISleepService {

	List<Sleep> queryLastSevenDaySleep(Integer id);

	boolean addSleep(SleepAndFactorAndState sleepAndFactorAndState, Sleep sleep, Integer id, Integer fId);

	Sleep selectSleepByfId(Integer fId);

}
