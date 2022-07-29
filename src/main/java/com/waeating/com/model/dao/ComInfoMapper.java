package com.waeating.com.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.com.model.dto.WaitingRecordDTO;
import com.waeating.common.paging.SelectCriteria;

public interface ComInfoMapper {

	/* 관리자 용도 */
	int adminSelectTotalCount(Map<String, String> searchMap);

	List<ComInfoDTO> adminSelectCompanyList(SelectCriteria selectCriteria);

	ComInfoDTO adminSelectCompanyDetail(Map<String, String> searchMap);

	int updateCompanyStatus(Map<String, String> searchMap);

	int deleteCompany(String comNo);

	int refuseCompanyStatus(Map<String, String> searchMap);
	
	
	/* 회원 정보 찾기 용도 */
	List<ComInfoDTO> selectCom(SelectCriteria selectCriteria);

	int selectAllCount(Map<String, String> searchMap);

	List<ComInfoDTO> selectComByGrade(SelectCriteria selectCriteria);

	


	

}
