package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;

//닉네임 중복검사 ajax
@WebServlet("/member/nicknameDupCheck")
public class NicknameDupcheckServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//파라미터 얻어오기(데이터 속성의 값)
		String memberNickname =req.getParameter("memberNickname");
		

		try {
			//닉네임 중복검가 service 호출 후 결과 반환 받기 
			 MemberService service = new MemberService();
	         
	         int result = service.nicknameDupCheck(memberNickname);
	         
	         System.out.println(result+","+memberNickname);
	         //동기식 -> forward 또는 redirect 로 응답(화면 전환)
	         //비동기식 -> 응답용 스트림을 이용해 데이터 전달 (데이터 현재 화면 추가) 
	         resp.getWriter().print(result);
	         
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
