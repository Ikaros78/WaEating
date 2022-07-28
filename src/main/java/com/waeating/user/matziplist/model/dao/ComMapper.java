package com.waeating.user.matziplist.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.user.matziplist.model.dto.ComBoardAttachDTO;
import com.waeating.user.matziplist.model.dto.ComInfoDTO;

public interface ComMapper {

	



	List<ComInfoDTO> selectComByCategory(SelectCriteria selectCriteria);

	int selectAllCount(Map<String, String> searchMap);

	

	

}
