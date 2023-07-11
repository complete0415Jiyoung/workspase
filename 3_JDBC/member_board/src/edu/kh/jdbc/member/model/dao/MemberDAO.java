package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close; //임포트 추가

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.vo.Member;

//DAO : (Date Access Object) 데이터가 저장되어 있는 DB ,파일 등에 접급하는 객체
//				-> DB에 법근할 수 있다  ==SQL 수행하고 결과를 반환 받을 수 있다.


//Java에서 DB에 접근하고 결과를 반환 받기 위한 프로그래밍를 QPI를 제공
//==JDBC(Connection Statement, PreparedStatement, ResuitSet)
public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	
	private Properties prop = null;
	//MAP인데 K,V 모두 String ,외부 파일 XML 입출력에 특화
	
	
	//MemberDAO 기본생성자
	public MemberDAO() {
		//MemberDAO 객체 생성시 
		//member-sql.xml 파일 내용 읽어와
		//properties 객체 생성
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	/**
	 * 아이디 중복 검사 DAO 메소드 
	 * @param conn
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int duplicateCheck(Connection conn, String memberId)throws Exception {
		//throw : 호출한 메소드로 예외 던짐 
		
		//1) 결과 저장용 변수
		int result = 0;
			
		try {
			//2) SQL 작성
			String sql= "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? AND SECESSION_FL ='N'";
			
			//3) preparedStatement 객체 생성 (Connection, SQL 필요)
			pstmt = conn.prepareStatement(sql);

			//4) 위치홀더 '?' 에 말맞은 값 세팅
			pstmt.setString(1, memberId);
			
			//5) SQl 수행 후 결과 반환 받기 
			rs= pstmt.executeQuery(); //SELECT 수행 결과 ResultSet  반환 받음
			
			//6) 조회 결과를 한행씩 반복하여 원하는 컬럼값 얻어오기 
			//-> 아이디 중복 검사 SELECT 결과는 0또는 1 이라는 한행 결과 무조건 나옴
			//-> while 문 보다 if 문 사용하는 것이 효과적
			
			if(rs.next()) {
				result =rs.getInt(1); //1은 컬럼 순서 

			}
			
		}finally { //try - finally 구문 (catch는 throw에 의해 생략)
			//7) 사용한 JDBC 자원 반환(conn제외)
			close(rs);
			close(pstmt);
		}
		
		//8) SQL 수행 결과 반환 
		return result;
	}



	/**
	 * 회원가입 DAO
	 * @param conn
	 * @param signUpMember
	 * @return result 
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member signUpMember)throws Exception{
	
		int result = 0; //결과 저장용 변수 
		try {
			// 1) SQL 작성(Properties 에 저장된 SQL 얻어오기)
			String sql= prop.getProperty("signUp");
			
			//2) preraredStatement 객체 생성(Connection, SQL필요)
			pstmt=conn.prepareStatement(sql);
					
			
			//3) 위치홀더 '?' 알맞은 값 세팅
			pstmt.setString(1, signUpMember.getMemberId());
			pstmt.setString(2, signUpMember.getMemberPw());
			pstmt.setString(3, signUpMember.getMemberName());
			pstmt.setString(4, signUpMember.getMemberGender()+"");
			
				//getMemberGender()의 반환형은 char
				//setString() 매개변수는 String 
				//-> 자료형 불일치로 오류 
				
				//--> char자료형 + ""(빈문자열)
				//1 + 1=2
				//1 + "1"=11
			
			
			//4) SQL(INSET) 수행후 결과 반환 받기
			result =pstmt.executeUpdate(); //성공한 행의 개수 반환
			
			
		} finally {
			//5) 사용한 JDBC 자원 반환(Connection 제외)
			close(pstmt);
			
		}
	
		return result;
	}



	/**로그인 DAO
	 * @param conn
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, Member mem) throws Exception{
		
		//결과 저장용 변수 
		Member loginMember = null;
		
		try {
			//1. SQL 작성(properties에서 얻어오기)
			String sql = prop.getProperty("login");
			
			//2. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			
			//3. 위치홀더 '?'에 알맞은 값 수행 
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			
			//4) SQL(SELECT) 수행 후 결과 반환 받기
			//반환 결과 (ResultSet) 받기 (rs변수 사용)
			rs= pstmt.executeQuery();
			
			//5) if 또는 while 문을 이용하여 rs에 한행 씩 접근 하여 원하는 값 얻어오기
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				char memberGender = rs.getString("MEMBER_GENDER").charAt(0);
				Date enrollDate = rs.getDate("ENROLL_DATE");
				
				//6) 얻어온 컬럼 값을 Member객체에 생성하여 loginMember 변수에 저장
				loginMember = new Member();
				loginMember.setMemeberNum(memberNo);
				loginMember.setMemberId(memberId);
				loginMember.setMemberName(memberName);
				loginMember.setMemberGender(memberGender);
				loginMember.setEnrollDate(enrollDate);
			}
			
			
			
			
		} finally {
			//7) 사용한 JDBC객체 자원 반환 (Connection제외)
			close(rs);
			close(pstmt);
			
		}
		
		
		//8) DAO 수행 결과 반환 
		return loginMember;
	}



	/**가입된 회원 정보 조회
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll(Connection conn) throws Exception {
		//결과 저장용 변수 
		List<Member> memberList =new ArrayList<Member>();

		try {
			
			//1) SQL작성
			String sql =prop.getProperty("selectAll");
			
			//2) Statement 생성
			stmt = conn.createStatement();
			
			//3) SQL(SELECT) 수행후 결과 (ResultSet) 반환 받기
			rs= stmt.executeQuery(sql);
			
			//4) ResultSet을 한 행씩 접근(rs.next())하여 조회된 컬럼 값을 얻어와
			// Member 객체에 저장 (While 문 사용) 
			while(rs.next()) {
				String memberID = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				Date enrollDate= rs.getDate("ENROLL_DATE");
				
				Member member = new Member();
				member.setMemberId(memberID);
				member.setMemberName(memberName);
				member.setEnrollDate(enrollDate);
				
				//컬럼 값이 저장된 Member 객체를 List에 추가 
				memberList.add(member);
						
				
				
			}
			
		} finally {
			//7) 사용한 JDBC객체 자원 반환 (Connection제외)
			close(rs);
			close(pstmt);
			
		}
		
		
		//8) DAO 수행 결과 반환 
		return memberList;
	}



	/** 내 정보 수정 DAO
	 * @param conn
	 * @param updateMember
	 * @return result 
	 * @throws Exception
	 */
	public int updateMyInfor(Connection conn, Member updateMember) throws Exception{
		int result = 0; //결과 저장용 변수 
		try {
			// 1) SQL 작성(Properties 에 저장된 SQL 얻어오기)
			String sql= prop.getProperty("updateMyInfo");
			
			//2) preparedStatement 객체 생성(Connection, SQL필요)
			pstmt = conn.prepareStatement(sql);
					
			//3) 위치홀더 '?' 알맞은 값 세팅
			pstmt.setString(1, updateMember.getMemberName());
			pstmt.setString(2, updateMember.getMemberGender()+"");
			pstmt.setInt(3, updateMember.getMemeberNum());
			
			
			//4) SQL(UPDATE) 수행후 결과 반환 받기
			result = pstmt.executeUpdate(); //성공한 행의 개수 반환
			
			
		} finally {
			//5) 사용한 JDBC 자원 반환(Connection 제외)
			close(pstmt);
			
		}
		
		//6) DAO 결과 반환 
		return result;
	}



	/** 비밀번호 변경 DAO
	 * @param conn
	 * @param memeberNum
	 * @param crrentPw
	 * @param newPw
	 * @return result
	 * @throws Exception
	 */
	public int updatePw(Connection conn, int memeberNum, String crrentPw, String newPw) throws Exception{
		
		int result = 0;
		
		try {

			//1) SQL문 만들기 
			String sql = prop.getProperty("updatePw");
			
			//2) PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//3) 위치홀더에 알맞는 값 대입
			pstmt.setString(1, newPw);
			pstmt.setInt(2, memeberNum);
			pstmt.setString(3, crrentPw);
			
			
			//4) SQL 수행 후 결과 반환
			result = pstmt.executeUpdate();
			
			
		} finally {
			//5) 사용한 JDBC 객체 자원 반환
			close(pstmt);
			
		}
		
		//DAO 반환
		return result;
	}



	/** 회원탈퇴 DAO 
	 * @param conn
	 * @param memeberNum
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, int memeberNum, String memberPw) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			
			//위치홀더 
			pstmt.setInt(1, memeberNum);
			pstmt.setString(2, memberPw);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}
			
}
