package com.waeating.notice.model.dao;

import java.util.List;

import com.waeating.notice.model.dto.NoticeDTO;

public interface NoticeMapper {
	
	List<NoticeDTO> selectAllNoticeList();
	
	int insertNotice(NoticeDTO newNotice);
	
	int incrementNoticeCCount(int no);
	
	NoticeDTO selectNoticeDeatail(int no);
	

}
