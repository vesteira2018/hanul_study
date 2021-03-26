package com.hanul.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//클라이언트 요청 : 매개변수를 가져온다
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		
		//비지니스 로직
		BoardDAO dao = new BoardDAO();
		dao.boardDelete(b_num);
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.do");
		forward.setRedirect(true);	//sendRedirect() 방식
		
		return forward;
	}
	
}
