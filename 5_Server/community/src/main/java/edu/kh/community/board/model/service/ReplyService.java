package edu.kh.community.board.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.community.board.model.dao.ReplyDAO;
import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.Pagination;
import edu.kh.community.board.model.vo.Reply;

public class ReplyService {
	
	private ReplyDAO dao = new ReplyDAO();

	/**
	 * 특정게시글의 목록 조회 
	 * @param boardNo
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int boardNo)throws Exception {
		Connection conn = getConnection();
		
		List<Reply> rList =dao.selectReplyList(conn, boardNo);
		
		close(conn);
		
		return rList  ;// Map 객체 반환
	} 

}
