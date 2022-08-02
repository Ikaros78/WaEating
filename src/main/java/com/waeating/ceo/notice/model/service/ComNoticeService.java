package com.waeating.ceo.notice.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.ceo.notice.model.dao.ComNoticeMapper;
import com.waeating.ceo.notice.model.dto.ComNoticeDTO;
import com.waeating.common.paging.SelectCriteria;

public class ComNoticeService {
	
	private ComNoticeMapper comNoticeMapper;

	public int insertComNotice(ComNoticeDTO comNotice) {

		SqlSession sqlSession = getSqlSession();
		
		comNoticeMapper = sqlSession.getMapper(ComNoticeMapper.class);
		int result = comNoticeMapper.insertComNotice(comNotice);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public List<ComNoticeDTO> selectAllNotice(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		comNoticeMapper = sqlSession.getMapper(ComNoticeMapper.class);
		
		List<ComNoticeDTO> comNoticeList = comNoticeMapper.selectAllNotice(selectCriteria);
		
		sqlSession.close();
		
		return comNoticeList;
	}

	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		comNoticeMapper = sqlSession.getMapper(ComNoticeMapper.class);
		
		int totalCount = comNoticeMapper.selectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	public ComNoticeDTO selectOneNotice(int noticeNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comNoticeMapper = sqlSession.getMapper(ComNoticeMapper.class);
		ComNoticeDTO comNotice = comNoticeMapper.selectOneNotice(noticeNo);
		
		sqlSession.close();
		
		return comNotice;
	}

	public int updateNotice(ComNoticeDTO comNotice) {
		
		SqlSession sqlSession = getSqlSession();
		
		comNoticeMapper = sqlSession.getMapper(ComNoticeMapper.class);
		int result = comNoticeMapper.updateNotice(comNotice);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}

	public int deleteNotice(int noticeNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comNoticeMapper = sqlSession.getMapper(ComNoticeMapper.class);
		int result = comNoticeMapper.deleteNotice(noticeNo);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	

	

	

}
