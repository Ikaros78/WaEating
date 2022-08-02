package com.waeating.ceo.restInfo.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.waeating.ceo.restInfo.model.dao.ComInfoMapper;
import com.waeating.com.model.dto.ComInfoDTO;

public class ComInfoService {
	
	private ComInfoMapper comInfoMapper;

	public ComInfoDTO comSelectOneComInfo(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		ComInfoDTO comInfo = comInfoMapper.comSelectOneComInfo(comNo);
		
		sqlSession.close();
		
		return comInfo;
	}

	public List<ComInfoDTO> comSelectOneComMenu(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		comInfoMapper = sqlSession.getMapper(ComInfoMapper.class);
		List<ComInfoDTO> comMenu = comInfoMapper.comSelectOneComMenu(comNo);
		
		sqlSession.close();
		
		return comMenu;
	}

	

	
	
	
}
