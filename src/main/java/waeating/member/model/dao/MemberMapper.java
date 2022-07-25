package waeating.member.model.dao;

import waeating.member.model.dto.MemberDTO;

public interface MemberMapper {

	String selectEncryptedPwd(MemberDTO requestMember);

	MemberDTO selectLoginAdmin(MemberDTO requestMember);

}
