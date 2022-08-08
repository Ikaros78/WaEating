package com.waeating.user.matziplist.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.ceo.notice.model.dao.ComNoticeMapper;
import com.waeating.com.model.dao.ComInfoMapper;
import com.waeating.com.model.dto.ComBoardAttachDTO;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.com.model.dto.ComNoticeDTO;
import com.waeating.common.paging.SelectCriteria;


public class ComService {
	
	private static ComInfoMapper comInfoMapper;
	private static ComNoticeMapper comNoticeMapper;



	/**
	 * <pre>
	 *  category별로 맛집 리스트 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ComInfoDTO> selectComByCategory(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		List<ComInfoDTO> com = comInfoMapper.selectCom(selectCriteria);
		
		sqlSession.close();
		
		return com;
	}


	/**
	 * <pre>
	 *  페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * </pre>
	 * 
	 * @param searchMap
	 * @return
	 */
	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int totalCount = comInfoMapper.selectAllCount(searchMap);
		
		sqlSession.close();
		
		
		return totalCount;
	}


	/**
	 * <pre>
	 *  location별 맛집 리스트 조회
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ComInfoDTO> selectComByLocation(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		List<ComInfoDTO> com = comInfoMapper.selectCom(selectCriteria);
		
		sqlSession.close();
		
		return com;
	}


	/**
	 * <pre>
	 *  평점별로 정렬된 맛집 리스트 조회
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ComInfoDTO> selectComByGrade(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		List<ComInfoDTO> com = comInfoMapper.selectComByGrade(selectCriteria);
		
		sqlSession.close();
		
		return com;
	}



	/**
	 * <pre>
	 *  업체 정보 디테일 화면 조회
	 * </pre>
	 * @param comInfo 
	 * @return
	 */
	public ComInfoDTO selctComDetail(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		ComInfoDTO com = comInfoMapper.selectComDetail(comNo);
		
		sqlSession.close();
		
		return com;
	}

	/**
	 * <pre>
	 *  업체 메뉴 디테일 화면 조회
	 * </pre>
	 * @param comInfo 
	 * @return
	 */
	public List<ComInfoDTO> selectComMenu(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		List<ComInfoDTO> com = comInfoMapper.selectComMenu(comNo);
		
		sqlSession.close();
		
		return com;
	}


	/**
	 * <pre>
	 *  업체 메뉴 디테일 화면 업체사진 불러오기
	 * </pre>
	 * @param comNo
	 * @return
	 */
	public List<ComBoardAttachDTO> selectComImg(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		List<ComBoardAttachDTO> com = comInfoMapper.selectComImg(comNo);
		
		sqlSession.close();
		
		return com;
	}


	/**
	 * <pre>
	 *  업체 디테일 화면 공지사항 조회
	 * </pre>
	 * 
	 * @param comNo
	 * @return
	 */
	public List<ComNoticeDTO> selectComNotice(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comNoticeMapper = sqlSession.getMapper(ComNoticeMapper.class);
		
		List<ComNoticeDTO> com = comNoticeMapper.selectMatziplistComNotice(comNo);
		
		sqlSession.close();
		
		return com;
	}


	/**
	 * <pre>
	 *  예약하기 할 때 가게 이름 조회 용 
	 * </pre>
	 * @param comNo
	 * @return
	 */
	public ComInfoDTO selectComName(String comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		ComInfoDTO com = comInfoMapper.selectComName(comNo);
		
		sqlSession.close();
		
		return com;
	}


	/**
	 * <pre>
	 *  리뷰별 리스트 수 조회 페이징처리를 위해
	 * </pre>
	 * @return
	 */
	public int selectComCountByGrade() {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int totalCount = comInfoMapper.selectComCountByGrade();
		
		sqlSession.close();
		
		
		return totalCount;
	}
	










}
