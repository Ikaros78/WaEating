package com.waeating.user.login.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.waeating.member.model.dao.MemberMapper;
import com.waeating.member.model.dto.MemberDTO;

public class UserLoginService {

	private MemberMapper memberMapper;
	
	/**
	 * <pre>
	 * 	 일반회원 로그인 처리 메소드
	 * </pre>
	 * @param requestMember
	 * @return loginMember
	 */
	public MemberDTO loginCheck(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO loginMember = null;
		
		String encPwd = memberMapper.selectEncryptedPwd(requestMember);
		System.out.println("encPwd 확인 : " + encPwd);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			loginMember = memberMapper.selectMemberLogin(requestMember);
		}
		
		sqlSession.close();
		
		return loginMember;
	}

}
