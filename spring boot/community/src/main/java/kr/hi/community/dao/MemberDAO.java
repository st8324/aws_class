package kr.hi.community.dao;

import org.apache.ibatis.annotations.Param;

import kr.hi.community.model.dto.MemberDTO;

public interface MemberDAO {

	String selectMember(@Param("id")String id);

	boolean insertMember(@Param("obj")MemberDTO member);

}
