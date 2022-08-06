package com.waeating.ceo.review.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.review.model.dto.ReviewAnsDTO;
import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;

public interface ComReviewMapper {

	int selectTotalCount(Map<String, Object> searchMap);

	List<ReviewDTO> selectAllReview(Map<String, Object> search);

	ReviewDTO selectOneReview(int reviewNo);

	int insertReviewAns(ReviewAnsDTO reviewAns);

	int deleteReviewAns(int reviewNo);

	int updateReviewAns(ReviewAnsDTO reviewAns);

	List<ReviewAttachDTO> selectReviewImg(int reviewNo);

}
