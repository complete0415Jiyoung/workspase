package edu.kh.oarr.model.vo;

public class Member {

	//필드 (==멤버변수)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region; //지역 (서울, 경기, 충북, 전남...)
	
	
	//생성자
	
	public Member() {} //기본 생성자

	public Member(String memberId, String memberPw,String memberName,
				int memberAge,String region) { //매개변수 생성자
		
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
		
	}
	
	
	//메소드 
	//getter / setter
	
	//memberId
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId =memberId; 
		return;
		//모든 메소드는 종료시 호출한 곧으로 돌아가는 
		//return구문이 작성 되어야 하지만 
		//단, void일 경우 생략 가능
		// -> 생략시 컴파일러가 자동으로 추가
		
	}
	
	//memberPw
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	//memberName
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String getMemberName) {
		this. memberName= memberName;
	}
	
	//memberAge
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	//region
	public String getRegion() {
		return region;
	}
	public void setRegione(String region) {
		this.region = region;
	}
}
