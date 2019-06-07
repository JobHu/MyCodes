package ycit.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ycit.dto.MemHomeSickness;
import ycit.mapper.IMemberMapper;
import ycit.pojo.Member;
import ycit.service.IMemberService;
@Service("memberService")
public class MemberServiceImpl implements IMemberService {
	@Autowired
	private IMemberMapper memberMapper;
	@Override
	public boolean insertMember(MemHomeSickness memHomeSickness, Member member) {
		if(memHomeSickness != null){
			member.setmName(memHomeSickness.getmName());
			member.setmRelation(memHomeSickness.getmRelation());
			member.setmSicknessCount(memHomeSickness.getmSicknessCount());
			member.setmStatus(memHomeSickness.getmStatus());
			member.setuId(memHomeSickness.getuId());
		  int row =	memberMapper.insertMember(member);
		  return row==1?true:false;
		}
		return false;
	}
	@Override
	public Member selectMemberByName(String memberName) {
		return memberMapper.queryMemberByName(memberName);
	}
	@Override
	public boolean deleteMember(Integer id) {
		
		return memberMapper.deleteMember(id);
	}

}
