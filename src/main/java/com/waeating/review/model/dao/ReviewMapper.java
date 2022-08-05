package com.waeating.review.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;

public interface ReviewMapper {

	List<ReviewDTO> selectReview(int comNo);

	ReviewDTO selectAvgRatings(int comNo);

	int insertReview(ReviewDTO insertReview);

	int insertReviewAttach(ReviewAttachDTO reviewAttachDTO);

	ReviewDTO selectMyReview(Map<String, String> selectComMap);

	List<ReviewAttachDTO> selectMyReviewImg(int reviewNo);

	


}
