package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.ReducePressure;

public interface IReducePressureMapper {

	List<ReducePressure> queryAllReducePressure();

	int addReducePressure(ReducePressure reducePressure);

	int deleteReducePressure(@Param("id")Integer id);
    
}