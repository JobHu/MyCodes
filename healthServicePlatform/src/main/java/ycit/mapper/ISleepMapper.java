package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.Sleep;

public interface ISleepMapper {

	List<Sleep> queryLastSevenDaySleep(@Param("userId")Integer id);

	int addSleep(Sleep sleep);

	Sleep selectSleepByfId(@Param("fId")Integer fId);
    
}