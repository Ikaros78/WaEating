package com.waeating.ceo.notice.model.dao;

import java.util.List;

import com.waeating.ceo.notice.model.dto.ComNoticeDTO;

public interface ComNoticeMapper {

	int insertComNotice(ComNoticeDTO comNotice);

	List<ComNoticeDTO> selectAllNotice();


}
