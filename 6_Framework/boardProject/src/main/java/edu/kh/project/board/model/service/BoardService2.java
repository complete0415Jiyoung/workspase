package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.Board;

public interface BoardService2 {

	/** 게시글 삽입
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @return boardNo
	 */
	int boardInsert(Board board, List<MultipartFile> images, String webPath, String filePath)throws IllegalStateException, IOException;

	/** 게시글 수정
	 * @param board
	 * @param images
	 * @param webPath
	 * @param filePath
	 * @param delteList
	 * @return rowCount
	 */
	int boardUpdate(Board board, List<MultipartFile> images, String webPath, String filePath, String delteList)throws IllegalStateException, IOException;

	/** 게시글 삭제 
	 * @param map
	 * @return result 
	 */
	int boardDelete(Map<String, Object> map);

}
