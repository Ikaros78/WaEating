package com.waeating.ceo.notice.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.com.model.dto.ComNoticeDTO;
import com.waeating.common.paging.SelectCriteria;

public interface ComNoticeMapper {

	int insertComNotice(ComNoticeDTO comNotice);

	List<ComNoticeDTO> selectAllNotice(Map<String, Object> search);

	int selectTotalCount(Map<String, Object> searchMap);

	ComNoticeDTO selectOneNotice(int noticeNo);

	int updateNotice(ComNoticeDTO comNotice);

	int deleteNotice(int noticeNo);
	
	/* 맛집리스트 상세보기 공지사항*/
	List<ComNoticeDTO> selectMatziplistComNotice(int comNo);




}
