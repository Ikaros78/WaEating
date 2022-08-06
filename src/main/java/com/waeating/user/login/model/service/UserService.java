package com.waeating.user.login.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.waeating.member.model.dao.MemberMapper;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.member.model.dto.UserDTO;

public class UserService {

	private MemberMapper memberMapper;
	
	/**
	 * <pre>
	 * 	 로그인 처리 메소드
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

	/**
	 * <pre>
	 * 	 회원가입 메소드 (userDTO)
	 * </pre>
	 * @param requestMember
	 * @return resultUser
	 */
	public int registUser(UserDTO requestUser) {
		
		SqlSession sqlSession = getSqlSession();
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		int resultUser = memberMapper.insertUser(requestUser);
		
		if(resultUser > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return resultUser;
	}

	/**
	 * <pre>
	 * 	 회원가입 메소드 (MemberDTO)
	 * </pre>
	 * @param requestMember
	 * @return resultMember
	 */
	public int registMember(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		int resultMember = memberMapper.insertMember(requestMember);
		
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
	 * 	 아이디 중복 확인 메소드
	 * </pre>
	 * @param userId
	 * @return 
	 */
	public int dubleCkId(String userId) {
		
		SqlSession sqlSession = getSqlSession();
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		int result = memberMapper.dubleCkId(userId);
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 * 	 이메일로 아이디 찾는 메소드
	 * </pre>
	 * @param requestMember
	 * @return finUserId
	 */
	public MemberDTO findIdEmail(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO findUserId = null;
		findUserId = memberMapper.selectFindIdForEmail(requestMember);
		
		sqlSession.close();
		
		return findUserId;
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
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO findUserId = null;
		findUserId = memberMapper.selectFindIdForPhone(requestMember);
		
		sqlSession.close();
		
		return findUserId;
	}

	/**
	 * <pre>
	 * 	 비밀번호 찾기를 위해 입력한 정보가 일치하는지 확인하는 메소드(Email)
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public MemberDTO checkPwdEmail(MemberDTO requestMember) {

		SqlSession sqlSession = getSqlSession();
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO checkPwd = memberMapper.checkFindPwForEmail(requestMember);
		
		sqlSession.close();
		
		return checkPwd;
	}

	/**
	 * <pre>
	 * 	 새로운 비밀번호 입력 메소드
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public int updateNewPwd(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		int updatePwd = memberMapper.updateNewPwd(requestMember);
		
		if(updatePwd > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updatePwd;
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
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO checkPwd = memberMapper.checkFindPwForPhone(requestMember);
		
		sqlSession.close();
		
		return checkPwd;
	}

	/**
	 * <pre>
	 *	 회원 정보 수정을 위한 비밀번호 확인하는 메소드
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public MemberDTO checkPwdUser(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO userInfo = null;
		
		String encPwd = memberMapper.selectEncryptedPwd(requestMember);
		System.out.println("encPwd 확인 : " + encPwd);
		System.out.println("pwd : " + requestMember.getPwd());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			userInfo = memberMapper.selectMemberLogin(requestMember);
		}
		
		sqlSession.close();
		
		return userInfo;
		
	}

	/**
	 * <pre>
	 * 	 회원 정보 update 메소드
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public int updateUserInformation(MemberDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		int result = memberMapper.updateUserInformation(requestMember);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 * 	 회원 정보 수정 후 수정된 세션 등록을 위한 메소드
	 * </pre>
	 * @param requestMember
	 * @return
	 */
	public MemberDTO newUserInfo(MemberDTO requestMember) {

		SqlSession sqlSession = getSqlSession();
		
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberDTO loginMember = memberMapper.selectMemberLogin(requestMember);
		
		sqlSession.close();
		
		return loginMember;
	}




}
