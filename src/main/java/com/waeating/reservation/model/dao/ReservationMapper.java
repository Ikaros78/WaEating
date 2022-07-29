package com.waeating.reservation.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.SelectCriteria;

public interface ReservationMapper {
	
	int selectFinishReservationCount(Map<String, String> searchMap);

	List<ComInfoDTO> selectReservationFinish(SelectCriteria selectCriteria);

	

	int selectCancelReservationCount(Map<String, String> searchMap);

	List<ComInfoDTO> selectReservationCancel(SelectCriteria selectCriteria);

}
