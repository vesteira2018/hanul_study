package com.hanul.poketmon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PoketmonDAO {
	private Connection conn;		//연결객체
	private PreparedStatement ps;	//전송객체
	private ResultSet rs;			//결과객체
	
	//DB접속 : ojdbc6.jar ▶ WebContent > WEB-INF > lib 붙여넣기(등록)
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
	
	//DB접속해제
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();	
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose() Exception!!!");
		}
	}//dbClose()
	
	//답안체크
	public ArrayList<String> getAnswer()  {
		conn = getConn();	//DB접속
		String sql = "select answer from poketmon";	
		ArrayList<String> answerlist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);	//SQL 쿼리 전송
			rs = ps.executeQuery();				//쿼리 실행
			while(rs.next()) {
				answerlist.add(rs.getString("answer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getAnswer() Exception!!!");
		}finally {
			dbClose();//DB접속해제
		}
		return answerlist;
	}//getAnswer()
	
}//class
