package ycit.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.dto.Page;
import ycit.pojo.BloodSugar;

public interface IBloodSugarMapper {

	List<BloodSugar> queryAllBloodSugars(Page page);

	int addBloodSugar(BloodSugar bloodSugar);

	BloodSugar queryBloodSugarById(@Param("id")Integer id);

	int updateBloodSugar(BloodSugar bloodSugar);

	List<BloodSugar> queryBloodSugarByDayTime(@Param("date")Date date);
    
}