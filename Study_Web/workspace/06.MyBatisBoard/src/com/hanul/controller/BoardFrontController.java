package com.hanul.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.action.Action;
import com.hanul.action.ActionForward;
import com.hanul.action.BoardDeleteAction;
import com.hanul.action.BoardDetailAction;
import com.hanul.action.BoardInsertAction;
import com.hanul.action.BoardListAction;
import com.hanul.action.BoardSearchAction;
import com.hanul.action.BoardUpdateAction;
import com.hanul.action.BoardUpdateFormAction;

@WebServlet("/BoardFrontController.do")
public class BoardFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 클라이언트가 어떤 요청을 하였는지 파악
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();	//uri-pattern 값 : /mbb/xxx.do
		String ctx = request.getContextPath();	//Context root 값 : /mbb
		String command = uri.substring(ctx.length());	//실제 요청한 페이지 : /xxx.do
//		System.out.println("uri : " + uri);
//		System.out.println("ctx : " + ctx);
//		System.out.println("command : " + command);
		
		// 2. 클라이언트의 요청(*.do ▶ command)과 실제 처리할 Action Class(비지니스 로직) 연결
		// : BoardXXXAction.java
		Action action = null;
		ActionForward forward = null;
		
		if (command.equals("/boardList.do")) {
			action = new BoardListAction();
			forward = action.execute(request, response);
		} else if (command.equals("/boardInsertForm.do")) {
			//글을 작성하는 페이지로 화면 전환만 필요
			forward = new ActionForward();
			forward.setPath("board/boardInsertForm.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/boardInsert.do")) {
			action = new BoardInsertAction();
			action.execute(request, response);
		} else if (command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			forward = action.execute(request, response);
		} else if (command.equals("/boardDelete.do")) {
			action = new BoardDeleteAction();
			forward = action.execute(request, response);
		} else if (command.equals("/boardUpdateForm.do")) {
			action = new BoardUpdateFormAction();
			forward = action.execute(request, response);
		} else if (command.equals("/boardUpdate.do")) {
			action = new BoardUpdateAction();
			forward = action.execute(request, response);
		} else if (command.equals("/boardSearch.do")) {
			action = new BoardSearchAction();
			forward = action.execute(request, response);
		}
		
		// 3. 페이지 전환 (프리젠테이션 로직) : sendRedirect(), forward()
		if (forward != null) {
			if (forward.isRedirect()) {	//true : sendRedirect() _ url이 바뀐다. 가져올 객체가 없을 때.
				response.sendRedirect(forward.getPath());
			} else {	//false : forward() _ url이 바뀌지 않는다. 가져올 객체가 있을 때.
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
		
	}

}
