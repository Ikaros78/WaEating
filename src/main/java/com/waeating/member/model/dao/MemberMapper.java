package com.waeating.member.model.dao;

import com.waeating.member.model.dto.MemberDTO;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;

public interface MemberMapper {

	String selectEncryptedPwd(MemberDTO requestMember);

	MemberDTO selectLoginAdmin(MemberDTO requestMember);

	int selectTotalCount(Map<String, String> searchMap);

	List<MemberDTO> selectMemberList(SelectCriteria selectCriteria);

	MemberDTO selectMemberDetail(Map<String, String> searchMap);

	int adminUpdateMember(Map<String, String> updateMemberMap);

	int adminUpdateUser(Map<String, String> updateUserMap);



}
