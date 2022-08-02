package com.waeating.report.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.report.model.dao.ReportMapper;
import com.waeating.support.model.dto.ReportDTO;

public class ReportService {
	
	
	private ReportMapper reportMapper;
	
	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		int totalCount = reportMapper.SelectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}
	
	public int insertReport(ReportDTO report) {

		SqlSession sqlSession = getSqlSession();
		
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		int result = ReportMapper.insertReport(report);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public List<ReportDTO> selectAllreport(SelectCriteria selectCriteria) {

		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		List<ReportDTO> reportList = reportMapper.selectReportList(selectCriteria);
		
		sqlSession.close();
		
		return reportList;
	}
	
    public ReportDTO selectReportDetail(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		ReportDTO report = reportMapper.SelectReportDetail(searchMap);
		
		sqlSession.close();
		
		return report;
	}

	public List<ReportDTO> selectAllReport(SelectCriteria selectCriteria) {
		// TODO Auto-generated method stub
		return null;
	}


}
