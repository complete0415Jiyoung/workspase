package edu.kh.community.board.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Reply;



public class ReplyDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public ReplyDAO() {
		try {
			prop = new Properties();

			String filePath = ReplyDAO.class.getResource("/edu/kh/community/sql/reply-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * 특정게시글 목록조회 리스트 DAO
	 * @param conn
	 * @param boardNo
	 * @return rList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception{

		List<Reply> rList = new ArrayList<Reply>(); 
		try {

			String sql = prop.getProperty("selectReplyList");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Reply reply = new Reply();

				reply.setReplyNo(rs.getInt(1));
				reply.setReplyContent(rs.getString(2));
				reply.setCreateDate(rs.getString(3));
				reply.setBoardNo(rs.getInt(4));
				reply.setMemberNo(rs.getInt(5));
				reply.setMemberNickname(rs.getString(6));
				reply.setProfileImage(rs.getString(7));

				rList.add(reply);

			}

		}finally {
			close(rs);
			close(pstmt);
		}
		return rList;
	}


	/**
	 * 댓글 작성 DAO
	 * @param conn
	 * @param reply
	 * @return result 
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply) throws Exception{
		int result=0;
		
		try {
			String sql= prop.getProperty("insertReply");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());
			
			result= pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	/**
	 * 댓글 삭제 DAO
	 * @param conn
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deletReply(Connection conn, int replyNo) throws Exception{
		int result=0;
		
		try {
			String sql= prop.getProperty("deleteReply");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, replyNo);
			
			result= pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	/**
	 * 댓글 수정 DAO
	 * @param conn
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int update(Connection conn, int replyNo, String replyContent) throws Exception {
	
	int result=0;
		
		try {
			String sql= prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, replyContent);
			pstmt.setInt(2, replyNo);
			
			result= pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	
	}
}
