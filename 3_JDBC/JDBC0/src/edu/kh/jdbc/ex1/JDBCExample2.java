package edu.kh.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 예제 1번 다시 써보면서 분석하기
public class JDBCExample2 {
   public static void main(String[] args) {
	   //JDBC : JAVA가 DB와 연결할 수 있게 해주는 java API
	   
	   //[1단계] : JDBC 객체 참조 변수 선언 (java.sql 패키지)
	   
	   Connection conn = null; 
	   //DB에 연결정보를 담은 객체 
	   //--> JAVA와 DB사이를 연결해 주는 일종의 통로 (Stream과 비슷하게 생각)
	   
	   Statement stmt = null;
	   //Connection 객체를 통해 
	   //JAVA 에서 작성된 SQL을 DB로 전달하여 수행한 후 
	   //결과를 반환 받아 JAVA로 돌아오는 역할의 객체 
	   
	   ResultSet rs = null; //테이블을 담을 수 없으니 행의 집합을 담을 객체를 만들자 
	   //SELECT 질의 성공시 반환 되는
	   //결과 행의 집합 (ResultSet)을 나타내는 객체 
	   
	   try {
		   //[2단계] 참조변수에 알맞은 객체 대입하기
		   
		   //1. DB연결에 필요항 Oracle JDBC Driver 메모리 로드하기 
		   //--> Oracle JDBC Driver가 어디 있는지 만 알려주면 알아서 메모리 로드 
		   
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   //ClassNotfoundException 발생가능성
		   
		   
		   //2. 연결 정보를 담은 Connection생성 
		   //	(이때, DriverManager 객체가 필요함) 
		   // DrivarManager : JDBC 드라이브를 통해 Connection 객체를 만드는 역할
		   
		   String type = "jdbc:oracle:thin:@"; //jdbc 드라이버가 thin 타입이다
		   
		   String ip ="localhost"; //DB 서버 컴퓨터 IP

		   String port =":1521";
		   
		   String sid = ":xe"; //DB이름
			
			String user = "ljy"; //사용자명 
			
			String pw = "ljy1234"; //비밀번호
			
			conn = DriverManager.getConnection( type + ip + port + sid, user, pw);
			//jdbc:oracle:thin:@localhost:1521:xe
			//주소 참조해서 통로 만들어짐
			
			//중간 확인 
			System.out.println(conn); //oracle.jdbc.driver.T4CConnection@5aebe890
		   
			
			// -> 1번의 결과를 이름 오름차순으로 정렬(DB)해서 조회
			//*******JAVA에서 작성된 SQL문은 마지막에 ;(세미콜론)을 찍지 않아야 한다!*****
			// -> "유효하지 않는 문자" 오류 발생시킴
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE ORDER BY EMP_NAME";

			//4. Statement 객체 생성
			stmt = conn.createStatement();
			
			//5. SQl을 Statement에 적재 후 
			//	DB 로 전달하여 
			// 결과를 반환 받아 rs 변수에 대입 
			
			rs = stmt.executeQuery(sql);
			
			//DB에서  SELECT 수행 결과 (ResultSet) 객체를 얻어와 rs가 참조
			
			//[3단계] SELECT 수행 결과를 한행씩 접근하여 원하는 값 얻어오기 
			int sum = 0; //합계를 위한 변수 
			while (rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String deptCode = rs.getString("DEPT_CODE");
				
				//조회 결과 출력 
				System.out.printf("사번 : %d 이름 : %s 급여 : %7d 부서코드 : %s \n", empId, empName, salary, deptCode );
				
				//+ 급여 합계를 구해서 출력(Java)
				sum += salary;
				
			}
			System.out.println("급여합계 : "+ sum);
			   // -> 1번의 결과를 이름 오름차순으로 정렬(DB)해서 조회
			   //    + 급여 합계를 구해서 출력(Java)
			
	   }catch (SQLException e) {
		   e.printStackTrace();
		   
	   }catch (ClassNotFoundException e) {
		   System.out.println("OJDBC 라이브러리 미등록 또는 경로 오타");
		   e.printStackTrace();
	   }finally {
		 //[4단계] 사용한 JDBC 객체 자원 반환(close) 
			// -> 자원 반환 순서는 객체 생성 순서의 "역순"으로!!
			//생성 순서 : Connection, Statement, ResultSet
			//반환 순서: ResultSet, Statement, Connection
		   try {   
			   if(rs != null) rs.close();
			   if(stmt != null) stmt.close();
			   if(conn != null) conn.close();
		   }catch (SQLException e) {
			e.printStackTrace();
		}
	   }
   }	
}
