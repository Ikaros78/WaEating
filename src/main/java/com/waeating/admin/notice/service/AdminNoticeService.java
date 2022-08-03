package com.waeating.admin.notice.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.notice.model.dao.NoticeMapper;
import com.waeating.notice.model.dto.NoticeAttachDTO;
import com.waeating.notice.model.dto.NoticeDTO;

public class AdminNoticeService {

	private NoticeMapper noticeMapper;
	
	/**
	 * <pre>
	 *   페이징 처리를 위한 전체 공지사항 수 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectTotalNoticeCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		int totalCount = noticeMapper.adminSelectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 *   공지사항 전체 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<NoticeDTO> AdminSelectNoticeList(SelectCriteria selectCriteria) {

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		List<NoticeDTO> noticeList = noticeMapper.adminSelectNoticeList(selectCriteria);
		
		return noticeList;
	}

	/**
	 * <pre>
	 *   공지사항 상세 조회용 메소드 
	 * </pre>
	 * @param searchMap 
	 * @return
	 */
	public NoticeDTO selectNoticeDetail(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		NoticeDTO notice = noticeMapper.adminSelectNoticeDetail(searchMap);
		
		sqlSession.close();
		
		return notice;
	}

	/**
	 * <pre>
	 *   공지사항 정보 수정용 메소드
	 * </pre>
	 * @param updateNoticeMap
	 * @return
	 */
	public int updateNotice(Map<String, String> updateNoticeMap) {

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		int result = noticeMapper.updateNotice(updateNoticeMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		}else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   공지사항 정보 삭제용 메소드
	 * </pre>
	 * @param noticeNo
	 * @return
	 */
	public int deleteNotice(String noticeNo) {

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		int result = noticeMapper.deleteNotice(noticeNo);
		
		if(result > 0) {
			
			sqlSession.commit();
		}else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   공지사항 정보 등록용 메소드
	 * </pre>
	 * @param insertNotice
	 * @return
	 */
	public int insertNotice(NoticeDTO insertNotice) {
		
		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		int result = 0;
		
		int noticeResult = noticeMapper.insertNotice(insertNotice);
		
		List<NoticeAttachDTO> fileList = insertNotice.getAttachList();
		
		for(int i = 0 ; i < fileList.size(); i++) {
			fileList.get(i).setNoticeNo(insertNotice.getNoticeNo());
		}
		
		int attachResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachResult += noticeMapper.insertAttach(fileList.get(i));
		}
		
		if(noticeResult > 0 && attachResult == fileList.size()) {
			sqlSession.commit();
			result = 1;
		}else {
			sqlSession.rollback();
		}
			
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   공지사항 첨부파일 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public List<NoticeAttachDTO> selectNoticeAttachList(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		
		List<NoticeAttachDTO> attachList = noticeMapper.selectNoticeAttachList(searchMap);
				
		sqlSession.close();
		
		return attachList;
	}

}
