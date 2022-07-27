package com.waeating.user.matziplist.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.user.matziplist.model.dto.ComInfoDTO;

public interface ComMapper {

	//int selectTotalCount(Map<String, String> searchMap);



	ComInfoDTO selectComByCategory(String categoryName);

}
