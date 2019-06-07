package ycit.service;

import ycit.dto.MemHomeSickness;
import ycit.pojo.Member;

public interface IMemberService {

	boolean insertMember(MemHomeSickness memHomeSickness, Member member);
	Member selectMemberByName(String memberName);
	boolean deleteMember(Integer id);

}
