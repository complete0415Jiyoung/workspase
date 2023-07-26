package edu.kh.community.board.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.community.board.controller.BoardDetailServlet;
import edu.kh.community.board.model.dao.BoardDAO;
import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.board.model.vo.Pagination;
import edu.kh.community.common.Util;

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

	/**
	 * 게시글 상새 조회 서비스 
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int boardNo) throws Exception{

		Connection conn = getConnection();
		
		//1)게시글(BOARD태이블) 관련 내용만 조회
		BoardDetail detail = dao.selectBoardDetail(conn, boardNo);
		
		if(detail != null) {
			
			//2) 게시글에 첨부된 이미지(BOARD_IMG테이블)조회
			List<BoardImage> imageList = dao.selectImageList(conn,boardNo);
			
			// -> 조회된 imageList를 BoardDetail객체에 세팅
			
			detail.setImageList(imageList);
		}
		close(conn);
		
		return detail;
	}

	/**
	 * 게시글 등록 서비스
	 * @param detail
	 * @param imageList
	 * @param boardCode
	 * @return boardNo
	 * @throws Exception
	 */
	public int insertBoard(BoardDetail detail, List<BoardImage> imageList, int boardCode) throws Exception {
		
		Connection conn   = getConnection();
		
		//1. 다음에 작성할 게시글 번호얻어오기
		// -> BOARD 테이블 insert / BOARD_IMG 테이블 insert / 반환값(상세 조회 번호)할 때 필요함
		int boardNo = dao.nextBoardNo(conn);
		
		//2. 게시글 부분만 삽입(detail, boardCode 사용)
		detail.setBoardNo(boardNo);// 조회된 다음 게시글 번호 세팅
		
		// 1) XSS방지 처리 (제목/내용)
		detail.setBoardTitle(Util.XSSHandling(detail.getBoardTitle()));
		detail.setBoardContent(Util.XSSHandling(detail.getBoardContent()));
		
		// 2) 개행문자 처리
		detail.setBoardContent(Util.newLineHandling(detail.getBoardContent()));
		
		int result = dao.insertBoard(conn, detail, boardCode);
		
		if(result> 0) {//게시글 삽입 성공
			// 3. 이미지 정보만 삽입(imageList 사용)
			
			for(BoardImage image :imageList) {//하나씩 꺼내서 DAO수행
				image.setBoardNo(boardNo);//게시글 번호 세팅
				
				result= dao.insertBoardImage(conn,image);
			
				if(result == 0) { //이미지 삽입 실패
					break;
				}
			}//for문 끝
		}//if문 끝
		
		//트렌젝션 처리 
		if(result > 0) {
			commit(conn);
			
		}else {//2,3번에서 한번이라도 실패하는 경우
			rollback(conn);
			boardNo = 0; //게시글 번호를 0으로 바꿔서 실패했음을 컨트롤러에 전달
			
		}
		close(conn);
		
		return boardNo;
	}
}
