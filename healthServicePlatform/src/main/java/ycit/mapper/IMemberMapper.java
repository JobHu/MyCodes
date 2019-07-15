package ycit.mapper;

import org.apache.ibatis.annotations.Param;

import ycit.pojo.Member;

public interface IMemberMapper {

	int insertMember(Member member);

	Member queryMemberByName(@Param("memberName")String memberName);

	boolean deleteMember(@Param("memberId")Integer id);
   
}