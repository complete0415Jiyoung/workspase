package edu.kh.community.board.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.community.board.model.dao.BoardDAO;
import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.Pagination;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();

	/**
	 * 게시글 목록 조회서비스
	 * @param type
	 * @param cp
	 * @return Map
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardList(int type, int cp) throws Exception {

		Connection conn = getConnection();
		
		// 1. 게시판 이름 조회DAO
		String boardName = dao.selectBoardName(conn, type);
		
		// 2-1. 특정게시판 전체에 게시글 수 조회 DAO 호출
		int listCount = dao.getListCount(conn, type);
		
		// 2-2. 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 저장
		Pagination pagination = new Pagination(cp, listCount);
		
		// 3. 게시글 목록 조회
		List<Board> boardList = dao.selectBoardList(conn,pagination, type);
		
		
		// 4. Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		return map;// Map 객체 반환
	}
	
	

}
