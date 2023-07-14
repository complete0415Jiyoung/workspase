package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception {

		// Connection 얻어오기
		Connection conn = getConnection();

		// DAO 수행
		Member loginMember = dao.login(conn, mem);		

		// Conncetion 반환
		close(conn);

		return loginMember;
	}

	/**
	 * 회원가입서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem)throws Exception {
		Connection conn = getConnection(); //DBCP에서 얻어옴

		// DAO 수행
		int result = dao.signUp(conn, mem);		

		//트렌젝션 처리
		if(result> 0)conn.commit();
		else conn.rollback();

		// Conncetion 반환
		close(conn);

		//결과 반환
		return result;
	}

	/**
	 * 회원 정보 수정 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member mem) throws Exception {

		Connection conn= getConnection();

		int result= dao.updateMember(conn,mem);


		if(result>0) commit(conn);
		else rollback(conn);


		close(getConnection());

		return result;
	}
	/**
	 * qlalfqjsg비밀번호 변경ㅇ 서비스
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception {
		Connection conn = getConnection(); //DBCP에서 얻어옴

		int result = dao.changePw(conn, currentPw, newPw, memberNo);		

		if(result> 0)conn.commit();
		else conn.rollback();

		close(conn);

		return result;
	}

	/**
	 * 회원탈퇴
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception {

		Connection conn = getConnection(); //DBCP에서 얻어옴

		int result = dao.secession(conn, memberNo, memberPw);		

		if(result> 0)conn.commit();
		else conn.rollback();

		close(conn);

		return result;
	}

	/**
	 * 이메일 중복 검사 
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */

	public int emailDupCheck(String memberEmail) throws Exception {

		Connection conn = getConnection(); //DBCP에서 만들어 둔 커넥션 얻어오기

		int result = dao.emailDupCheck(conn, memberEmail);

		close(conn);

		return result;
	}

	/**
	 * 닉네임 중복 검사 
	 * @return
	 */
	public int nicknameDupCheck(String memberNickname) throws Exception {
		Connection conn = getConnection(); 

		int result = dao.nicknameDupCheck(conn,memberNickname );

		close(conn);

		return result;
	}

	/**
	 * 회원정보 조회
	 * @param memberEmail
	 * @return mem
	 * @throws Exception
	 */
	public Member selectOne(String memberEmail) throws Exception {

		Connection conn = getConnection(); 

		Member member = dao.selectOne(conn,memberEmail);

		close(conn);

		return member;

	}
	/**
	 * 전체 회원 정보 조회
	 * @param member
	 * @return member
	 * @throws Exception
	 * 
	 */
	public List<Member> selectAll() throws Exception {
		Connection conn = getConnection(); 

		List <Member> list = dao.selectAll(conn);

		close(conn);

		return list;
	}
	
}
