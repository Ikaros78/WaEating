package com.waeating.report.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.report.model.dao.ReportMapper;
import com.waeating.report.model.dto.ReportDTO;

public class ReportService {
	
	private ReportMapper reportMapper;
	
	public int insertReport(ReportDTO report) {

		SqlSession sqlSession = getSqlSession();
		
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		int result = reportMapper.insertReport(report);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public List<ReportDTO> selectReportList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		List<ReportDTO> reportList = reportMapper.selectReportList(selectCriteria);
		
		sqlSession.close();
		
		return reportList;
	}

	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		int totalCount = reportMapper.selectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	public ReportDTO selectOneReport(int reportNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		ReportDTO report = reportMapper.selectOneReport(reportNo);
		
		sqlSession.close();
		
		return report;
	}

	public int updateReport(ReportDTO report) {
		
		SqlSession sqlSession = getSqlSession();
		
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		int result = reportMapper.updateReport(report);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}

	public int deleteReport(int reportNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		int result = reportMapper.deleteReport(reportNo);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}


	
	

	

	

}
	
     