package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnswerDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Connection getConn() {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!!!");
		}
		return conn;
	}//getConn()
	
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exception!!!");
		}
	}//dbClose()
	
	public ArrayList<Integer> getAnswer() {
		conn = getConn();
		String sql = "select answer from test_answer";
		ArrayList<Integer> answerList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {				
				answerList.add(rs.getInt("answer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getAnswer() Exception!!!");
		} finally {
			dbClose();
		}
		return answerList;
	}//ansCheck()
}
