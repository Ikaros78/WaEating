package com.waeating.ceo.login.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.waeating.com.model.dao.ComInfoMapper;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dao.MemberMapper;
import com.waeating.member.model.dto.MemberDTO;

public class ComService {

	private ComInfoMapper comInfoMapper;

	/**
	 * <pre>
	 * 	 회원가입 메소드 (MemberDTO)
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public int registMember(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int resultMember = comInfoMapper.insertMember(requestMember);
		
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
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int registCom = comInfoMapper.insertComInfo(requestCom);
		
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
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int result = comInfoMapper.dubleCkId(ceoId);
		
		sqlSession.close();
		
		return result;
	}
}
