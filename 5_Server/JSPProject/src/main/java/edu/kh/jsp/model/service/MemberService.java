package edu.kh.jsp.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.model.dao.MemberDAO;
import edu.kh.jsp.model.vo.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	

	/** 회원 목록 조회
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll() throws Exception {
		
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectAll(conn);
		
		close(conn);
		
		return memberList;
	}

}
