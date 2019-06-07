package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.mapper.IAerobicMovementMapper;
import ycit.pojo.AerobicMovement;
import ycit.service.IAerobicMovementService;
@Service("aerobicMovementService")
public class AerobicMovementServiceImpl implements IAerobicMovementService{

	@Autowired
	private IAerobicMovementMapper aerobicMovementMapper;
	@Override
	public PageInfo<AerobicMovement> queryAerobicMovement(Page page) {
		PageHelper.startPage(page.getPageNum(), 10);
		List<AerobicMovement> list = aerobicMovementMapper.queryAerobicMovement(page.getUserId());
		PageInfo<AerobicMovement> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public boolean insertAerobicMovement(AerobicMovement aerobicMovement) {
		if (aerobicMovement != null) {
			int row = aerobicMovementMapper.insertAerobicMovement(aerobicMovement);
			return row==1?true:false;
		}
		return false;
	}
	@Override
	public boolean deleteAerobicMovement(Integer id) {
		int row = aerobicMovementMapper.deleteAerobicMovement(id);
		return row==1?true:false;
	}

}
