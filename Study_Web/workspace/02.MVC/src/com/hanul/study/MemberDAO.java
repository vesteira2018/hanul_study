package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;		//연결객체
	private PreparedStatement ps;	//전송객체
	private	ResultSet rs;			//결과객체
	
	//DB 접속 : ojdbc.jar ▶ WEB-INF → lib에 붙여넣기3
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
	
	//DB 접속 해제
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
	
	//회원가입
	public int memberInsert(MemberDTO dto) {
		conn = getConn();	//DB 접속
		String sql = "INSERT INTO member(name, id, pw, age, addr, tel) ";	//SQL Query 작성
		sql += " VALUES(?, ?, ?, ?, ?, ?)";
		int succ = 0;	//성공여부 확인
		
		try {
			ps = conn.prepareStatement(sql);	//SQL Query 문장 전송
			ps.setString(1, dto.getName());		//매개변수 할당
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getTel());
			
			succ = ps.executeUpdate();			//SQL Query 문장 실행
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberInsert() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//memberInsert()
	
	
	//전체회원검색
	public ArrayList<MemberDTO> memberSearchAll() {
		conn = getConn();	//DB 접속
		String sql = "SELECT * FROM Member";	//SQL Query 작성
		ArrayList<MemberDTO> list = new ArrayList<>();	//검색목록을 저장할 컬렉션
		try {
			ps = conn.prepareStatement(sql);	//SQL Query 전송
			rs = ps.executeQuery();	//SQL Query 실행 후 결과객체
			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);
				
//				MemberDTO dto = new MemberDTO();
//				dto.setName(rs.getString("name"));
//				dto.setId(rs.getString("id"));
//				dto.setPw(rs.getString("pw"));
//				dto.setAge(rs.getInt("age"));
//				dto.setAddr(rs.getString("addr"));
//				dto.setTel(rs.getString("tel"));
				
				list.add(dto);
				
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberSearchAll() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return list;
	}//memberSearchAll()
	
	
	//회원정보삭제
	public int memberDelete(String id) {
		conn = getConn();
		String sql = "DELETE FROM Member WHERE id = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberDelete() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//memberDelete()
	
}//class
