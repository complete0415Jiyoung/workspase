package edu.kh.community.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/emailDupCheck")
public class EmailDupCheckServlet extends HttpServlet{

	// 이메일 중복 검사 (비동기 통신)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//비동기 통신 전달된 파라미터(date속성의 key값)얻어오기
		
		String memberEmail = req.getParameter("memberEmail");
		
		try {
			//이메일 중복검사 서비스 호출후 결과 반환 받기 
			MemberService  service = new MemberService();
			
			int result = service.emailDupCheck(memberEmail);
			
			//보통 동기식 코드 작성시 
			//forword 또는 redirect를 이용해서 새로운 페이지가 보이게 동작함
			
			//*** 비동기 통신 시 응답은 화면이 아닌 데이터(String, XML, JSon, int,....)
			//	-> 응답용 스트림을 이용해서 단순히 데이터만 전달하면 된다
			resp.getWriter().print(result);
			//응답 스트림을 이용해서 result를 출력
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
