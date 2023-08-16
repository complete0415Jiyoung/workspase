package edu.kh.project.myPage.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;
import oracle.jdbc.driver.Message;


@SessionAttributes({"loginMember"})
// 1) Model에 세팅된 값이 key와 {}작성된 값이 일치하면 Session scope로 이동
// 2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게 함
// 			->@SessionAtturibute(key)로 사용


@Controller // 요청/응답을 제어하는 클래스 + Bean으로 등록
@RequestMapping("/myPage") // /myPage로 시작하는 요청을 모두 받겠다

public class MyPageController {
	
	@Autowired //MyPageService 의 자식 MyPageServiceImpl 의존성 주입(DI)
	private MyPageService service;

	// 내 정보 페이지로 이동
	@GetMapping("/info")
	public String info() {
		// view Resolver 설정 -> servlet-context.xml 
		return "/myPage/myPage-info";
	}

	// 프로필 변경 페이지로 이동
	@GetMapping("/profile")
	public String profile() {
		return "/myPage/myPage-profile";
	}
	
	// 비밀번호 변경 페이지로 이동
	@GetMapping("/changePw")
	public String changePw() {
		return "/myPage/myPage-changePw";
	}
	
	// 탈퇴페이지 페이지로 이동
	@GetMapping("/secession")
	public String secession() {
		return "/myPage/myPage-secession";
	}

	// 회원정보 수정 
	@PostMapping("/info")
	public String info(Member updateMember, String[] memberAddress
						, @SessionAttribute("loginMember") Member loginMember
						, RedirectAttributes ra) {
		
		
		//------------------매개변수 설명---------------------
		// Member updateMember : 수정할 닉네임, 전화 변호담긴 커멘드 객체
		// String[] memberAddress : neme= "memberAddress"인 input 3개의 값(주소)
		
		// @SessionAtturibute("loginMember") Member loginMember
		//  : Session에서 얻어온 "loginMember"에 해당하는 객체를 
		//	: 매개변수 Member loginMemeber에 저장
		
		// RedirectAttributes ra : 리다이렉트 시 재요청 
		//------------------------------------------------
		
		//주소하나로 합치기
		String addr = String.join("^^^", memberAddress);
		updateMember.setMemberAddress(addr);
		
		//로그인한 회원의 번호를 updateMember에 추가
		updateMember.setMemberNo( loginMember.getMemberNo() );
		
		// DB에 회원 정보 수정 Update 서비스 호출 
		int result = service.updateInfo(updateMember);
		
		String message = null;
		if(result > 0 ) {
			message= "회원 정보가 수정되었습니다.";
			
			//Session에 로그인된  회원 정보도 수정(동기화)
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
			 
			
		}else {
			message= "회원 정보 수정 실패.";
		}
		
		ra.addFlashAttribute("message", message);
		return "redirect:info"; //상대경로 (/myPage/myPage-info)
	}
	
	// 비밀번호 변경
	@PostMapping("/changePw")
	public String changePw( /*@RequestParam("currentPw")*/ String currentPw
						, /*@RequestParam("newPw")*/ String newPw
						, @SessionAttribute("loginMember") Member loginMember
						, RedirectAttributes ra) {
		
		// 로그인한 회원번호(DB에서 어떤 회원을 조회, 수정하는지 알아야하니까)
		int memberNo = loginMember.getMemberNo();
		
		// 비밀번호 변경 Service호출
		int result = service.changePw(currentPw, newPw, memberNo);
		
		String path = "redirect:";
		String message = null;
		if(result > 0 ) {// 성공
			message ="비밀번호가 변경되었습니다.";
			path += "info";	
			//내정보 페이지로 
		}else {
			message= "현재 비밀번호가 일치하지 않습니다.";
			path +="changePw"; // 비밀번호 변경페이지
					
		}
		ra.addFlashAttribute("message", message);
		return path;
		
	}	
	
	
	// 회원탈퇴
	@PostMapping("/secession")
	public String secession(@SessionAttribute("loginMember") Member loginMember
							,String memberPw
							,RedirectAttributes ra
							,SessionStatus status
							,HttpServletResponse resp){
		
		//SessionStatust을 관리하는 객체 
		//HttpServletResponse 서버에서 클라이언트 응답하는 방법제공 객체
		//RedirectAttributes 리다이렉트 시 request 로 값을 전달하는 객체
		
		// 1. 로그인한 회원의 회원 번호 얻어오기
		int memberNo = loginMember.getMemberNo();
		
		// 2. 회원 탈퇴 서비스 호출
		int result = service.secession(memberNo, memberPw);
		
		// - 비밀번호가 일치하면 MEMBER_DEL_FL -> 'Y'바꾸고 1 반환
		// - 비밀번호가 일치하지 않으면 -> 0 반환
		String path = "redirect:";
		String message = null;
		if(result > 0 ) {
			// 3. 탈퇴 성공시 
			
			// - message : 탈퇴되었습니다.
			message ="탈퇴 되었습니다.";
			// - 메인페이지로 redirect
			path += "/";
			// - 로그아웃 
			status.isComplete();
			// - 쿠키 삭제 
			Cookie cookis = new Cookie("saveId", "");
			// 같은 쿠키가 이미 존재한다면 덮어쓰기 된다
			
			cookis.setMaxAge(0); // 0초 동안 생존 -> 삭제
			cookis.setPath("/"); // 요청시 쿠키가 첨부되는 경로 
			resp.addCookie(cookis); // 요청 객체를 통해 클라이언트에게 전달 
									//클라이언트 컴퓨터에 파일로 생성
			
			
			
		}else {
			// 4. 탈퇴 실패 시 
			// - message : 현재 비밀번호가 일치하지 않습니다. 
			// - 회원탈퇴 페이지로 리다이렉트 
			message = "현재 비밀번호가 일치하지 않습니다.";
			path += "secession";
		}
		
		ra.addFlashAttribute("message", message);
		return path;
		
	}	
}
