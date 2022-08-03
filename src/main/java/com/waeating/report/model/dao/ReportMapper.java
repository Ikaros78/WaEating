package com.waeating.report.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.report.model.dto.ReportDTO;


public interface ReportMapper {
	

	 int selectTotalCount(Map<String, String> searchMap);

	 ReportDTO selectReprotDeatail(int no); 
    
	 int insertReport(ReportDTO report);

     List<ReportDTO> selectReportList(SelectCriteria selectCriteria);
  
	 ReportDTO selectOneReport(int reportNo);

	 int updateReport(ReportDTO report);

	 int deleteReport(int reportNo);
}