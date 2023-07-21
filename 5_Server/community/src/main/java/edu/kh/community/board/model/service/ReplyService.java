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
import edu.kh.community.common.Util;

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

	/**
	 * 댓글 등록 Service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply)throws Exception {
		Connection conn = getConnection();
		
		
		// XSS : 관리자가 아닌 이용자가 악성 스크립트를 삽입해서 공격할 수 있다
				// Cross Site Scripting(XSS 크로스 사이트 스크립팅) 공격 방지 처리 
				reply.setReplyContent( Util.XSSHandling(reply.getReplyContent() ) );
		
		
		// 개행문자 변경 처리 
		// textarea에 줄바꿈 문자 입력 시 \n, \r, \r\n, \n\r 중 하나로 입력이 된다(브라우저, OS 따라 다름)
		// 이 문자를 HTML에서 줄바꿈으로 인식할 수 있도록 "<br>"태그로 변경
		// reply.getReplyContent().replaceAll("정규표현식", "바꿀 문자열");
		
		// 댓글 등록/수정
		// 게시글 등록/수정에서 사용
		//reply.setReplyContent(reply.getReplyContent().replaceAll("\n|\r|\n\r|\r\n", "<br>"));
		
		//static으로 선언해둔 개행문자 변경 사용
		reply.setReplyContent( Util.newLineHandling( reply.getReplyContent() ) ); 		
		
		
		int result =dao.insertReply(conn, reply);
		
		if(result> 0) commit(conn);
		else 		  rollback(conn);

		close(conn);
		
		return result;
	}
	
	/**
	 * 댓글 삭제하기 Service
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deletReply(int replyNo) throws Exception{
		Connection conn= getConnection();
		
		int result =dao.deletReply(conn, replyNo);
		
		if(result> 0) commit(conn);
		else 		  rollback(conn);

		close(conn);
		
		return result;
	} 

}
