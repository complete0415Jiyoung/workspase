package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.RequestDispatcher;

public class UserDAO {
	
	Properties prop = null;
	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null; 

	public UserDAO() {

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","community_ljy","community1234");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public UserDTO selectUser(int userNo) throws Exception {
		
		UserDTO user = new UserDTO();
		
		try{
			String sql = "SELECT * FROM TB_USER WHERE USER_NO=?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setUserNo(rs.getInt(1));
				user.setUserId(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setUserAge(rs.getInt(4));
			}
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
				if(rs != null) conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return user;
	
	}

}
