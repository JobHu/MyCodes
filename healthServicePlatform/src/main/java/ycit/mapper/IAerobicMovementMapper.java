package ycit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.AerobicMovement;

public interface IAerobicMovementMapper {

	List<AerobicMovement> queryAerobicMovement(@Param("userId")Integer userId);

	int insertAerobicMovement(AerobicMovement aerobicMovement);

	int deleteAerobicMovement(@Param("id")Integer id);
    
}