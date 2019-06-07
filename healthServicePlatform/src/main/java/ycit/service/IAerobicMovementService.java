package ycit.service;

import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.pojo.AerobicMovement;

public interface IAerobicMovementService {

	PageInfo<AerobicMovement> queryAerobicMovement(Page page);

	boolean insertAerobicMovement(AerobicMovement aerobicMovement);

	boolean deleteAerobicMovement(Integer id);

}
