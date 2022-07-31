package com.waeating.support.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.support.model.dto.FAQDTO;

public interface FAQMapper {

	int adminSelectTotalFAQCount(Map<String, String> searchMap);

	List<FAQDTO> adminSelectFAQList(SelectCriteria selectCriteria);

	FAQDTO adminSelectFAQDetail(Map<String, String> searchMap);

	int updateFAQ(Map<String, String> updateFAQMap);

	int deleteFAQ(String faqNo);
	
}
