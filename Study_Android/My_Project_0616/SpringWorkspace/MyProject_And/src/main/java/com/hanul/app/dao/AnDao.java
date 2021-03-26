package com.hanul.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hanul.app.dto.MemberDTO;

public class AnDao {
	//DataSource Connection
	DataSource dataSource;

	public AnDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/team01");
			/*dataSource = (DataSource) context.lookup("java:/comp/env/CSS");*/
		} catch (NamingException e) {
			e.getMessage();
		}
	}//AnDao()
	
	//회원가입
	public int anJoin(String id, String passwd, String name, String phonenumber, String address) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int state = -100;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into member(id, passwd, name, phonenumber, address) " + 
			               "values('" + id + "', '" + passwd + "', '" + name + "', '" + 
					        			phonenumber + "', '" + address + "' )";
			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();
			
			if (state > 0) {
				System.out.println(state + "삽입성공");				
			} else {
				System.out.println(state + "삽입실패");
			}
			
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		} finally {
			try {				
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
		
		return state;
	}
	
	//로그인
	public MemberDTO anLogin(String id1, String passwd1) {
		MemberDTO dto = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM member WHERE ID = '" + id1;
			query += "' AND passwd = '" + passwd1 + "'";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber");
				String address = rs.getString("address");
				
				dto = new MemberDTO(id, name, phonenumber, address);
			}

			System.out.println("MemberDTO ID : " + dto.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("anLogin DAO Exception!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

}//class
