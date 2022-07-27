package com.waeating.user.matziplist.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.user.matziplist.model.dao.ComMapper;
import com.waeating.user.matziplist.model.dto.ComInfoDTO;

public class ComService {
	
	private ComMapper comMapper;

//	/**
//	 * <pre>
//	 *  페이징 처리를 위한 전체 게시물 조회용 메소드
//	 * </pre>
//	 * @param searchMap
//	 * @return
//	 */
//	public int selectTotalCount(Map<String, String> searchMap) {
//		
//		SqlSession sqlSession = getSqlSession();
//		comMapper = sqlSession.getMapper(ComMapper.class);
//		
//		int totalCount = comMapper.selectTotalCount(searchMap);
//		
//		sqlSession.close();
//
//		return totalCount;
//	}

	public ComInfoDTO selectComByCategory(String categoryName) {
		
		SqlSession sqlSession = getSqlSession();
		
		comMapper = sqlSession.getMapper(ComMapper.class);
		ComInfoDTO com = comMapper.selectComByCategory(categoryName);
		
		sqlSession.close();
		
		return com;
	}

}
