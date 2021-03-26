package com.hanul.answer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnswerDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//답이 저장되어있는 DB와 연결
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
	
	//DB 연결 해제
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
	
	//답안지 호출
	public ArrayList<Integer> answerList() {
		conn = getConn();
		String sql = "SELECT ans FROM Answer";
		ArrayList<Integer> answer = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				answer.add(rs.getInt("ans"));
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("answerList() Exception!");
		} finally {
			dbClose();
		}//try-catch
		
		return answer;
	}//answerList()

}//class
