package com.waeating.user.matziplist.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.user.matziplist.model.dao.ComMapper;
import com.waeating.user.matziplist.model.dto.ComBoardAttachDTO;
import com.waeating.user.matziplist.model.dto.ComInfoDTO;

public class ComService {
	
	private ComMapper comMapper;



	/**
	 * <pre>
	 *  category별로 맛집 리스트 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ComInfoDTO> selectComByCategory(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		comMapper = sqlSession.getMapper(ComMapper.class);
		List<ComInfoDTO> com = comMapper.selectComByCategory(selectCriteria);
		
		sqlSession.close();
		
		return com;
	}


	/**
	 * <pre>
	 *  페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * </pre>
	 * 
	 * @param searchMap
	 * @return
	 */
	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		comMapper = sqlSession.getMapper(ComMapper.class);
		
		int totalCount = comMapper.selectAllCount(searchMap);
		
		sqlSession.close();
		
		
		return totalCount;
	}










}
