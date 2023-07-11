package edu.kh.jdbc.board.model.vo;

import java.sql.Date;

public class Reply {

	
	private int replyNo;
	private String replyContent;
	private Date createDate;
	private int memberNo; 
	private String memberName;
	private int boardNo;

	
	
	public Reply() {}



	public Reply(int replyNo, String replyContent, Date createDate, int memberNo, String memberName, int boardNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.boardNo = boardNo;
	}



	public int getReplyNo() {
		return replyNo;
	}



	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}



	public String getReplyContent() {
		return replyContent;
	}



	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", createDate=" + createDate
				+ ", memberNo=" + memberNo + ", memberName=" + memberName + ", boardNo=" + boardNo + ", getReplyNo()="
				+ getReplyNo() + ", getReplyContent()=" + getReplyContent() + ", getCreateDate()=" + getCreateDate()
				+ ", getMemberNo()=" + getMemberNo() + ", getMemberName()=" + getMemberName() + ", getBoardNo()="
				+ getBoardNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}