package edu.kh.jsp.model.dao;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import edu.kh.jsp.model.vo.Member;

public class MemberDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;


	/** 회원 목록 조회
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll(Connection conn) throws Exception {

		List<Member> memberList = new ArrayList<Member>();

		try {
			String sql = "SELECT * FROM MEMBER ORDER BY MEMBER_NO";

			stmt = conn.createStatement(); 

			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberPw = rs.getString("MEMBER_PW");
				String memberName = rs.getString("MEMBER_NM");
				char memberGender = rs.getString("MEMBER_GENDER").charAt(0);
				Date enrollDate = rs.getDate("ENROLL_DATE");
				char secessionFlag = rs.getString("SECESSION_FL").charAt(0);

				Member member = new Member(memberNo, memberId, memberPw, memberName, memberGender, enrollDate, secessionFlag);

				memberList.add(member);
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return memberList;
	}







}
