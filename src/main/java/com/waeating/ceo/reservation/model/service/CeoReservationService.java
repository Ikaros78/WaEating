package com.waeating.ceo.reservation.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.ceo.reservation.model.dao.CeoWaitingRecordMapper;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

public class CeoReservationService {
	
	private CeoWaitingRecordMapper ceoWaitingRecordMapper;

	public int selectTotalCount(Map<String, Object> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		ceoWaitingRecordMapper = sqlSession.getMapper(CeoWaitingRecordMapper.class);
		
		int totalCount = ceoWaitingRecordMapper.selectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
		
	}

	public List<WaitingRecordDTO> selectAllWaitingList(SelectCriteria selectCriteria) {

		SqlSession sqlSession = getSqlSession();
		ceoWaitingRecordMapper = sqlSession.getMapper(CeoWaitingRecordMapper.class);
		
		List<WaitingRecordDTO> waitingRecordList = ceoWaitingRecordMapper.selectAllWaitingList(selectCriteria);
		
		sqlSession.close();
		
		return waitingRecordList;
	}

}
