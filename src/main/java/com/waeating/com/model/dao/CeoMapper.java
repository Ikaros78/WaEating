package com.waeating.com.model.dao;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dto.MemberDTO;

public interface CeoMapper {

	/* 업주 로그인 */
	int insertMember(MemberDTO requestMember);

	int insertComInfo(ComInfoDTO requestCom);

	int dubleCkId(String ceoId);

	String selectEncryptedPwd(MemberDTO requestMember);

	ComInfoDTO selectMemberLogin(MemberDTO requestMember);

	int insertComRecord(int comNo);

	ComInfoDTO selectFindIdForPhone(ComInfoDTO requestCom);

	ComInfoDTO checkFindPwdForPhone(ComInfoDTO requestCom);

	int updateNewPwd(ComInfoDTO requestCom);


}
