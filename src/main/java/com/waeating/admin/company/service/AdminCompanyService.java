package com.waeating.admin.company.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.com.model.dao.ComInfoMapper;
import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.common.paging.SelectCriteria;
import com.waeating.member.model.dao.MemberMapper;

/**
 * @author user
 *
 */
public class AdminCompanyService {
	
	private ComInfoMapper companyMapper;

	/**
	 * <pre>
	 *   페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		int totalCount = companyMapper.adminSelectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 *   업체 전체 조회용 메소드
	 * </pre>
	 * @param selectCriteria
	 * @return
	 */
	public List<ComInfoDTO> selectCompanyList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		List<ComInfoDTO> companyList = companyMapper.adminSelectCompanyList(selectCriteria);
		
		sqlSession.close();
		
		return companyList;
	}

	/**
	 * <pre>
	 *   업체 정보 상세보기용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
	public ComInfoDTO selectCompanyDetail(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		companyMapper = sqlSession.getMapper(ComInfoMapper.class);
		
		ComInfoDTO company = companyMapper.adminSelectCompanyDetail(searchMap);
		
		sqlSession.close();
		
		return company;
	}

	/**
	 * <pre>
	 *   업체 가입 승인 처리용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
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

	/**
	 * <pre>
	 *   업체 정보 삭제용 메소드
	 * </pre>
	 * @param comNo
	 * @return
	 */
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

	/**
	 * <pre>
	 *   업체 가입 승인 거부용 메소드
	 * </pre>
	 * @param searchMap
	 * @return
	 */
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

	/**
	 * <pre>
	 *   업체 정보 수정용 메소드(comInfo범위)
	 * </pre>
	 * @param updateCompanyMap
	 * @return
	 */
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

	/**
	 * <pre>
	 *   업체 정보 수정용 메소드(comRecord범위)
	 * </pre>
	 * @param updateRecordMap
	 * @return
	 */
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
