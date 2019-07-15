package ycit.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.dto.SleepAndFactorAndState;
import ycit.mapper.IFactorMapper;
import ycit.pojo.Factor;
import ycit.service.IFactorService;
@Service("factorService")
public class FactorServiceImpl implements IFactorService{
	
	@Autowired
	private IFactorMapper factorMapper;
	

	@Override
	public boolean addFactor(SleepAndFactorAndState sleepAndFactorAndState, Factor factor) {
		if(sleepAndFactorAndState != null){
			
			factor.setName(sleepAndFactorAndState.getName());
			factor.setTime(sleepAndFactorAndState.getTime());
			
		}
		
		int row = factorMapper.addFactor(factor);
		return row==1?true:false;
	}


	@Override
	public Factor selectFactorByName(String name) {
		return factorMapper.selectFactorByName(name);
	}

}
