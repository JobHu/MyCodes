package ycit.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ycit.dto.Page;
import ycit.mapper.IPhysicalExaminationMapper;
import ycit.pojo.PhysicalExamination;
import ycit.service.IPhysicalExaminationService;
@Service("physicalExaminationService")
public class PhysicalExaminationServiceImpl implements IPhysicalExaminationService{
	
	@Autowired
	private IPhysicalExaminationMapper physicalExaminationMapper;

	@Override
	public PageInfo<PhysicalExamination> queryAllPhysicalExamination(Page page) {
		//设置每页的大小和开始的页数
		/*if (page.getPageNum() == null) {
			page.setPageNum(1);
		}*/
		PageHelper.startPage(page.getPageNum(), 5);
		
		 List<PhysicalExamination> allPhysicalExamination = 
				 physicalExaminationMapper.queryAllPhysicalExamination(page);
		 PageInfo<PhysicalExamination>  pageInfo = new  PageInfo<>(allPhysicalExamination);
		 
		 return pageInfo;
	}

	@Override
	public boolean insertPhysicalExamination(PhysicalExamination physicalExamination) {
		if(physicalExamination != null){
			physicalExamination.setPhysicalTime(new Date());
		}
		int row = physicalExaminationMapper.insertPhysicalExamination(physicalExamination);
		return row==1?true:false;
	}

	@Override
	public boolean deletePhysicalExamination(Integer id) {
		
		int row = physicalExaminationMapper.deletePhysicalExamination(id);
		return row==1?true:false;
	}

	@Override
	public List<PhysicalExamination> queryExaminationByUserId(Integer id) {
		
		return physicalExaminationMapper.queryExaminationByUserId(id);
	}

}
