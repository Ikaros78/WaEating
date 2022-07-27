package com.waeating.user.matziplist.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.user.matziplist.model.dto.ComInfoDTO;

public interface ComMapper {

	



	List<ComInfoDTO> selectComByCategory(String categoryName);

	List<ComInfoDTO> selectAllCom();

}
