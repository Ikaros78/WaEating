package com.waeating.ceo.review.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.ceo.review.model.dao.ComReviewMapper;
import com.waeating.com.model.dto.ReviewDTO;
import com.waeating.common.paging.SelectCriteria;

public class ComReviewService {
	
	private ComReviewMapper comReviewMapper;

	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		comReviewMapper = sqlSession.getMapper(ComReviewMapper.class);
		
		int totalCount = comReviewMapper.selectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	public List<ReviewDTO> selectAllReview(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		comReviewMapper = sqlSession.getMapper(ComReviewMapper.class);
		
		List<ReviewDTO> comReviewList = comReviewMapper.selectAllReview(selectCriteria);
		
		sqlSession.close();
		
		return comReviewList;
	}

}
