package com.waeating.ceo.login.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.waeating.com.model.dao.CeoMapper;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dao.MemberMapper;
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
	 * 	 회원가입 메소드 (ComInfoDTO) & COM_RECORD INSERT
	 * </pre>
	 * @param requestCom
	 * @return
	 */
	public int registCom(ComInfoDTO requestCom) {
		
		SqlSession sqlSession = getSqlSession();
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		int result = 0;
		
		int registCom = ceoMapper.insertComInfo(requestCom);
		
		int comNo = requestCom.getComNo();
		
		int comRecord = ceoMapper.insertComRecord(comNo);
		
		if(registCom > 0 && comRecord > 0) {
			
			sqlSession.commit();
			result = 1;
		} else { 
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 * 	 아이디 중복 확인 메소드
	 * </pre>
	 * @param ceoId
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
	 * @param requestCom
	 * @return loginMember
	 */
	public MemberDTO loginCheck(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		MemberDTO loginMember = null;
		
		String encPwd = ceoMapper.selectEncryptedPwd(requestMember);
		System.out.println("encPwd 확인 : " + encPwd);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			loginMember = ceoMapper.selectMemberLogin(requestMember);
		}
		
		sqlSession.close();
		
		return loginMember;
	}
	
	/**
	 * <pre>
	 * 	 전화번호로 아이디 찾는 메소드
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public MemberDTO findIdPhone(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		MemberDTO findCeoId = null;
		findCeoId = ceoMapper.selectFindIdForPhone(requestMember);
		
		sqlSession.close();
		
		return findCeoId;
	}

	/**
	 * <pre>
	 * 	 비밀번호 찾기를 위해 입력한 정보가 일치하는지 확인하는 메소드(Phone)
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public MemberDTO checkPwdPhone(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		MemberDTO checkPwd = ceoMapper.checkFindPwdForPhone(requestMember);
		
		sqlSession.close();
		
		return checkPwd;
	}

	/**
	 * <pre>
	 * 	 새로운 비밀번호 입력 메소드
	 * </pre>
	 * @param requestCom
	 * @return
	 */
	public int updateNewPwd(ComInfoDTO requestCom) {
		
		SqlSession sqlSession = getSqlSession();
		
		ceoMapper = sqlSession.getMapper(CeoMapper.class);
		
		int updatePwd = ceoMapper.updateNewPwd(requestCom);
		
		if(updatePwd > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updatePwd;
	}
}
