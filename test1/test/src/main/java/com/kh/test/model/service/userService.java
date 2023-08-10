package com.kh.test.model.service;

import java.sql.Connection;
import java.sql.DriverManager;

import com.kh.test.model.dao.UserDAO;
import com.kh.test.model.vo.User;

public class userService {


	public User selectId(String userId) throws Exception{
		
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver")
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","servertest","1234");
			
			UserDAO dao = new UserDAO();
			User user = dao.selectId(conn,userId);
			
		}finally {
			try {
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
				
				
		return user;
	}
	
	
}
