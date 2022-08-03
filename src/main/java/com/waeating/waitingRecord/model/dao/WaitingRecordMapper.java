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

	List<ComInfoDTO> selectReservationNow(SelectCriteria selectCriteria);

	WaitingRecordDTO selectCountRecord(String comName);

	List<WaitingRecordDTO> selectWaitingRecordAll(Map<String, String> searchMap);

	int insertReservation(Map<String, String> waitingRecord);




}
