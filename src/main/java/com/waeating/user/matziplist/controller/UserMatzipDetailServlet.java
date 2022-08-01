package com.waeating.user.matziplist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.review.model.dto.ReviewDTO;
import com.waeating.user.matziplist.model.service.ComService;
import com.waeating.user.review.model.service.ReviewService;

/**
 * Servlet implementation class UserMatzipDetailServlet
 */
@WebServlet("/user/matzip/detail")
public class UserMatzipDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		
//		request.getRequestDispatcher("/WEB-INF/views/user/user_matzip/user_matzip_detail.jsp").forward(request, response);
	
		ComService comService = new ComService();
		ReviewService reviewService = new ReviewService();
		
		ComInfoDTO selectCom = comService.selctComDetail();
		List<ComInfoDTO> selectComMenu = comService.selectComMenu();
		List<ReviewDTO> selectReview = reviewService.selectComReview();
		ReviewDTO selectAvgRatings = reviewService.selectAvgRatings();
		
		System.out.println("selectReview : " + selectReview);
		System.out.println("selectCom : " + selectCom);
		
		String path = "";
		
		if(selectCom != null) {
			
			path = "/WEB-INF/views/user/user_matzip/user_matzip_detail.jsp";
			request.setAttribute("selectCom", selectCom);
			request.setAttribute("selectComMenu", selectComMenu);
			request.setAttribute("selectReview", selectReview);
			request.setAttribute("selectAvgRatings", selectAvgRatings);
			
		}else {
			path = "/WEB-INF/views/common/erroePage.jsp";
			request.setAttribute("message", "맛집 상세보기 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}	
}
