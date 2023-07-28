package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.board.model.service.BoardService;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			// 쿼리스트링 얻어오기 == 파라미터 얻어오기
			 
			// /board/list?type=1
			int type = Integer.parseInt(req.getParameter("type"));
			
			
			// /board/list?type=1&cp=2
			
			// nav 메뉴 (공지사항, 자유게시판, 질문게시판) 선택시 
			// 쿼리스트링에 "cp"가 없음 --> cp =  1고정
			int cp = 1;
			
			// 페이지네이션 번호 선택시 
			// 쿼리스트링에 cp가 있음 --> cp = 쿼리스트링의 cp값
			if(req.getParameter("cp") != null) { //쿼리스트링에 "cp"가 존재한다면 
				cp = Integer.parseInt(req.getParameter("cp")); 
			}
			
			
			BoardService service = new BoardService();
			
			// 게시판 이름, 페이지네이션 객체, 게시글 리스트를 한번에 반환하는 Service 호출
			Map<String, Object> map = null;

			if(req.getParameter("key")==null) {//일반목록
				
				map=service.selectBoardList(type,cp);
				
			}else { //검색목록을 조회
				String key = req.getParameter("key");
				String query = req.getParameter("query");
				map= service.searchBoardList(type,cp,key,query);
			}
			
			
			//request 범위로 map을 세팅
			req.setAttribute("map", map);
		
			String path = "/WEB-INF/views/board/boardList.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
