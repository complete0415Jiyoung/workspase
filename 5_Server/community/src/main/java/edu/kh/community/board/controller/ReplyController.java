package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.community.board.model.service.ReplyService;
import edu.kh.community.board.model.vo.Reply;

// controller : 요청에 따라 알맞은 서비스를 호출하고 
//			요청 처리 결과를 내보내줌 (응답할)view를 선택

//** Front Controller 패턴
// 하나의 Servlet이 여러 요청을 받아 드리고 제어 하는 패턴

@WebServlet("/reply/*") //Reply로 시작하는 모든 요청을 받음
public class ReplyController extends HttpServlet {

	// /reply/selectReplyList
	// /reply/insert
	// /reply/update
	// /reply/delete


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET방식 요청 처리

		String uri = req.getRequestURI();
		// /community/reply/selectReplyList

		String contextPath = req.getContextPath();
		// /community

		String command = uri.substring(  (contextPath + "/reply/").length()  );
		// selectReplyList

		try {
			// 댓글 목록 조회 요청인 경우
			if(command.equals("selectReplyList")){

				// 파라미터 얻어오기 정수 형태로 파싱 
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));

				// 댓글 목록 조회 서비스 호출후 결과 반환 

				ReplyService service = new ReplyService();

				List<Reply> rList = service.selectReplyList(boardNo);

				System.out.println(rList);

				//JSON형태로 변환
				new Gson().toJson(rList,resp.getWriter());
				
				}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST방식 요청 처리

		doGet(req,resp);	//POST로 전달된 요청을 doGet()으로 전달하여 수행
	}


}
