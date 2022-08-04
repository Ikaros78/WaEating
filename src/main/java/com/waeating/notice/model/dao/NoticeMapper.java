package com.waeating.notice.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.common.paging.SelectCriteria;
import com.waeating.notice.model.dto.NoticeAttachDTO;
import com.waeating.notice.model.dto.NoticeDTO;

public interface NoticeMapper {
	
	List<NoticeDTO> selectAllNoticeList(SelectCriteria selectCriteria);
	
	int selectTotalCount(Map<String, String> searchMap);
	
	int incrementNoticeCCount(int no);
	
	NoticeDTO selectNoticeDeatail(int no);

	
	/* 관리자 용도 */
	int adminSelectTotalCount(Map<String, String> searchMap);

	List<NoticeDTO> adminSelectNoticeList(SelectCriteria selectCriteria);

	NoticeDTO adminSelectNoticeDetail(Map<String, String> searchMap);

	int updateNotice(Map<String, String> updateNoticeMap);

	int deleteNotice(String noticeNo);

	int insertNotice(NoticeDTO insertNotice);

	int insertAttach(NoticeAttachDTO noticeAttachDTO);

	List<NoticeAttachDTO> selectNoticeAttachList(Map<String, String> searchMap);
	
	



	

}
