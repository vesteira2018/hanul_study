package com.hanul.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {	//실제 DB와 연동하여 요구사항 처리 후 리턴
	private Connection conn;		//DB 연결객체
	private PreparedStatement ps;	//DB 전송객체
	private ResultSet rs;			//결과객체 : select quary
	
	//DB 접속 메소드
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//동적로딩
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!");
		}//try-catch
		return conn;
	}//getConn()
	
	//DB 종료 메소드 : conn, ps, rs → 역순으로 종료
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
	
	//번호 검색 메소드
	public ResultSet checkNum(int num) {
		conn = getConn();	//DB접속
		//String sql = "select * from tblMember where num = " + num;	//Statement
		String sql = "select * from tblMember where num = ?";	//PreparedStatement
		try {
			ps = conn.prepareStatement(sql);	//전송객체
			ps.setInt(1, num); //매개변수 값을 전달(세팅)
			rs = ps.executeQuery();	//쿼리를 실행 후에 결과가 저장된 객체
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkNum() Exception!");
		}
		return rs;
		
	}//checkNum()
	
	//회원등록 메소드
	public int insertMember(MemberDTO dto) {
		conn = getConn();	//DB 접속
		String sql = "insert into tblMember values(?, ?, ?, ?, ?)";	//SQL Query 작성
		int succ = 0;	//성공여부를 판단
		try {
			ps = conn.prepareStatement(sql);	//전송객체
			ps.setInt(1, dto.getNum());			//매개변수 값 세팅
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setString(4, dto.getAddr());
			ps.setString(5, dto.getTel());
			succ = ps.executeUpdate();			//쿼리 실행
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertMember() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//insertMember()
	
	//회원삭제 메소드
	public int deleteMember(int num) {
		conn = getConn();
		String sql = "delete from tblMember where num = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteMember() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//deleteMember()
	
	
	//회원수정 메소드
	public int updateMember(MemberDTO dto) {
		conn = getConn();
		String sql = "update tblMember ";
		sql += " set name=?, age=?, addr=?, tel=? ";
		sql += " where num=?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());			//매개변수 값 세팅
			ps.setInt(2, dto.getAge());
			ps.setString(3, dto.getAddr());
			ps.setString(4, dto.getTel());
			ps.setInt(5, dto.getNum());
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateMember() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return succ;
	}//updateMember();
	
	
	//전체회원 목록 검색 메소드
	public ArrayList<MemberDTO> searchAllMember() {
		conn = getConn();	//DB 접속
		MemberDTO dto = null;
		String sql = "select * from tblMember";	//SQL Query 작성
		ArrayList<MemberDTO> list = new ArrayList<>();	//최종결과
		try {
			ps = conn.prepareStatement(sql);	//SQL 문장 전송
			rs = ps.executeQuery();	//문장을 실행하고 결과 객체
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				
				dto = new MemberDTO(num, name, age, addr, tel);
				list.add(dto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchAllMember() Exception!");
		} finally {
			dbClose();	//DB접속해제
		}//try-catch
		return list;
	}//searchAllMember()
	
	//이름 검색 메소드
	public ArrayList<MemberDTO> searchNameMember(String searchName) {
		conn = getConn();
		String sql = "select * from tblMember where lower(name) like ? or upper(name) like ? order by num asc";
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchName + "%");
			ps.setString(2, "%" + searchName + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchNameMember() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return list;
	}//searchNameMember()
	
	
	//주소 검색 메소드
	public ArrayList<MemberDTO> searchAddrMember(String searchAddr) {
		conn = getConn();
		String sql = "select * from tblMember where upper(addr) like upper(?) order by num";
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchAddr + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();                        
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchAddrMember() Exception!");
		} finally {
			dbClose();
		}
		
		return list;
	}//searchAddrMember()
	
	
	//전화번호 검색 메소드
	public ArrayList<MemberDTO> searchTelMember(String searchTel) {
		conn = getConn();
		String sql = "select * from tblMember where tel like ? order by num";
		ArrayList<MemberDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchTel + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchTelMember() Exception!");
		} finally {
			dbClose();
		}
		
		return list;
	}//searchTelMember
	
	//출력메소드
	public void display(ArrayList<MemberDTO> list) {
		if (list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for (MemberDTO dto : list) {
				System.out.print(dto.getNum() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.print(dto.getAge() + "\t");
				System.out.print(dto.getAddr() + "\t");
				System.out.print(dto.getTel() + "\n");
			}//for
		}//if
		
	}//display()
	
}//class
