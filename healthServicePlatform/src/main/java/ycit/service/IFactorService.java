package ycit.service;

import ycit.dto.SleepAndFactorAndState;
import ycit.pojo.Factor;

public interface IFactorService {

	boolean addFactor(SleepAndFactorAndState sleepAndFactorAndState, Factor factor);

	Factor selectFactorByName(String name);

}
