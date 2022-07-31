package com.waeating.notice.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.notice.model.dto.NoticeDTO;

public interface NoticeMapper {
	
	List<NoticeDTO> selectAllNoticeList(SelectCriteria selectCriteria);
	
	int insertNotice(NoticeDTO newNotice);
	
	int selectTotalCount(Map<String, String> searchMap);
	
	int incrementNoticeCCount(int no);
	
	NoticeDTO selectNoticeDeatail(int no);



	

}
