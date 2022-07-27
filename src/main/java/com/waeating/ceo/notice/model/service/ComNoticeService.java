package com.waeating.ceo.notice.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.waeating.ceo.notice.model.dao.ComNoticeMapper;
import com.waeating.ceo.notice.model.dto.ComNoticeDTO;

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

}
