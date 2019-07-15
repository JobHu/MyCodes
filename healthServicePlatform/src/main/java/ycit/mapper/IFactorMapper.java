package ycit.mapper;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.Factor;

public interface IFactorMapper {

	int addFactor(Factor factor);

	Factor selectFactorByName(@Param("name")String name);
    
}