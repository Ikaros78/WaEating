package com.waeating.admin.review.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.review.model.dao.ReviewMapper;
import com.waeating.review.model.dto.ReviewDTO;

public class AdminReviewService {
	
	private ReviewMapper reviewMapper;

	/**
	 * <pre>
	 *   페이징 처리를 위한 전체 리뷰 수 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectTotalReviewCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		int totalCount = reviewMapper.adminSelectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 *   리뷰 전체 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ReviewDTO> AdminSelectReviewList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		List<ReviewDTO> reviewList = reviewMapper.adminSelectReviewList(selectCriteria);
		
		return reviewList;
	}

	/**
	 * <pre>
	 *   리뷰 상세 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public ReviewDTO selectReviewDetail(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		ReviewDTO review = reviewMapper.adminSelectReviewDetail(searchMap);
		
		return review;
	}


}
