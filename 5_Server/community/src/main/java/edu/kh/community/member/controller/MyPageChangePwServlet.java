package edu.kh.community.member.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/myPage/changePw")
public class MyPageChangePwServlet extends HttpServlet{

	//get 방식 요청 : /WEB-INF/views/member.myPage-changePw.jsp 요청위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/myPage-changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	// post 방식 요청 : 비밀번호 변경
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터(현재 비번, 새 비번)로 얻어오기
		String currentPw = req.getParameter("currentPw");
		String newPw = req.getParameter("newPw");
		
		// ** 로그인 회원 번호 얻어오기 **
		HttpSession session = req.getSession(); //세션 얻어오기
		
		//로그인 정보 얻어오기
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		int memberNo = loginMember.getMemberNo(); //로그인 회원 번호 
		
		System.out.println(currentPw);
		System.out.println(newPw);
		System.out.println(memberNo);
		
		//** Service 로 전달 할 값이 많은데 VO로 해결할 수 없는 경우 **
		//1. 매개 변수로 하나하나 따로 전달 한다
		//	-> 최대 4개 넘기지 않음을 권장

		//2. VO 새로 만들기 (1회성으로 사용하면 비효율적)
		
		try {
			MemberService service = new MemberService();
			
			int result = service.changePw(currentPw, newPw , memberNo);
			
			String path = null; //리다이렉트 주소
			
			if(result > 0) { // 성공
				
				//session scope -> key ="massage" , value = "비밀번호 성공"
				session.setAttribute("massage", "비밀번호 성공");
				
				//path= "내 정보 페이지 주소" 
				//path = req.getContextPath()+"/member/myPage/info";
				path = "info";
			
			}else { // 실패
				//session scope -> key ="massage" , value = "비밀번호 실패"
				session.setAttribute("massage", "현재 비밀번호가 일치하지 않습니다");
			
				//path="비밀번호 변경 페이지 주소"
				//path=req.getContextPath()+"/member/myPage/changePw";
				path="changePw";
			
			}
			resp.sendRedirect(path);
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
}

