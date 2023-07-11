package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;
import edu.kh.jdbc.member.model.vo.Member;

public class BoardDAO {

	//JDBC 객체 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//SQL 내용을 저장할 Properties 객체 참조변수
	private Properties prop;
	
	//기본 생성자 "board-sql.xml" 파일 읽어오기 (Properties)
	public BoardDAO() {
		try {
			prop =new Properties();
			
			
			//XML 파일 읽어오기 
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @return boardList 
	 * @throws Exception
	 */
	
	public List<Board> selectAll(Connection conn) throws Exception {

		// 결과 저장용 변수 
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			//1)SQL작성
			String sql = prop.getProperty("selectAll");
			
			//2)statement 생성
			stmt= conn.createStatement();
			//3)SQL수행(SELECT) 후 결과 반환 받기 (ResultSet)
			rs=stmt.executeQuery(sql);
				
			
			//4)ResultSet 을 한행씩 (rs.next()) 모두 접근
			while(rs.next()) {
				//5)현재 행에서 컬럼명을 이용해서 컬럼값 가져오기
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				Date createDate = rs.getDate("CREATE_DATE");
				int readCount = rs.getInt("READ_COUNT");
				String memeberName= rs.getString("MEMBER_NM");
				int replyCount = rs.getInt("REPLY_COUNT");
				
				//6) Board 객체를 생성하여 컬럼 값 담기 
				Board board = new Board(boardNo, boardTitle, createDate, readCount, memeberName, replyCount);
				
						
				//7) boardList 에 추가
				boardList.add(board);
			}
			
		}finally {
			//8) 사용한 JDBC객체 자원 반환 (Connection제외)
			close(rs);
			close(pstmt);
			
		}
		
		//DAO 수행 결과 반환 
		return boardList;
	}

	/**특정 게시글 상세 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectOne(Connection conn, int boardNo)throws Exception {
		//결과 저장용 변수 
		Board board = null;
		
		
		try {
			//1) SQL 작성
			String sql = prop.getProperty("selectOne");
			
			//2) PreparedStatement 생성
			pstmt= conn.prepareStatement(sql);
			
			//3) 위치홀더
			pstmt.setInt(1, boardNo);
			
			//4) SQL 수행  후 결과 반환 (RsultSet)
			rs = pstmt.executeQuery();
			
			//5) 조회된 한행 (if) 이있을 경우 조회된 컬럼값 얻어오기 
			if(rs.next()) {
				//int boardNo = rs.getInt("BOARD_NO");
				//-->입력 받은 boardNo 와 BOARD_NO 같음 
				//굳이 DB조회 결과 얻어오지 않아도됨
				String boardTitle = rs.getString("BOARD_TITLE");
				Date createDate = rs.getDate("CREATE_DATE");
				int readCount = rs.getInt("READ_COUNT");
				String memeberName= rs.getString("MEMBER_NM");
				
				String boardContent = rs.getString("BOARD_CONTENT");
				int memberNo =rs.getInt("MEMBER_NO");
			
				//6) Board 객체를 생성하여 컬럼 값 세팅
				board = new Board();
				board.setBoardNo(boardNo);//메개변수 세팅
				board.setBoardTitle(boardTitle);
				board.setCreateDate(createDate);
				board.setReadConut(readCount);
				board.setMemberName(memeberName);
				board.setBoardContent(boardContent);
				board.setMemberNo(memberNo);
			
			}
		} finally {
			//7)사용 자원 반환
			close(rs);
			close(pstmt);
			
		}
		//결과 반환
		return board;
	}

	/**특정게시글 댓글 목록 DAO
	 * @param conn
	 * @param boardNo
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception {
		
		List<Reply> replyList = new ArrayList<>(); // 결과 저장용 변수
		
		try {
			//1) SQL작성
			String sql = prop.getProperty("selectReplyList");
			//2) PreparedStatement 생성
			pstmt= conn.prepareStatement(sql);
			
			//3) 위치홀더 알맞은 
			pstmt.setInt(1, boardNo);
			//4) SQL 수행  후 결과 반환 (RsultSet)
			rs = pstmt.executeQuery();
			
			//5)조회된 결과 한 행씩 접근 (While,(rs.next))
			// -> 각 행별로 컬럼값 얻어오기
			while(rs.next()) {
//				SELECT R.* , MEMBER_NM
//				FROM REPLY R
//				JOIN MEMBER M ON(R.MEMBER_NO = M.MEMBER_NO)
//				WHERE BOARD_NO = ?
				
				int replyNo = rs.getInt("REPLY_NO");
				String replyContent  = rs.getString("REPLY_CONTENT");
				Date createDate = rs.getDate("CREATE_DATE");
				int memberNo= rs.getInt("MEMBER_NO");
				String memberName= rs.getString("MEMBER_NM");
				//board는 메개변수 사용
			
				//6) Reply 객체를 생성하여 컬럼 값 담기 
				Reply reply = new Reply();
				
				reply.setReplyNo(replyNo);
	            reply.setReplyContent(replyContent);
	            reply.setCreateDate(createDate);
	            reply.setMemberNo(memberNo);
	            reply.setMemberName(memberName);
	            reply.setBoardNo(boardNo);
				
				//7) replyList 에 reply 객체 추가 
				replyList.add(reply);
			}
			
			
		} finally {
			//6) 자원 반환
			close(rs);
			close(pstmt);
		
		}
		
		
		//결과 반환
		return replyList;
	}

	/**게시글 증가 DAo
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int boardNo) throws Exception{
		int result =0 ; //결과저장용변수
		
		try {
			
			String sql = prop.getProperty("increaseReadCount");
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result=pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
	
		}
		
		return result;
	}

	/** 게시글 삭제 
	 * @param conn
	 * @param boardNo
	 * @return result 
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo)throws Exception {
		int result = 0; 
		
		try {
			
			String sql = prop.getProperty("deleteBoard");
			
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 게시글 수정 DAO
	 * @param conn
	 * @param board
	 * @return result
	 * @throws Exception
	 * 
	 */
	public int updateBoard(Connection conn, Board board) throws Exception{
		
		int result = 0;
		try {
			String sql = prop.getProperty("updateBoard");
			
			pstmt= conn.prepareStatement(sql);
			
			/*
			UPDATE BOARD SET
			BOARD_TITLE = ?,
			BOARD_CONTENT =?
			WHERE BOARD_NO = ?
			*/
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}

		return result;
	}

	/** 댓글 작성 DAO
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply)throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertReply");
			
			pstmt= conn.prepareStatement(sql);
			/*
			 INSERT INTO REPLY
			VALUES (SEQ_REPLY_NO.NEXTVAL, ?, DEFAULT, ?, ?)
			*/
			
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}

