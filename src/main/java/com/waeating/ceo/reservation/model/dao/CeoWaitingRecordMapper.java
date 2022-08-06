package com.waeating.ceo.reservation.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;
import com.waeating.waitingRecord.model.dto.WaitingRefuseDTO;

public interface CeoWaitingRecordMapper {

	int selectTotalCount(Map<String, Object> searchMap);

	List<WaitingRecordDTO> selectAllWaitingList(Map<String, Object> search);

	int updateWaitingRecord(WaitingRecordDTO waitingRecord);

	int insertWaitingRefuse(WaitingRefuseDTO waitingRefuse);

	List<WaitingRecordDTO> selectAllWaitingListDate(Map<String, Object> search);

	int selectTotalCountDate(Map<String, Object> searchMap);

}
