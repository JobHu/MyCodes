package ycit.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.dto.SleepAndFactorAndState;
import ycit.mapper.ISleepMapper;
import ycit.pojo.Sleep;
import ycit.service.ISleepService;

@Service("sleepService")
public class SleepServiceImpl implements ISleepService{

	@Autowired
	private ISleepMapper sleepMapper;
	@Override
	public List<Sleep> queryLastSevenDaySleep(Integer id) {
		return sleepMapper.queryLastSevenDaySleep(id);
	}
	@Override
	public boolean addSleep(SleepAndFactorAndState sleepAndFactorAndState, Sleep sleep, Integer id, Integer fId) {
		if(sleepAndFactorAndState != null){
			sleep.setLastTime(new Date());
			sleep.setfId(fId);
			sleep.setuId(id);
			sleep.setSleepTime(sleepAndFactorAndState.getSleepTime());
			sleep.setSleepQuantity(sleepAndFactorAndState.getSleepQuantity());
		}
		int row = sleepMapper.addSleep(sleep);
		return row==1?true:false;
	}
	@Override
	public Sleep selectSleepByfId(Integer fId) {
		return sleepMapper.selectSleepByfId(fId);
	}

}
