package com.waeating.admin.usagelog.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dao.WaitingRecordMapper;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

public class AdminUsageLogService {

	private WaitingRecordMapper logMapper;
	
	/**
	 * <pre>
	 *   페이징 처리를 위한 전체 이용이력 수 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		logMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		int totalCount = logMapper.adminSelectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 *   이용이력 전체 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<WaitingRecordDTO> adminSelectLogList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		logMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		List<WaitingRecordDTO> logList = logMapper.adminSelectLogList(selectCriteria);
		
		sqlSession.close();
		
		return logList;
	}

	/**
	 * <pre>
	 *   이용이력 상세 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public WaitingRecordDTO adminSelectLogDetail(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		logMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		WaitingRecordDTO log = logMapper.adminSelectLogDetail(searchMap);
		
		sqlSession.close();
		
		return log;
	}

	/**
	 * <pre>
	 *   이용이력 삭제용 메소드
	 * </pre>
	 * @param recordNo
	 * @return
	 */
	public int deleteLog(String recordNo) {
		
		SqlSession sqlSession = getSqlSession();
		logMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		int result = logMapper.deleteLog(recordNo);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
		
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}

	public int adminUpdateLog(Map<String, String> updateLogMap) {

		SqlSession sqlSession = getSqlSession();
		logMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		int result = logMapper.adminUpdateLog(updateLogMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
		
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

}
