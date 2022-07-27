package com.waeating.admin.company.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.com.model.dao.ComInfoMapper;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.member.model.dao.MemberMapper;

public class AdminCompanyService {
	
	private ComInfoMapper companyMapper;

	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int totalCount = companyMapper.adminSelectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	public List<ComInfoDTO> selectCompanyList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		List<ComInfoDTO> companyList = companyMapper.adminSelectCompanyList(selectCriteria);
		
		sqlSession.close();
		
		return companyList;
	}

}
