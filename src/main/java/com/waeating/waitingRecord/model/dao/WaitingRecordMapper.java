package com.waeating.waitingRecord.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

public interface WaitingRecordMapper {
	
	int selectFinishReservationCount(Map<String, String> searchMap);

	List<ComInfoDTO> selectReservationFinish(SelectCriteria selectCriteria);

	

	int selectCancelReservationCount(Map<String, String> searchMap);

	List<ComInfoDTO> selectReservationCancel(SelectCriteria selectCriteria);

	int selectNowReservationCount(Map<String, String> searchMap);

	List<ComInfoDTO> selectReservationNow(Map<String, String> searchMap);

	int selectCountRecord(Map<String, String> waitingCountMap);
	
	List<WaitingRecordDTO> selectWaitingRecordAll(Map<String, String> searchMap);
	
	int insertReservation(Map<String, String> waitingRecord);
	
	int updateReservation(Map<String, String> waitingRecord);
	
	WaitingRecordDTO selectReservation(Map<String, String> selectComMap);
	/* 관리자용 */
	int adminSelectTotalCount(Map<String, String> searchMap);

	List<WaitingRecordDTO> adminSelectLogList(SelectCriteria selectCriteria);

	WaitingRecordDTO adminSelectLogDetail(Map<String, String> searchMap);

	int deleteLog(String recordNo);

	int adminUpdateLog(Map<String, String> updateLogMap);

	String adminSelectRefuseLogDetail(Map<String, String> searchMap);

	




}
