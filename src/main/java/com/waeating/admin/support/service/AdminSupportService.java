package com.waeating.admin.support.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.support.model.dao.FAQMapper;
import com.waeating.support.model.dao.ReportMapper;
import com.waeating.support.model.dto.FAQDTO;
import com.waeating.support.model.dto.ReportDTO;

public class AdminSupportService {
	
	private ReportMapper reportMapper;
	private FAQMapper FAQMapper;

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

	/**
	 * <pre>
	 *   문의 상세 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public ReportDTO selectReportDetail(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		reportMapper = sqlSession.getMapper(ReportMapper.class);
		
		ReportDTO report = reportMapper.adminSelectReportDetail(searchMap);
		
		sqlSession.close();
		
		return report;
	}

	/**
	 * <pre>
	 *   페이징 처리를 위한 전체 자주 묻는 질문 수 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectTotalFAQCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		FAQMapper = sqlSession.getMapper(FAQMapper.class);
		
		int totalCount = FAQMapper.adminSelectTotalFAQCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 * 	자주 묻는 질문 전체 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<FAQDTO> selectFAQList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		FAQMapper = sqlSession.getMapper(FAQMapper.class);
		
		List<FAQDTO> FAQList = FAQMapper.adminSelectFAQList(selectCriteria);
		
		sqlSession.close();
		
		return FAQList;
	}

	/**
	 * <pre>
	 * 	자주 묻는 질문 상세 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public FAQDTO selectFAQDetail(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		FAQMapper = sqlSession.getMapper(FAQMapper.class);
		
		FAQDTO faq = FAQMapper.adminSelectFAQDetail(searchMap);
		
		sqlSession.close();
		
		return faq;
	}

	/**
	 * <pre>
	 *   자주 묻는 질문 수정용 메소드
	 * </pre>
	 * @param updateFAQMap
	 * @return
	 */
	public int updateFAQ(Map<String, String> updateFAQMap) {

		SqlSession sqlSession = getSqlSession();
		FAQMapper = sqlSession.getMapper(FAQMapper.class);
		
		int result = FAQMapper.updateFAQ(updateFAQMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		}else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   자주 묻는 질문 삭제용 메소드
	 * </pre>
	 * @param faqNo
	 * @return
	 */
	public int deleteFAQ(String faqNo) {
		
		SqlSession sqlSession = getSqlSession();
		FAQMapper = sqlSession.getMapper(FAQMapper.class);
		
		int result = FAQMapper.deleteFAQ(faqNo);
		
		if(result > 0) {
			
			sqlSession.commit();
		}else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   자주 묻는 질문 등록용 메소드
	 * </pre>
	 * @param insertFAQMap
	 * @return
	 */
	public int insertFAQ(Map<String, String> insertFAQMap) {

		SqlSession sqlSession = getSqlSession();
		FAQMapper = sqlSession.getMapper(FAQMapper.class);
		
		int result = FAQMapper.insertFAQ(insertFAQMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		}else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

}
