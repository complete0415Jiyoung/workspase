package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;


//"/member/myPage/info"
//"${contextPath}/member/myPage/info"
@WebServlet("/member/myPage/info")
public class MyPageInforServlet extends HttpServlet{

	// 메인페이지 -> 별명 클릭시 요청(GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path="/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	// 회원정보 수정을 요청 (POST) 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파라미터 얻어오기 + 배열 -> 문자열로 만들기 
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");

		String[] address = req.getParameterValues("memberAddress");

		String memberAddress= null;

		if(!address[0].equals("")) {
			memberAddress = String.join(",,", address);
		}
		
		//*****세션에서 로그인한 회원 정보 얻어오기****
		HttpSession session = req.getSession();
		
		// 얕은 복사(세션에 있는 회원 정보의 객체 주소) 
		// loginMember를 수정하면 세션에 저장된 내용이 수정된다
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		//다운캐스팅 
		
		int memberNo = loginMember.getMemberNo(); //회원번호 얻어오기 성공
		
		// 얻데이트에 필요한 정보를 모아둔  Member 객체 생성
		Member mem = new Member();
		mem.setMemberNo(memberNo);
		mem.setMemberNickname(memberNickname);
		mem.setMemberTel(memberTel);
		mem.setMemberAddress(memberAddress);
		
		try {
			MemberService service = new MemberService();
			
			int result = service.updateMember(mem);
			
			//수정 성공 / 실패에 따른 메세지 출력 
			if(result > 0){ // 성공
				session.setAttribute("message", "회원정보가 수정되었습니다.");
			
			
				// DB는 수정이 되었지만 
				// 로그인한 회원정보가 담겨있는 Session의 정보는 그대로다!
				// -> 동기화 작업
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberTel(memberTel);
				loginMember.setMemberAddress(memberAddress);
			
			
			}else{//실패
				session.setAttribute("message", "회원정보가 수정 실패,,ㅠ");
			}

			// 성공/실패 여부 관계 없이 "내 정보" 화면 재요청
			
			//절대경로 
			resp.sendRedirect( req.getContextPath() + "/member/myPage/info");
			
			//상대주소
			//resp.sendRedirect("info");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
