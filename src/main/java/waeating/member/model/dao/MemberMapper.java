package waeating.member.model.dao;

import java.util.List;
import java.util.Map;

import waeating.common.paging.SelectCriteria;
import waeating.member.model.dto.MemberDTO;

public interface MemberMapper {

	String selectEncryptedPwd(MemberDTO requestMember);

	MemberDTO selectLoginAdmin(MemberDTO requestMember);

	int selectTotalCount(Map<String, String> searchMap);

	List<MemberDTO> selectMemberList(SelectCriteria selectCriteria);

}
