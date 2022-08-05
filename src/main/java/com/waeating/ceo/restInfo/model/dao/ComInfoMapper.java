package com.waeating.ceo.restInfo.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.com.model.dto.ComMenuDTO;

public interface ComInfoMapper {

	ComInfoDTO comSelectOneComInfo(int comNo);

	List<ComInfoDTO> comSelectOneComMenu(int comNo);

	int updateComInfo(Map<String, Object> updateComInfo);

	int insertComMenu(ComMenuDTO comMenuList);

	int deleteComMenu(String comNo);


}
