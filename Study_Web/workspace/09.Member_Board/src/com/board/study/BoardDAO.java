package com.board.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//DB 접속
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String pw = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!");
		}
		
		return conn;
	}//getConn()
	
	//DB 접속 해제
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exception!");
		}
	}//dbClose()
	
	//글 등록
	public int boardInsert(BoardDTO dto) {
		conn = getConn();
		String sql = "";
		int succ = 0;
		try {
			//글 번호(board_num)을 먼저 검색한 후에
			//등록할 글 번호(b_num)을 결정
			sql = "SELECT MAX(board_num) FROM memberBoard";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int b_num = 0;
			if (rs.next()) {
				//b_num = rs.getInt("MAX(board_num)");
				b_num = rs.getInt(1);
				b_num += 1;
			} else {
				b_num = 1;
			}
			
			//글 등록
			sql = "INSERT INTO memberBoard VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b_num);
			ps.setString(2, dto.getBoard_id());
			ps.setString(3, dto.getBoard_subject());
			ps.setString(4, dto.getBoard_content());
			ps.setString(5, dto.getBoard_file());
			ps.setInt(6, b_num);	//글의 그룹 번호
			ps.setInt(7, 0);
			ps.setInt(8, 0);
			ps.setInt(9, 0);
			
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardInsert() Exception!");
		} finally {
			dbClose();
		}
		
		return succ;
	}//boardInsert()
	
	//등록된 글의 총 개수
	public int getListCount() {
		conn = getConn();
		String sql = "SELECT COUNT(*) FROM memberBoard";
		int listCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				//listCount = rs.getInt("COUNT(*)");
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getListCount() Exception!");
		} finally {
			dbClose();
		}
		
		return listCount;
	}//getListCount()
	
	//전체 글 목록 검색 (Feat : 페이징 처리)
	public ArrayList<BoardDTO> getBoardList(int page, int limit) {
		conn = getConn();
		String sql = "SELECT * FROM ";
		sql += "(SELECT rownum rnum, board_num, board_id, board_subject, ";
		sql += "board_content, board_file, board_re_ref, board_re_lev, ";
		sql += "board_re_seq, board_readcount, board_date from ";
		sql += "(SELECT * FROM memberBoard ORDER BY ";
		sql += "board_re_ref DESC, board_re_seq ASC)) ";
		sql += "WHERE rnum >= ? AND rnum <= ?";
		
		int startRow = (page - 1) * limit + 1;	//읽기 시작할 rownum
		int endRow = startRow + limit - 1;	//읽을 마지막 rownum
		
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_num(rs.getInt("board_num"));
				dto.setBoard_id(rs.getString("board_id"));
				dto.setBoard_subject(rs.getString("board_subject"));
				dto.setBoard_content(rs.getString("board_content"));
				dto.setBoard_file(rs.getString("board_file"));
				dto.setBoard_re_ref(rs.getInt("board_re_ref"));
				dto.setBoard_re_lev(rs.getInt("board_re_lev"));
				dto.setBoard_re_seq(rs.getInt("board_re_seq"));
				dto.setBoard_readcount(rs.getInt("board_readcount"));
				dto.setBoard_date(rs.getString("board_date"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getBoardList() Exception!");
		} finally {
			dbClose();
		}
		
		return list;
	}//getBoardList()
	
	//특정 글 검색
	public BoardDTO getDetail(int board_num) {
		conn = getConn();
		String sql = "SELECT * FROM memberBoard WHERE board_num = ?";
		BoardDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board_num);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setBoard_num(rs.getInt("board_num"));
				dto.setBoard_id(rs.getString("board_id"));
				dto.setBoard_subject(rs.getString("board_subject"));
				dto.setBoard_content(rs.getString("board_content"));
				dto.setBoard_file(rs.getString("board_file"));
				dto.setBoard_re_ref(rs.getInt("board_re_ref"));
				dto.setBoard_re_lev(rs.getInt("board_re_lev"));
				dto.setBoard_re_seq(rs.getInt("board_re_seq"));
				dto.setBoard_readcount(rs.getInt("board_readcount"));
				dto.setBoard_date(rs.getString("board_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getDetail() Exception!");
		} finally {
			dbClose();
		}
		
		return dto;
	}//getDetail()
	
	//조회수 증가
	public void readCount(int board_num) {
		conn = getConn();
		String sql = "UPDATE memberBoard SET board_readcount = ";
		sql += "board_readcount + 1 WHERE board_num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board_num);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("readCount() Exception!");
		} finally {
			dbClose();
		}
	}//readCount()
	
	//작성자 확인
	public boolean isBoardWriter(int board_num, String id) {
		conn = getConn();
		String sql = "SELECT * FROM memberBoard WHERE board_num = ?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board_num);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if (id.equals(rs.getString("board_id"))) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("isBoardWriter() Exception!");
		} finally {
			dbClose();
		}
		
		return result;
	}//isBoardWriter()
	
	//게시글 삭제
	public int boardDelete(int board_num) {
		conn = getConn();
		String sql = "DELETE FROM memberBoard WHERE board_num = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board_num);
			rs = ps.executeQuery();
			succ += 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardDelete() Exception!");
		} finally {
			dbClose();
		}
		
		return succ;
	}//boardDelete()
	
	//게시글 수정
	public int boardUpdate(BoardDTO dto) {
		conn = getConn();
		String sql = "UPDATE memberBoard SET board_subject = ?, board_content = ? WHERE board_num = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getBoard_subject());
			ps.setString(2, dto.getBoard_content());
			ps.setInt(3, dto.getBoard_num());
			rs = ps.executeQuery();
			succ += 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardUpdate() Exception!");
		} finally {
			dbClose();
		}
		
		return succ;
	}//boardUpdate()
	
	//답글등록
	public int boardReply(BoardDTO dto) {
		conn = getConn();
		String sql = "";
		int succ = 0;
		try {
			sql = "SELECT MAX(board_num) FROM memberBoard";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int b_num = 0;
			if (rs.next()) {
				b_num = rs.getInt(1);	//b_num = rs.getInt("MAX(board_num)");
				b_num += 1;
			}
			
			int re_ref = dto.getBoard_re_ref();	//글의 그룹번호
			int re_lev = dto.getBoard_re_lev();	//답글의 깊이
			int re_seq = dto.getBoard_re_seq();	//답글의 순서
			
			sql = "UPDATE memberBoard SET board_re_seq = board_re_seq + 1 ";
			sql += "WHERE board_re_ref = ? AND board_re_seq > ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, re_ref);
			ps.setInt(2, re_seq);
			rs = ps.executeQuery();
			
			re_lev += 1;
			re_seq += 1;
			
			sql = "INSERT INTO memberBoard VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b_num);
			ps.setString(2, dto.getBoard_id());
			ps.setString(3, dto.getBoard_subject());
			ps.setString(4, dto.getBoard_content());
			ps.setString(5, "");	//답글에는 파일 첨부 기능이 없다
			ps.setInt(6, re_ref);
			ps.setInt(7, re_lev);
			ps.setInt(8, re_seq);
			ps.setInt(9, 0);
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardReply() Exception!");
		} finally {
			dbClose();
		}
		
		return succ;
	}//boardReply()
	
	//조건검색
	public ArrayList<BoardDTO> boardSearch(SearchDTO sdto) {
		conn = getConn();
		String sql = "SELECT * FROM memberBoard WHERE ";
		sql += "UPPER(" + sdto.getPart() + ") LIKE UPPER('" + sdto.getSearchData() + "')";
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			//ps.setString(1, sdto.getPart());
			//ps.setString(2, sdto.getSearchData());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_num(rs.getInt("board_num"));
				dto.setBoard_id(rs.getString("board_id"));
				dto.setBoard_subject(rs.getString("board_subject"));
				dto.setBoard_content(rs.getString("board_content"));
				dto.setBoard_file(rs.getString("board_file"));
				dto.setBoard_re_ref(rs.getInt("board_re_ref"));
				dto.setBoard_re_lev(rs.getInt("board_re_lev"));
				dto.setBoard_re_seq(rs.getInt("board_re_seq"));
				dto.setBoard_readcount(rs.getInt("board_readcount"));
				dto.setBoard_date(rs.getString("board_date"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardSearch() Exception!");
		} finally {
			dbClose();
		}
		
		return list;
	}//boardSearch()
}//class
