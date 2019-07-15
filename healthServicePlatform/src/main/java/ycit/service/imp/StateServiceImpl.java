package ycit.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.dto.SleepAndFactorAndState;
import ycit.mapper.IStateMapper;
import ycit.pojo.State;
import ycit.service.IStateService;
@Service("stateService")
public class StateServiceImpl implements IStateService{
	
	@Autowired
	private IStateMapper stateMapper;

	@Override
	public boolean addState(SleepAndFactorAndState sleepAndFactorAndState, Integer sleepId,State state) {
		
		if(sleepAndFactorAndState != null){
			state.setSleepId(sleepId);
			state.setAppetite(sleepAndFactorAndState.getAppetite());
			state.setAttention(sleepAndFactorAndState.getAttention());
			state.setBodyState(sleepAndFactorAndState.getBodyState());
			state.setMood(sleepAndFactorAndState.getMood());
			state.setWorkState(sleepAndFactorAndState.getWorkState());
		    int row = stateMapper.addState(state);
		    return row==1?true:false;
		}
		return false;
		
	}

}
