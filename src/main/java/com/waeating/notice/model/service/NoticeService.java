package com.waeating.notice.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.waeating.notice.model.dao.NoticeMapper;
import com.waeating.notice.model.dto.NoticeDTO;

public class NoticeService {
	
	private NoticeMapper noticeMapper;
	

	public int insertNotice(NoticeDTO newNotice) {
	
    SqlSession sqlSession = getSqlSession();
    noticeMapper = sqlSession.getMapper(NoticeMapper.class);
    int result = noticeMapper.insertNotice(newNotice);
    
    if(result > 0) {
    	sqlSession.commit();
    } else {
    	sqlSession.rollback();
    }
    
    sqlSession.close();
    
    return result;
    
    
	
	}

	public NoticeDTO selectNoticeDetail(int no) { 
		
		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		NoticeDTO noticeDetail = null;
		
		int result = noticeMapper.incrementNoticeCCount(no);
		
		if(result > 0) {
			noticeDetail = noticeMapper.selectNoticeDeatail(no);
			
			if(noticeDetail !=null) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		}
		return noticeDetail;
		
		
	}

	public List<NoticeDTO> selectAllNoticeList() {
		

		SqlSession sqlSession = getSqlSession();
		noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		List<NoticeDTO> noticeList = noticeMapper.selectAllNoticeList();
		
		sqlSession.close();
		
		return noticeList;
	}




}
