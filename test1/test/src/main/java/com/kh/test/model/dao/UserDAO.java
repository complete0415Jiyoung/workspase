package com.kh.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.test.model.vo.User;

public class UserDAO {

	PreparedStatement pstmt = null; 
	ResultSet rs = null; 


	
	public User selectId(Connection conn, String userId) throws Exception {
		User user = null;

		try{
			String sql = "SELECT * FROM TB_USER WHERE USER_ID=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				user = new User();
				user.setUserNo(rs.getInt("USER_NO"));
				user.setUserId(rs.getString("USER_ID"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserAge(rs.getInt("USER_AGE"));

			}
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();


			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return user;
	}
}