		return result;
	}

	/** 댓글 수정 DAO
	 * @param conn
	 * @param inputNo
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(Connection conn, Reply reply) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("updateReply");
			
			pstmt= conn.prepareStatement(sql);
			
			/*
			UPDATE REPLY SET
			REPLY_CONTENT =?
			WHERE REPLY_NO = ?;
			*/

			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getReplyNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}

		return result;
	}

	/** 댓글 삭제 DAO
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(Connection conn, Reply reply) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("deleteReply");
			
			pstmt= conn.prepareStatement(sql);
			
			/*
			DELETE FROM REPLY
			WHERE REPLY_NO = ? 
			*/

			pstmt.setInt(1, reply.getReplyNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}

		return result;
	}

	/** 게시글 작성 DAO
	 * @param conn
	 * @param board
	 * @return result 
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board board)throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("insertBoard");
			
			pstmt= conn.prepareStatement(sql);
			/*
			 INSERT INTO BOARD
			VALUES (SQL_BOARD_NO.NEXTVAL, ?, ?, DEFAULT, DEFAULT, ?)
			*/
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getMemberNo());

			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}

		return result;
	}

	/** 게시글 검색 DAO
	 * @param conn
	 * @param menuNum
	 * @param keyword
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> searchBoard(Connection conn, int menuNum, String keyword) throws Exception{

			List<Board> boardList = new ArrayList<Board>();
			
			try {
				//SQL 작성 (menuNum에 따라서)
				String sql = prop.getProperty("searchBoard1")
						+ prop.getProperty("condition"+menuNum)
						+prop.getProperty("searchBoard2");
				
				pstmt=conn.prepareStatement(sql);
				
				//위치홀더 알맞은 값 세팅
				//* 주의 *
				
				//제목 + 내용 을 검색하는 조건(3번) 은 혼자만 위치홀더가 2개다!
				pstmt.setString(1, keyword);
				
				if(menuNum ==3) pstmt.setString(2, keyword);
				
				rs = pstmt.executeQuery(); //select문 수행후 결과 ResultSet반환
				
				//ResultSet 을 한행씩 (rs.next()) 모두 접근
				while(rs.next()) {
					
					//현재 행에서 컬럼명을 이용해서 컬럼값 가져오기
					int boardNo = rs.getInt("BOARD_NO");
					String boardTitle = rs.getString("BOARD_TITLE");
					Date createDate = rs.getDate("CREATE_DATE");
					int readCount = rs.getInt("READ_COUNT");
					String memeberName= rs.getString("MEMBER_NM");
					int replyCount = rs.getInt("REPLY_COUNT");
					
					//Board 객체를 생성하여 컬럼 값 담기 
					Board board = new Board(boardNo, boardTitle, createDate, readCount, memeberName, replyCount);
					
							
					// boardList 에 추가
					boardList.add(board);
				}
				
			} finally {
				close(rs);
				close(pstmt);
			}
			
		return boardList;
	}

}
