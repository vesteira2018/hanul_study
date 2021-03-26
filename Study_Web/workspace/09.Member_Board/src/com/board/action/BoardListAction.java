package com.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.study.BoardDAO;
import com.board.study.BoardDTO;
import com.commons.action.Action;
import com.commons.action.ActionForward;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//세션을 받는다
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		//비지니스 로직 : DB 접속 후 전체 글목록 검색, 페이징 처리
		BoardDAO dao = new BoardDAO();
		//등록된 글의 총 개수
		int listCount = dao.getListCount();
		//System.out.println(listCount);
		
		int page = 1; //시작페이지 번호
		int limit = 10; //한 페이지에 표시되는 글의 목록 개수
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ArrayList<BoardDTO> list = dao.getBoardList(page, limit);	//전체글 목록 검색
		int maxPage = (int)((double)listCount / limit + 0.9);	//전체 페이지 수
		
		//현재 페이지에서 보여줄 시작 페이지 수(1, 11, 21, ..)
		int startPage = (((int)((double)page / limit + 0.9)) - 1) * limit + 1;
		
		//현재 페이지에서 보여줄 마지막 페이지 수(10, 20, 30, ..)
		int endPage = maxPage;
		if (endPage > startPage + limit - 1) {
			endPage = startPage + limit - 1;
		}
		
		request.setAttribute("page", page);				//현재 페이지 수
		request.setAttribute("maxPage", maxPage);		//전체 페이지수
		request.setAttribute("startPage", startPage);	//첫 페이지
		request.setAttribute("endPage", endPage);		//끝 페이지
		request.setAttribute("listCount", listCount);	//전체 글의 개수
		request.setAttribute("list", list); 			//전체 글 목록
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		if (id == null) {	//로그인이 되지 않는 상태
			forward.setPath("memberLogin.me");
			forward.setRedirect(true);
			
		} else {
			forward.setPath("board/board_list.jsp");
			forward.setRedirect(false);
			
		}
		
		return forward;
	}//execute()

}//class
