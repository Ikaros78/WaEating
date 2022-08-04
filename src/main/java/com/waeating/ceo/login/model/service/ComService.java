package com.waeating.ceo.login.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.waeating.com.model.dao.CeoMapper;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dto.MemberDTO;

public class ComService {

	private CeoMapper ceoMapper;

	/**
	 * <pre>
	 * 	 회원가입 메소드 (MemberDTO)
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public int registMember(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		int resultMember = ceoMapper.insertMember(requestMember);
		
		if(resultMember > 0) {
			
			sqlSession.commit();
		} else { 
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return resultMember;
	}

	/**
	 * <pre>
	 * 	 회원가입 메소드 (ComInfoDTO)
	 * </pre>
	 * @param requestCom
	 * @return
	 */
	public int registCom(ComInfoDTO requestCom) {
		
		SqlSession sqlSession = getSqlSession();
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		int registCom = ceoMapper.insertComInfo(requestCom);
		
		if(registCom > 0) {
			
			sqlSession.commit();
		} else { 
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return registCom;
	}

	/**
	 * <pre>
	 * 	 아이디 중복 확인 메소드
	 * </pre>
	 * @param userId
	 * @return 
	 */
	public int dubleCkId(String ceoId) {

		SqlSession sqlSession = getSqlSession();
		
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		int result = ceoMapper.dubleCkId(ceoId);
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 * 	 로그인 처리 메소드
	 * </pre>
	 * @param requestMember
	 * @return loginMember
	 */
	public ComInfoDTO loginCheck(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		ComInfoDTO loginMember = null;
		
		String encPwd = ceoMapper.selectEncryptedPwd(requestMember);
		System.out.println("encPwd 확인 : " + encPwd);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			loginMember = ceoMapper.selectMemberLogin(requestMember);
		}
		
		sqlSession.close();
		
		return loginMember;
	}
}
