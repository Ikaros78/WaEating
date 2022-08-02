package com.waeating.review.model.dao;

import java.util.List;

import com.waeating.review.model.dto.ReviewDTO;

public interface ReviewMapper {

	List<ReviewDTO> selctReview(String comNo);

	ReviewDTO selectAvgRatings(String comNo);

}
