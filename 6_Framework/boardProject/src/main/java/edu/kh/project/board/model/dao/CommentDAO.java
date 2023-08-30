package edu.kh.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;

@Repository // DB 관련 + bean 등록(IOC)
public class CommentDAO {
	
	@Autowired
	 private SqlSessionTemplate sqlsession;

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return cList
	 */
	public List<Comment> select(int boardNo) {
								// board-mapper.xml에 작성된 select 이용
		return sqlsession.selectList("boardMapper.selectCommentList", boardNo);
	}

	/** 댓글 삽입
	 * @param comment
	 * @return result
	 */
	public int insert(Comment comment) {
		return sqlsession.insert("commentMapper.insert",comment);
	}

	/** 댓글 삭제
	 * @param commentNo
	 * @return result
	 */
	public int delete(int commentNo) {
		return sqlsession.update("commentMapper.delete",commentNo);
	}

	/**댓글 수정
	 * @param comment
	 * @return result
	 */
	public int update(Comment comment) {
		return sqlsession.update("commentMapper.update",comment);
	}
}
