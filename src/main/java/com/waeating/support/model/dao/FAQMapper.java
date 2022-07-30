package com.waeating.support.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.support.model.dto.FAQDTO;

public interface FAQMapper {

	int adminSelectTotalFAQCount(Map<String, String> searchMap);

	List<FAQDTO> adminSelectFAQList(SelectCriteria selectCriteria);
	
}
