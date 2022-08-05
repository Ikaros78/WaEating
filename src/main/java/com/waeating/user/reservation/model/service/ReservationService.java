package com.waeating.user.reservation.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dao.WaitingRecordMapper;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

public class ReservationService {
	
	private WaitingRecordMapper reservationMapper;
    
	
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
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
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
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
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
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
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
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		List<ComInfoDTO> waiting = reservationMapper.selectReservationCancel(selectCriteria);
		
		sqlSession.close();
		
		
		return waiting;
	}


	/**
	 * <pre>
	 *  페이징을 위한 현재예약 전체 수 조회
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectNowTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		int totalCount = reservationMapper.selectNowReservationCount(searchMap);
		
		sqlSession.close();
		
		
		return totalCount;
	}


	/**
	 * <pre>
	 *  현재 예약 조회
	 * </pre>
	 * 
	 * @param searchMap
	 * @return
	 */
	public List<ComInfoDTO> selectNowReservation(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		List<ComInfoDTO> waiting = reservationMapper.selectReservationNow(searchMap);
		
		sqlSession.close();
		
		
		return waiting;
	}


	/**
	 * <pre>
	 *  현재 예약 앞에 몇팀 남았는지 보여주기 위한 recordNo 카운트 조회
	 * </pre>
	 * 
	 * @param comName
	 * @return
	 */
	public int selectCountRecord(Map<String, String> waitingCountMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		int waiting = reservationMapper.selectCountRecord(waitingCountMap);
		
		sqlSession.close();
		
		return waiting;
	}


	public List<WaitingRecordDTO> selectWaitingRecordAll(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		List<WaitingRecordDTO> waiting = reservationMapper.selectWaitingRecordAll(searchMap);
		
		sqlSession.close();
		
		return waiting;
	}


	/**
	 * <pre>
	 *  예약 추가
	 * </pre>
	 * @param waitingRecord
	 * @return
	 */
	public int insertReservation(Map<String, String> waitingRecord) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		int result = reservationMapper.insertReservation(waitingRecord);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}


	/**
	 * <pre>
	 *  예약 취소를 위한 업데이트
	 * </pre>
	 * @param waitingRecord
	 * @return
	 */
	public int updateReservaiton(Map<String, String> waitingRecord) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		int result = reservationMapper.updateReservation(waitingRecord);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}


	/**
	 * <pre>
	 * 	리뷰 작성 시 보여줄 예약 정보 
	 * </pre>
	 * @param selectComMap
	 * @return
	 */
	public WaitingRecordDTO selectReservation(Map<String, String> selectComMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reservationMapper = sqlSession.getMapper(WaitingRecordMapper.class);
		
		WaitingRecordDTO waiting = reservationMapper.selectReservation(selectComMap);
		
		sqlSession.close();
		
		
		return waiting;
	}









}
