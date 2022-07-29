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

	public ComInfoDTO selectCompanyDetail(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		ComInfoDTO company = companyMapper.adminSelectCompanyDetail(searchMap);
		
		sqlSession.close();
		
		return company;
	}

	public int accessCompanyStatus(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int result = companyMapper.accessCompanyStatus(searchMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int deleteCompany(String comNo) {

		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int result = companyMapper.deleteCompany(comNo);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int refuseCompanyStatus(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int result = companyMapper.refuseCompanyStatus(searchMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int updateCompany(Map<String, String> updateCompanyMap) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int result = companyMapper.updateCompany(updateCompanyMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int updateCompanyStatus(Map<String, String> updateRecordMap) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int result = companyMapper.updateCompanyStatus(updateRecordMap);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

}
