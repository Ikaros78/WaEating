package com.waeating.user.matziplist.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.user.matziplist.model.dao.ComMapper;
import com.waeating.user.matziplist.model.dto.ComInfoDTO;

public class ComService {
	
	private ComMapper comMapper;



	public List<ComInfoDTO> selectComByCategory(String categoryName) {
		
		SqlSession sqlSession = getSqlSession();
		
		comMapper = sqlSession.getMapper(ComMapper.class);
		List<ComInfoDTO> com = comMapper.selectComByCategory(categoryName);
		
		sqlSession.close();
		
		return com;
	}

//	public List<ComInfoDTO> selectAllCom() {
//		
//		SqlSession sqlSession = getSqlSession();
//		
//		comMapper = sqlSession.getMapper(ComMapper.class);
//		List<ComInfoDTO> comInfo = comMapper.selectAllCom();
//		
//		return comInfo;
//	}

}
