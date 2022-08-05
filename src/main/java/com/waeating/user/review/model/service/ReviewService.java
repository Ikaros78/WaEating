package com.waeating.user.review.model.service;

import static com.waeating.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.waeating.notice.model.dao.NoticeMapper;
import com.waeating.notice.model.dto.NoticeAttachDTO;
import com.waeating.review.model.dao.ReviewMapper;
import com.waeating.review.model.dto.ReviewAttachDTO;
import com.waeating.review.model.dto.ReviewDTO;

public class ReviewService {
	
	private ReviewMapper reviewMapper;

	/**
	 * <pre>
	 *  디테일 화면 리뷰 조회
	 * </pre>
	 * @param comInfo 
	 * @return
	 */
	public List<ReviewDTO> selectComReview(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		List<ReviewDTO> review = reviewMapper.selectReview(comNo);
		
		sqlSession.close();
		
		return review;
	}

	/**
	 * <pre>
	 *  업체 별점 평균 조회
	 * </pre>
	 * @param comNo
	 * @return
	 */
	public ReviewDTO selectAvgRatings(int comNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		ReviewDTO totalCount = reviewMapper.selectAvgRatings(comNo);
		
		sqlSession.close();
		
		return totalCount;
	}

	/**
	 * <pre>
	 *  리뷰 등록용 메소드
	 * </pre>
	 * @param insertReview
	 * @return
	 */
	public int insertReview(ReviewDTO insertReview) {
		
		SqlSession sqlSession = getSqlSession();
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		int result = 0;
		
		int noticeResult = reviewMapper.insertReview(insertReview);
		
		List<ReviewAttachDTO> fileList = insertReview.getReviewAttach();
		
		for(int i = 0 ; i < fileList.size(); i++) {
			fileList.get(i).setReviewNo(insertReview.getReviewNo());
		}
		
		int attachResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachResult += reviewMapper.insertReviewAttach(fileList.get(i));
		}
		
		if(noticeResult > 0 && attachResult == fileList.size()) {
			sqlSession.commit();
			result = 1;
		}else {
			sqlSession.rollback();
		}
			
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *  내 리뷰 보기 리뷰 조회
	 * <pre>
	 * @param selectComMap
	 * @return
	 */
	public ReviewDTO selectReview(Map<String, String> selectComMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		ReviewDTO review = reviewMapper.selectMyReview(selectComMap);
		
		sqlSession.close();
		
		return review;
	}

	/**
	 * <pre>
	 *  내 리뷰보기에서 사진 불러오기 용
	 * </pre>
	 * @param reviewNo
	 * @return
	 */
	public List<ReviewAttachDTO> selectReviewImg(int reviewNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		List<ReviewAttachDTO> review = reviewMapper.selectMyReviewImg(reviewNo);
		
		sqlSession.close();
		
		return review;
		
		
	}

	/**
	 * <pre>
	 *  리뷰 수정 용
	 * </pre>
	 * @param updateReviewMap
	 * @return
	 */
	public int updateReview(Map<String, String> updateReviewMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		int review = reviewMapper.userUpdateReview(updateReviewMap);
		
		if( review > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return review;
	}

	/**
	 * <pre>
	 *  리뷰 삭제용 
	 * </pre>
	 * @param recordNo
	 * @return
	 */
	public int deleteReview(int recordNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		reviewMapper = sqlSession.getMapper(ReviewMapper.class);
		
		int review = reviewMapper.userDeleteReview(recordNo);
		
		if( review > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return review;
	}




}
