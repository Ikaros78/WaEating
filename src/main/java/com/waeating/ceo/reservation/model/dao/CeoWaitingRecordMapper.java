package com.waeating.ceo.reservation.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

public interface CeoWaitingRecordMapper {

	int selectTotalCount(Map<String, Object> searchMap);

	List<WaitingRecordDTO> selectAllWaitingList(SelectCriteria selectCriteria);

}
