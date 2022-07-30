package com.waeating.support.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.support.model.dto.FAQDTO;
import com.waeating.support.model.dto.ReportDTO;

public interface ReportMapper {

	int adminSelectTotalCount(Map<String, String> searchMap);

	List<ReportDTO> adminSelectReportList(SelectCriteria selectCriteria);

	ReportDTO adminSelectReportDetail(Map<String, String> searchMap);

}
