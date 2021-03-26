package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.action.Action;
import com.commons.action.ActionForward;
import com.member.study.MemberDAO;
import com.member.study.MemberDTO;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if (id == null) {
			forward.setPath("memberLogin.me");
			forward.setRedirect(true);
			return forward;
		} else {
			String member_id = request.getParameter("member_id");
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getDetailMember(member_id);
			request.setAttribute("dto", dto);
			
			forward.setPath("member/member_detailForm.jsp");
			forward.setRedirect(false);
			
			return forward;
		}
		
	}

}
