package edu.kh.project.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;

//@Controller + @ResponseBody
@RestController  // 요청/응답 처리(단, 모든 요청 응답이 비동기)
				// -> REST API 구축하기 위한 Controller
public class CommentController {

	@Autowired
	private CommentService service;
	
	// 댓글 목록 조회
	@GetMapping(value = "/comment" , produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Comment> select( @RequestParam("boardNo") int boardNo ) {
		return service.select(boardNo); // httpMessageconverter List -> JSON 변환
	}
	
	// 댓글 삽입
	@PostMapping("/comment")
	public int insert(@RequestBody Comment comment) {
		// 요청데이터(JSON)을
		// httpMessageConverter가 해석해서 JAVA객체(comment)에 대입
		return service.insert(comment);
	}
	
	
	//댓글 삭제 
	@DeleteMapping("/comment")
	public int delete( @RequestBody int commentNo ){
						// ajax요청시 body에 담겨 있는 하나의 데이터는 
						// 매개변수 int commentNo담기게 된다
		return service.delete(commentNo);
	}
	
	// 댓글 수정
	@PutMapping("/comment")
	public int update( @RequestBody Comment comment) {
		return service.update(comment);
		
	}
}
