package ycit.service;

import com.github.pagehelper.PageInfo;

import ycit.pojo.ReducePressure;

public interface IReducePressureService {

	PageInfo<ReducePressure> queryAllReducePressure(Integer pageNo);

	boolean addReducePressure(ReducePressure reducePressure);

	boolean deleteReducePressure(Integer id);

}
