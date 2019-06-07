package ycit.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.BloodSugar;

public interface IBloodSugarService {

	PageInfo<BloodSugar> queryAllBloodSugars(Page page);

	boolean addBloodSugar(BloodSugar bloodSugar);

	BloodSugar queryBloodSugarById(Integer id);

	boolean updateBloodSugar(BloodSugar bloodSugar);

	List<BloodSugar> queryBloodSugarByDayTime(Date date);

}
