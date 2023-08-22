package com.ncs.test.member.model.vo;

import java.sql.Date;

public class Member {
	
	private String memberId;

	private String memberPwd;

	private String memberName;

	private Date memberEnrollDate; // (import : java.sql.Date)

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String memberPwd, String memberName, Date memberEnrollDate) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberEnrollDate = memberEnrollDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getMemberEnrollDate() {
		return memberEnrollDate;
	}

	public void setMemberEnrollDate(Date memberEnrollDate) {
		this.memberEnrollDate = memberEnrollDate;
	}

}
