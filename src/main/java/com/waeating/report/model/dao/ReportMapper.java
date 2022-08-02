package com.waeating.report.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.support.model.dto.ReportDTO;

public interface ReportMapper {

  List<ReportDTO> selectReportList (SelectCriteria selectCriteria);
   
  int SelectTotalCount(Map<String, String> searchMap);
  
  ReportDTO SelectReportDetail(Map<String, String> searchMap);

static int insertReport(ReportDTO report) {
	// TODO Auto-generated method stub
	return 0;
}

}
