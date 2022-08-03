package com.waeating.user.review.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.waeating.review.model.dao.ReviewMapper;
import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;

public class ReviewService {
	
	private ReviewMapper reviewMapper;

	/**
	 * <pre>
	 *  디테일 화면 리뷰 조회
	 * </pre>
	 * @param comInfo 
	 * @return
	 */
	public List<ReviewDTO> selectComReview(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		List<ReviewDTO> review = reviewMapper.selectReview(comNo);
		
		sqlSession.close();
		
		return review;
	}

	/**
	 * <pre>
	 *  업체 별점 평균 조회
	 * </pre>
	 * @param comNo
	 * @return
	 */
	public ReviewDTO selectAvgRatings(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		ReviewDTO totalCount = reviewMapper.selectAvgRatings(comNo);
		
		sqlSession.close();
		
		return totalCount;
	}




}
