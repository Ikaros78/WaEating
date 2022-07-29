package com.waeating.ceo.review.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.com.model.dto.ReviewDTO;
import com.waeating.common.paging.SelectCriteria;

public interface ComReviewMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<ReviewDTO> selectAllReview(SelectCriteria selectCriteria);

}
