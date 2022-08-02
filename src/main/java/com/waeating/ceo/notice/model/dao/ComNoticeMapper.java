package com.waeating.ceo.notice.model.dao;

import java.util.List;
import java.util.Map;

import com.waeating.ceo.notice.model.dto.ComNoticeDTO;
import com.waeating.common.paging.SelectCriteria;

public interface ComNoticeMapper {

	int insertComNotice(ComNoticeDTO comNotice);

	List<ComNoticeDTO> selectAllNotice(SelectCriteria selectCriteria);

	int selectTotalCount(Map<String, String> searchMap);

	ComNoticeDTO selectOneNotice(int noticeNo);

	int updateNotice(ComNoticeDTO comNotice);

	int deleteNotice(int noticeNo);




}
