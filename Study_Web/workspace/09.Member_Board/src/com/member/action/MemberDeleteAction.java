package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.action.Action;
import com.commons.action.ActionForward;
import com.member.study.MemberDAO;
import com.member.study.MemberDTO;

public class MemberDeleteAction implements Action {

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
		} else if (!id.equals("admin")) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자가 아닙니다!');");
			out.println("location.href='boardList.bo';</script>");
			return null;
		} else {
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('관리자로 로그인 하셨습니다!');</script>");
			
			String member_id = request.getParameter("member_id");
			MemberDAO dao = new MemberDAO();
			int succ = dao.deleteMember(member_id);
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			if (succ > 0) {
				out.println("<script>alert('삭제성공!');");
				out.println("location.href='memberListAction.me';</script>");
			} else {
				out.println("<script>alert('삭제성공!');");
				out.println("location.href='memberListAction.me';</script>");
			}
			return null;
		}

	}
 
}
