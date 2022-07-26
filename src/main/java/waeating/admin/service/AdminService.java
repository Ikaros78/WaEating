package waeating.admin.service;

import static waeating.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import waeating.member.model.dao.MemberMapper;
import waeating.member.model.dto.MemberDTO;

public class AdminService {

	private MemberMapper memberMapper;
	
	/**
	 * <pre>
	 *   관리자 로그인 처리용 메소드
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public MemberDTO loginCheck(MemberDTO requestMember) {

		SqlSession sqlSession = getSqlSession();
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO loginMember = null;
		String encPwd = memberMapper.selectEncryptedPwd(requestMember);
		
		System.out.println("encPwd 확인 : " + encPwd);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			loginMember = memberMapper.selectLoginAdmin(requestMember);
		}
		
		sqlSession.close();
		
		return loginMember;
	}

}
