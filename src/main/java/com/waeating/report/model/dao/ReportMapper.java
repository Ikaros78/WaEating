package com.waeating.report.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.support.model.dto.ReportDTO;

public interface ReportMapper {

  List<com.waeating.report.model.dto.ReportDTO> selectReportList (SelectCriteria selectCriteria);
   
  int SelectTotalCount(Map<String, String> searchMap);
  
  com.waeating.report.model.dto.ReportDTO SelectReportDetail(int no);

static int insertReport(com.waeating.report.model.dto.ReportDTO report) {
	// TODO Auto-generated method stub
	return 0;
}

}
