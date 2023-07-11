package edu.kh.oop.metho.model.vo;

public class Member {

	
	//필드 
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
	//기본생성자 
	public Member () { }
	
	//매개변수 생성자 (필드 모두 초기화 용도)  
	public Member (String memberId,String memberPw, String memberName,int memberAge) { 
		//오버로딩 적용 (매개변수의 갯수가 다름) 
	
	//전달 받은 값을 필드로 옮겨담기 
	this.memberId = memberId;
	this.memberPw = memberPw;
	this.memberName = memberName;
	this.memberAge = memberAge;
	
	
	}

	

	//기능(getter / setter)
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
				//get + 필드
		return memberName;
	}

	
	//매개 변수로 전달 받은 memberName 필드 대입
	//(매개변수 == 전달 받은 값을 지니고 있는 변수 )
	public void setMemberName(String memeberName) {
				//set + 필드명
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	
	
	
	
}
