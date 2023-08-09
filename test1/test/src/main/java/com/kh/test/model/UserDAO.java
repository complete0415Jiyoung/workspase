package com.kh.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UserDAO {
	
	Properties prop = null;
	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null; 

	public UserDAO() {

		try {
			class
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	
	}
	
	
	
	
	
	public UserDTO selectUser(int userNo) throws Exception {
		
		UserDTO user = null;
		
		try{
			String sql = "SELECT * FROM TB_USER WHERE USER_NO=?";
			
			
			
		}finally {
			
		}
		
		return user;
	
	
	}

}
