package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.apachecommons.CommonsLog;

@RequestMapping("/member")
@Controller
@SessionAttributes({"loginMember"})
public class MemberController {


	@Autowired
	private MemberService service;

	/** 로그인 요청 처리(찐)
	 * @return 메인페이지 redirect 주소
	 */
	@PostMapping("/login")
	public String login(Member inputMember, Model model
			, @RequestHeader(value="referer") String referer
			, @RequestParam(value="saveId", required=false) String saveId
			, HttpServletResponse resp
			, RedirectAttributes ra) {

		// Member inputMember : 커맨드 객체(필드에 파라미터 담겨있음)

		// @RequestHeader(value="referer") String referer
		// -> 요청 HTTP header에서 "referer"(이전주소) 값을 얻어와
		//    매개 변수 String referer에 저장

		// Model : 데이터 전달용 객체
		// -> 데이터를 K : V 형식으로 담아서 전달
		// -> 기본적으로 request scope
		// -> @SessionAttributes 어노테이션과 함께 사용 시 Session scope

		// @RequestParam(value="saveId") String saveId
		// -> name 속성 값이 "saveId"인 파라미터를 전달 받아 저장
		// -> required=false : 필수 아님 (null 허용)
		// (주의) required 속성 미작성 시 기본 값 true
		// -> 파라미터가 전달되지 않는 경우 주의

		// HttpServletResponse resp : 서버 -> 클라이언트 응답 방법을 가지고 있는 객체


		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);

		// DB 조회 결과 확인
		//System.out.println(loginMember);

		// 로그인 결과에 따라 리다이렉트 경로를 다르게 지정
		String path = "redirect:";

		if(loginMember != null) { // 로그인 성공 시 
			path += "/"; // 메인페이지로 리다이렉트

			// Session에 로그인한 회원 정보 추가
			// Servlet -> HttpSession.setAttribute(key, value);
			// Spring -> Model + @SessionAttributes

			// 1) model에 로그인한 회원 정보 추가
			model.addAttribute("loginMember", loginMember);
			// -> 현재는 request scope

			// 2) 클래스 위에 @SessionAttributes 추가
			// -> session scope로 변경

			// ------------------ 아이디 저장 ---------------

			/* Cookie란?
			 * - 클라이언트 측(브라우저)에서 관리하는 파일
			 * 
			 * - 쿠키파일에 등록된 주소 요청 시 마다
			 *   자동으로 요청에 첨부되어 서버로 전달됨.
			 * 
			 * - 서버로 전달된 쿠키에
			 *   값 추가, 수정, 삭제 등을 진행한 후
			 *   다시 클라이언트에게 반환
			 * */

			/* Session
			 * - 서버가 클라이언트의 정보를 저장하고 있음 (쿠키와의 차이점)
			 * */

			// 쿠키 생성(해당 쿠키에 담을 데이터를 K:V 로 지정)
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());

			if(saveId != null) { // 체크 되었을 때
				// 한 달(30일) 동안 유지되는 쿠키 생성
				cookie.setMaxAge(60 * 60 * 24 * 30); // 초 단위로 지정

			} else { // 체크 안되었을 때
				// 0초 동안 유지 되는 쿠키 생성
				// -> 기존 쿠키를 삭제
				cookie.setMaxAge(0);
			}

			// 클라이언트가 어떤 요청을 할 때 쿠키가 첨부될지 경로(주소)를 지정
			cookie.setPath("/"); // localhost/ 이하 모든 주소

			resp.addCookie(cookie);



		} else { // 로그인 실패 시
			path += referer; // HTTP Header - referer(이전 주소)



			// addFlashAttribute : 잠시 Session에 추가
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");


		}


		return path;
	}


	// 로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus status, HttpSession session) {

		status.setComplete();
		return "redirect:/";
	}


	// 회원 가입 페이지 이동
	@GetMapping("/signUp")
	public String signUp() {
		return "member/signUp";
	}

	// 회원 가입 진행
	@PostMapping("/signUp")
	public String signUp(Member inputMember
			, String[] memberAddress
			, RedirectAttributes ra) {

		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);

		} else {

			String addr = String.join("^^^", memberAddress);
			inputMember.setMemberAddress(addr);
		}

		// 회원 가입 서비스 호출
		int result = service.signUp(inputMember);

		// 가입 성공 여부에 따라 주소 결정
		String path = "redirect:";
		String message = null;

		if(result > 0) { // 가입 성공
			path += "/"; // 메인 페이지

			message = inputMember.getMemberNickname() + "님의 가입을 환영합니다.";

		} else { // 가입 실패
			// 회원 가입 페이지
			// path += "/member/signUp"; // 절대 경로
			path += "signUp"; // 상대경로

			message = "회원 가입 실패!";

		}

		// 리다이렉트 시 session에 잠깐 올라갔다 내려오도록 세팅
		ra.addFlashAttribute("message", message);

		return path;
	}


}
