package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.study.BoardDAO;
import com.board.study.BoardDTO;
import com.commons.action.Action;
import com.commons.action.ActionForward;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//세션
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getDetail(board_num);
		if (!id.equals(dto.getBoard_id())) {	//로그인 id와 작성자 id가 같지 않으면
			dao.readCount(board_num);			//조회수 증가
		}
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		if (id == null) {
			forward.setPath("memberLogin.me");
			forward.setRedirect(false);
			return forward;
		}
		forward.setPath("board/board_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
