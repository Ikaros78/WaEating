package com.waeating.review.model.dao;

import java.util.List;


import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;

public interface ReviewMapper {

	List<ReviewDTO> selectReview(int comNo);

	ReviewDTO selectAvgRatings(int comNo);

	int insertReview(ReviewDTO insertReview);

	int insertReviewAttach(ReviewAttachDTO reviewAttachDTO);

	


}
