package com.hanul.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//DB 접속 메소드
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!");
		}//try-catch
		
		return conn;
	}//getConn()
	
	//DB 종료 메소드
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exception!");
		}//try-catch
	}//dbClose()
	
	//번호 중복검사 메소드
	public ResultSet checkNum(int num) {
		conn = getConn();
		String sql = "SELECT * FROM tblBook WHERE num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkNum() Exception!");
		} //try-catch
		
		return rs;
	}//checkNum()
	
	//도서 등록 메소드
	public int insertBook(BookDTO dto) {
		conn = getConn();
		String sql = "INSERT INTO tblBook VALUES(?, ?, ?, ?, ?)";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getNum());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getCompany());
			ps.setString(4, dto.getName());
			ps.setInt(5, dto.getCost());
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertBook() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//insertBook()
	
	//도서 정보 삭제 메소드
	public int deleteBook(int num) {
		conn = getConn();
		String sql = "DELETE FROM tblBook WHERE num = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteBook() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//deleteBook()
	
	//도서 정보 수정 메소드
	public int updateBook(BookDTO dto) {
		conn = getConn();
		String sql = "UPDATE tblBook ";
		sql += " SET title=?, company=?, name=?, cost=? WHERE num=?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getCompany());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getCost());
			ps.setInt(5, dto.getNum());
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateBook() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//updateBook()
	
	//전체 목록 보기 메소드
	public ArrayList<BookDTO> searchAllBook() {
		conn = getConn();
		BookDTO dto = null;
		String sql = "SELECT * FROM tblBook ORDER BY num ASC";
		ArrayList<BookDTO> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String company = rs.getString("company");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				
				dto = new BookDTO(num, title, company, name, cost);
				list.add(dto);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchAllBook() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return list;
	}//searchAllBook();
	
	//도서 제목 검색 메소드
	public ArrayList<BookDTO> searchTitleBook(String searchTitle) {
		conn = getConn();
		String sql = "SELECT * FROM tblBook WHERE UPPER(title) LIKE ? or LOWER(title) LIKE ?";
		ArrayList<BookDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchTitle + "%");
			ps.setString(2, "%" + searchTitle + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setCompany(rs.getString("company"));
				dto.setName(rs.getString("name"));
				dto.setCost(rs.getInt("cost"));
				list.add(dto);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchTitleBook() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return list;
	}//searchTitleBook()
	
	//도서 주문 메소드
	public BookDTO orderBook(int num) {
		conn = getConn();
		//책 제목과 단가만 호출해서 출력하도록 유도
		String sql = "SELECT title, cost FROM tblBook WHERE num = ?";
		BookDTO dto = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto = new BookDTO();
				dto.setTitle(rs.getString("title"));
				dto.setCost(rs.getInt("cost"));
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("orderBook() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return dto;
	}//orderBook()
	
	//출력메소드
	public void display(ArrayList<BookDTO> list) {
		if (list.size() == 0) {
			System.out.println("검색 결과가 존재하지 않습니다.");
		} else {
			for (BookDTO dto : list) {
				System.out.print(dto.getNum() + "\t");
				System.out.print(dto.getTitle() + "\t");
				System.out.print(dto.getCompany() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.print(dto.getCost() + "\n");
			}//for
		}//if
	}//display()
	
}//class
