package ycit.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.dto.MemHomeSickness;
import ycit.mapper.IHomeSicknessMapper;
import ycit.pojo.HomeSickness;
import ycit.pojo.Member;
import ycit.service.IHomeSicknessService;
@Service("homeSicknessService")
public class HomeSicknessServiceImpl implements IHomeSicknessService{

	
	@Autowired
	private IHomeSicknessMapper homeSicknessMapper;

	@Override
	public List<HomeSickness> queryHomeSickness(Integer id) {
		return homeSicknessMapper.queryHomeSickness(id);
	}
	@Override
	public boolean insertHomeSickness(MemHomeSickness memHomeSickness,HomeSickness homeSickness,Member member) {
		
		if (memHomeSickness != null) {
			homeSickness.setSicknessName(memHomeSickness.getSicknessName());
			homeSickness.setSicknessType(memHomeSickness.getSicknessType());
			homeSickness.setSicknessInheritance(memHomeSickness.getSicknessInheritance());
			homeSickness.setSicknessTreat(memHomeSickness.getSicknessTreat());
			homeSickness.setSicknessAttack(memHomeSickness.getSicknessAttack());
			homeSickness.setMemberId(member.getId());
		int row =homeSicknessMapper.insertHomeSickness(homeSickness);
		return row==1?true:false;
		}else{
			return false;
		}	
	}
	@Override
	public boolean deleteHomeSickness(Integer id) {
		
		return homeSicknessMapper.deleteHomeSickness(id);
	}

}
