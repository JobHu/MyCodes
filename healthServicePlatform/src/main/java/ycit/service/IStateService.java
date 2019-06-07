package ycit.service;

import ycit.dto.SleepAndFactorAndState;
import ycit.pojo.State;

public interface IStateService {

	boolean addState(SleepAndFactorAndState sleepAndFactorAndState, Integer sleepId,State state);

}
