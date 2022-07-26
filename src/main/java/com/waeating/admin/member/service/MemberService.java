package com.waeating.admin.member.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.member.model.dao.MemberMapper;
import com.waeating.member.model.dto.MemberDTO;

public class MemberService {
	
	private MemberMapper memberMapper;

	/**
	 * <pre>
	 * 	페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		int totalCount = memberMapper.selectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 * 	회원 전체 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<MemberDTO> selectMemberList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		List<MemberDTO> memberList = memberMapper.selectMemberList(selectCriteria);
		
		sqlSession.close();
		
		return memberList;
	}

}
