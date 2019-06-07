package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.mapper.IAntiGroupMapper;
import ycit.pojo.AntiGroup;
import ycit.service.IAntiGroupService;
@Service("antiGroupService")
public class AntiGroupServiceImpl implements IAntiGroupService{

	
	@Autowired
	private IAntiGroupMapper antiGroupMapper;
	@Override
	public PageInfo<AntiGroup> queryAllAntiGroup(Page page) {
		PageHelper.startPage(page.getPageNum(), 10);
		List<AntiGroup> list = antiGroupMapper.queryAllAntiGroup(page.getUserId());
		PageInfo<AntiGroup> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public boolean insertAntiGroup(AntiGroup antiGroup) {
		
		if (antiGroup != null) {
			  int row = antiGroupMapper.insertAntiGroup(antiGroup);
			  return row==1?true:false;
		}
		return false;
	}
	@Override
	public boolean deleteAntiGroup(Integer id) {
        int row = antiGroupMapper.deleteAntiGroup(id);
		return row==1?true:false;
	}

}
