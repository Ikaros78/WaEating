package com.waeating.ceo.review.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.review.model.dto.ReviewDTO;

public interface ComReviewMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<ReviewDTO> selectAllReview(SelectCriteria selectCriteria);

}
