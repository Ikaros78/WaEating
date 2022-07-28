package com.waeating.com.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.SelectCriteria;

public interface ComInfoMapper {

	int adminSelectTotalCount(Map<String, String> searchMap);

	List<ComInfoDTO> adminSelectCompanyList(SelectCriteria selectCriteria);

	ComInfoDTO adminSelectCompanyDetail(Map<String, String> searchMap);

	int updateCompanyStatus(Map<String, String> searchMap);

	int deleteCompany(String comNo);

	int refuseCompanyStatus(Map<String, String> searchMap);

}
