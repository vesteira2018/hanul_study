package com.hanul.study;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper;
	static {
		String resource = "com/hanul/mybatis/SqlMapConfig.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SqlSessionFactory Exception!");
		}//try-catch
	}//static(초기화블럭)
	
	//memberSearchAllJson01() : 전체회원 목록을 검색 후 JSON 구조로 리턴
	public String memberSearchAllJson01() {
		SqlSession session = sqlMapper.openSession();
		List<MemberDTO> list = null;
		list = session.selectList("memberSearchAllJson");
		session.close();
		
		JSONArray array = new JSONArray();
		JSONObject object = null;
		for (MemberDTO dto : list) {
			object = new JSONObject();
			object.put("member", dto);
			array.add(object);
		}
		String json = array.toString();
		
		return json;
	}//memberSearchAllJson01()
	
	//memberSearchAllJson02() : 전체회원 목록을 검색 후 JSON 구조로 리턴
	public String memberSearchAllJson02() {
		SqlSession session = sqlMapper.openSession();
		List<MemberDTO> list = null;
		list = session.selectList("memberSearchAllJson");
		session.close();
		
		JSONArray array = JSONArray.fromObject(list);
		String json = array.toString();
		
		return json;
	}//memberSearchAllJson02()
}//class
