package com.waeating.ceo.restInfo.model.dao;

import java.util.List;

import com.waeating.com.model.dto.ComInfoDTO;

public interface ComInfoMapper {

	ComInfoDTO comSelectOneComInfo(int comNo);

	List<ComInfoDTO> comSelectOneComMenu(int comNo);


}
