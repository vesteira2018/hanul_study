package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.action.Action;
import com.commons.action.ActionForward;

@WebServlet("/MemberFrontController.me")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트가 어떤 요청을 했는가를 파악
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		//System.out.println("uri : " + uri);
		//System.out.println("ctx : " + ctx);
		//System.out.println("command : " + command);
		
		//2. 클라이언트의 요청과 실제 처리할 비즈니스 로직 연결
		//*.me → command ▶ MemberXXXAction Class
		Action action = null;
		ActionForward forward = null;
		
		if (command.equals("/memberLogin.me")) {
			//로그인 화면으로 이동(DB 연동 X)
			forward = new ActionForward();
			forward.setPath("member/loginForm.jsp");
			forward.setRedirect(false);	//단순한 화면 전환이지만 주소가 꼬일 수 있어 forward()
		} else if (command.equals("/memberJoin.me")) {
			//회원가입 화면으로 이동 (DB 연동 X)
			forward = new ActionForward();
			forward.setPath("member/joinForm.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/memberJoinAction.me")) {
			action = new MemberJoinAction();
			forward = action.execute(request, response);
		} else if (command.equals("/memberLoginAction.me")) {
			action = new MemberLoginAction();
			forward = action.execute(request, response);
		} else if (command.equals("/memberLogout.me")) {
			action = new MemberLogoutAction();
			forward = action.execute(request, response);
		} else if (command.equals("/memberListAction.me")) {
			action = new MemberListAction();
			forward = action.execute(request, response);
		} else if (command.equals("/memberDeleteAction.me")) {
			action = new MemberDeleteAction();
			forward = action.execute(request, response);
		} else if (command.equals("/memberViewAction.me")) {
			action = new MemberViewAction();
			forward = action.execute(request, response);
		} else if (command.equals("/memberDetailAction.me")) {
			action = new MemberDetailAction();
			forward = action.execute(request, response);
		} else if (command.equals("/memberUpdateAction.me")) {
			action = new MemberUpdateAction();
			forward = action.execute(request, response);
		}
		
		
		//3. 페이지 전환 : sendRedirect(), forward()
		if (forward != null) {
			if (forward.isRedirect()) {	//true : sendRedirect() 주소변환O
				response.sendRedirect(forward.getPath());
			} else {					//false : forward() 주소변환X
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}//if forward.isRedirect()
		}
		
	}

}//class
