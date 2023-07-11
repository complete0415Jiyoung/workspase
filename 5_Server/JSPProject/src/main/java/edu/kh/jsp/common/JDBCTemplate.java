package edu.kh.jsp.common;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	/*DB연결, JDBC 자원 반환, 트랜잭션 제어 같은
	 * 반복적으로 사용되는 JDBC 관련 코드를 모아둔 클래스
	 * 
	 * getConnection() 메소드
	 * 
	 * close( Connection | Statement | ResultSet) 메소드
	 * --> PreparedStatement는 Statement의 자식이므로
	 * 		매개변수 다형성으로 한번에 처리
	 * 
	 * commit(Connection)
	 * rollback(Connection)
	 * 
	 * 
	 * 
	 * */
	
	// 필드
	private static Connection conn; // 초기값 null
	
	// 메소드
	
	//DB 연결 정보를 담고있는 Connection 객체 반환 메소드
	public static Connection getConnection() {
		
		try {
			
			// 계속 공용으로 사용되는 conn 변수에
			// 커넥션이 대입된적 없거나(null)
			// 또는 이전 커넥션이 있었으나 닫힌 경우
			// --> 새로운 커넥션이 필요한 상황!
			
			// 커넥션을 계속 닫고, 만들고...닫고, 만들고를 반복
			// -> 프로그램 하나에 커넥션 1개만을 운용 
			
			if(conn == null || conn.isClosed()) {
				
				Properties prop = new Properties();
				// K,V가 모두 String인 Map, XML파일 입출력에 특화 
				
				// driver.xml 파일 읽어오기
				String filePath = JDBCTemplate.class.getResource("/edu/kh/jsp/sql/driver.xml").getPath();
				
				prop.loadFromXML(new FileInputStream(filePath));
				
				// 커넥션 생성 준비
				String driver = prop.getProperty("driver");
				
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				// 커넥션 생성
				// 1) jdbc 드라이버 메모리 로드
				Class.forName(driver);
				
				// 2) DriverManager를 통해 Connection 생성
				conn = DriverManager.getConnection(url, user, password);
				
				// 3) 트랜잭션 제어를 위한 자동 커밋 비활성화
				conn.setAutoCommit(false);
				
				
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	// close() 메소드 작성
	
	// Connection 반환 메소드
	
	public static void close(Connection conn) {
		try {
			//참조하는 Connection이 있으면서 닫혀있지 않은 경우
			if(conn != null && !conn.isClosed()) {
				// conn.isClosed() : 닫혀있으면 true
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
		// Statement(부모), PreparedStatement(자식) 반환 메소드 (다형성 적용)
	
		public static void close(Statement stmt) {
			try {
				//참조하는 Statement가 있으면서 닫혀있지 않은 경우
				if(stmt != null && !stmt.isClosed()) {
					// stmt.isClosed() : 닫혀있으면 true
					stmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	
			
			// ResultSet 반환 메소드
			public static void close(ResultSet rs) {
				try {
					//참조하는 Statement가 있으면서 닫혀있지 않은 경우
					if(rs != null && !rs.isClosed()) {
						// stmt.isClosed() : 닫혀있으면 true
						rs.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
			// commit 반환 메소드
			
			public static void commit(Connection conn) {
				try {
					//참조하는 Connection가 있으면서 닫혀있지 않은 경우
					if(conn != null && !conn.isClosed()) {
						// conn.isClosed() : 닫혀있으면 true
						conn.commit();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
			// rollback 메소드
			
			public static void rollback(Connection conn) {
				try {
					//참조하는 Connection가 있으면서 닫혀있지 않은 경우
					if(conn != null && !conn.isClosed()) {
						// conn.isClosed() : 닫혀있으면 true
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
	
	
	
	
}



