package com.waeating.admin.usagelog.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.waitingRecord.model.dto.WaitingRecordDTO;

public class AdminUsageLogService {

	
	
	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		return 0;
	}

	public List<WaitingRecordDTO> AdminSelectLogList(SelectCriteria selectCriteria) {
		return null;
	}

}
