package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.study.BoardDAO;
import com.board.study.BoardDTO;
import com.commons.action.Action;
import com.commons.action.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String saveFolder = "boardupoload";
//		String realFolder = request.getRealPath(saveFolder);
//		System.out.println(realFolder);
		
		//업로드한 파일이 저장되는 경로
		String realFolder = "D:\\Study_Web\\workspace\\09.Member_Board\\WebContent\\boardupload"; 
		int fileSize = 5 * 1024 * 1024; //최대용량 : 5MB
		
		//파일업로드 처리
		MultipartRequest multi = null;
		//중복파일명 방지
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", policy);
		
		BoardDTO dto = new BoardDTO();
		dto.setBoard_id(multi.getParameter("board_id"));
		dto.setBoard_subject(multi.getParameter("board_subject"));
		dto.setBoard_content(multi.getParameter("board_content"));
		//System.out.println(multi.getParameter("board_file"));
		//System.out.println(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		dto.setBoard_file(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		
		BoardDAO dao = new BoardDAO();
		int succ = dao.boardInsert(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (succ > 0) {
			out.println("<script>alert('등록성공!');");
			out.println("location.href='boardList.bo';</script>");
		} else {
			out.println("<script>alert('등록실패!');");
			out.println("location.href='boardList.bo';</script>");
		}
		return null;
	}
	
}
