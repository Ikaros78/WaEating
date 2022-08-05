package com.waeating.review.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;

import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;

public interface ReviewMapper {

	List<ReviewDTO> selectReview(int comNo);

	ReviewDTO selectAvgRatings(int comNo);

	int insertReview(ReviewDTO insertReview);
	
	int insertReviewAttach(ReviewAttachDTO reviewAttachDTO);
	
	/* 관리자 용도 */
	int adminSelectTotalCount(Map<String, String> searchMap);

	List<ReviewDTO> adminSelectReviewList(SelectCriteria selectCriteria);

	ReviewDTO adminSelectReviewDetail(Map<String, String> searchMap);

	List<ReviewAttachDTO> adminSelectReviewAttachList(Map<String, String> searchMap);

	int adminDeleteReview(Map<String, String> searchMap);

	


}
