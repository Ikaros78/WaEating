package com.waeating.user.reservation.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.com.model.dao.ComInfoMapper;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.reservation.model.dao.ReservationMapper;

public class ReservationService {
	
	private ReservationMapper reservationMapper;
    
	
	/**
	 * <pre>
	 *  이미 완료한 예약 페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * </pre>
	 * 
	 * @param searchMap
	 * @return
	 */
	public int selectFinishTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(ReservationMapper.class);
		
		int totalCount = reservationMapper.selectFinishReservationCount(searchMap);
		
		sqlSession.close();
		
		
		return totalCount;
	}


	/**
	 * <pre>
	 * 이미 완료한 예약 조회
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ComInfoDTO> selectFinshReservation(SelectCriteria selectCriteria) {
		
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(ReservationMapper.class);
		
		List<ComInfoDTO> waiting = reservationMapper.selectReservationFinish(selectCriteria);
		
		sqlSession.close();
		
		
		return waiting;
	}


	/**
	 * <pre>
	 *  취소한 예약 페이징 처리를 위한 전체 예약 수 조회
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectCancelTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(ReservationMapper.class);
		
		int totalCount = reservationMapper.selectCancelReservationCount(searchMap);
		
		sqlSession.close();
		
		
		return totalCount;
	}


	/**
	 * <pre>
	 * 취소한 예약 조회
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ComInfoDTO> selectCancelReservation(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(ReservationMapper.class);
		
		List<ComInfoDTO> waiting = reservationMapper.selectReservationCancel(selectCriteria);
		
		sqlSession.close();
		
		
		return waiting;
	}




}
