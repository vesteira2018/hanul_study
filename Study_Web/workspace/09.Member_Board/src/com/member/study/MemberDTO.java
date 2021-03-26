package com.member.study;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	private String Member_id, Member_pw, Member_name;
	private int Member_age;
	private String Member_gender, Member_email;
	
	public MemberDTO() {}

	public MemberDTO(String member_id, String member_pw, String member_name, int member_age, String member_gender,
			String member_email) {
		super();
		Member_id = member_id;
		Member_pw = member_pw;
		Member_name = member_name;
		Member_age = member_age;
		Member_gender = member_gender;
		Member_email = member_email;
	}

	public String getMember_id() {
		return Member_id;
	}

	public void setMember_id(String member_id) {
		Member_id = member_id;
	}

	public String getMember_pw() {
		return Member_pw;
	}

	public void setMember_pw(String member_pw) {
		Member_pw = member_pw;
	}

	public String getMember_name() {
		return Member_name;
	}

	public void setMember_name(String member_name) {
		Member_name = member_name;
	}

	public int getMember_age() {
		return Member_age;
	}

	public void setMember_age(int member_age) {
		Member_age = member_age;
	}

	public String getMember_gender() {
		return Member_gender;
	}

	public void setMember_gender(String member_gender) {
		Member_gender = member_gender;
	}

	public String getMember_email() {
		return Member_email;
	}

	public void setMember_email(String member_email) {
		Member_email = member_email;
	}
	
	
}
