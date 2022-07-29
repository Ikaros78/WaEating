package com.waeating.admin.support.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.support.model.dao.ReportMapper;
import com.waeating.support.model.dto.ReportDTO;

public class AdminSupportService {
	
	private ReportMapper reportMapper;

	/**
	 * <pre>
	 *  페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		int totalCount = reportMapper.adminSelectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 *   문의 전체 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ReportDTO> selectReportList(SelectCriteria selectCriteria) {

		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		List<ReportDTO> reportList = reportMapper.adminSelectReportList(selectCriteria);
		
		sqlSession.close();
		
		return reportList;
	}

	public ReportDTO selectReportDetail(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		ReportDTO report = reportMapper.adminSelectReportDetail(searchMap);
		
		sqlSession.close();
		
		return report;
	}

}
