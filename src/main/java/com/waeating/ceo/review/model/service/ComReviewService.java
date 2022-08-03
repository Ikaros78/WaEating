package com.waeating.ceo.review.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.ceo.review.model.dao.ComReviewMapper;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.review.model.dto.ReviewAnsDTO;
import com.waeating.review.model.dto.ReviewDTO;

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

	public ReviewDTO selectOneReview(int reviewNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comReviewMapper  = sqlSession.getMapper(ComReviewMapper.class);
		ReviewDTO review = comReviewMapper.selectOneReview(reviewNo);
		
		sqlSession.close();
		return review;
	}

	public int insertReviewAns(ReviewAnsDTO reviewAns) {
		
		SqlSession sqlSession = getSqlSession();
		
		comReviewMapper = sqlSession.getMapper(ComReviewMapper.class);
		int result = comReviewMapper.insertReviewAns(reviewAns);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int deleteReviewAns(int reviewNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comReviewMapper = sqlSession.getMapper(ComReviewMapper.class);
		int result = comReviewMapper.deleteReviewAns(reviewNo);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int updateReviewAns(ReviewAnsDTO reviewAns) {
		
		SqlSession sqlSession = getSqlSession();
		
		comReviewMapper = sqlSession.getMapper(ComReviewMapper.class);
		int result = comReviewMapper.updateReviewAns(reviewAns);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}

}
