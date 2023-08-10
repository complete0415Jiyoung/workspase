package edu.kh.project.member.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.member.model.dto.Member;

//@RequestMapping : 요청 주소에 맞는 클래스/메소드를 연결

// @RequstMapping ("요청주소")
// -> GET이든 POST 구분 X (모두 받음, 주소만 맞으면 연결)

// @RequstMapping (value ="요청주소" method=RequestMethod.GET/POST)
// -> GET/POST 방식을 구분



@Controller // 요청/응답 처리하는 클래스 + bean으로 등록(Spring이 관리하는 객체)
@RequestMapping("/member") // 공통된 주소 앞부분을 작성
						   // member로 시작하는 요청은 해당 컨트롤러에서 처리 
public class MemberController {

	// 로그인 : /member/login
	// 로그아웃 : /member/logout

	// 로그인 (/member/login) , Post방식 처리
	// Class에 작성한 /member를 제외한 나머지 부분을 주소로 작성

	//@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {

		// 파라미터 전달 방법 1: HttpServletRequst을 이용하는 방법
		// Controller 메소드에 매개 변수로 HttpServletRequst 작성

		// 매개 변수에 적으면 왜 사용이 가능 할까?
		//SpringFramework가 제공하는 
		// AragumentResolver(매개 변수 해결사)가 해결해 줘서

		String inputEmail = req.getParameter("inputEmail");

		System.out.println("inputEmail: "+ inputEmail);

		// **redirext 방법!**

		// "redirect" : 요청주소
		return "redirect:/";
	}


	//@PostMapping() 
	// -> RequstMapping의 자식으로 
	//  Post 방식 요청을 연결하는 어노테이션
//	@PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail,
			/*@RequestParam("inputPw")*/ String inputPw) {

		// 파라미터 전달 방법 2 : @RequstParam 어노테이션 이용(+생략 방법)

		// @RequestParam 어노테이션

		// request 객체를 이용한 파라미터를 전달 어노테이션
		// - 매개변수 앞에 해당 어노테이션을 작성하면, 매개변수 값이 주입됨

		// ** 파라미터의 name속성값과 
		// 	  매개변수명이 같으면 @RequsetParam 생략 가능!!**

		// @RequestParam(value="name", required="fasle", defaultValue="1")
		// [속성]
		// value : 전달 받은 input 태그의 name 속성값

		// required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true)
		// -> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
		// -> required = true인 파라미터가 null인 경우에도 400 Bad Request

		// defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정.
		// -> required = false인 경우 사용

		System.out.println("inputEail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);

		
		//메인페이지 redirect리다이렉트(재요청)
		return "redirect:/";

	}
	
	@PostMapping("/login")					//커멘드 객체
	public String login(/*@ModelAttribute*/ Member inputMember) {
		
		// 파라미터 전달 방법 3: @ModelAttribute를 이용한 방법
		
		// - DTO (또는 VO)와 같이 사용하는 어노테이션
		
		// - 전달받은 파라미터의 name 속성 값이 
		//	 같이 사용되는 DTO의 필드명과 같다면
		//	 자동으로 setter를 호출해서 필드 값을 세팅

		// * @ModelAtturibute 사용시 주의 사항
		// - DTO에 기본 생성자가 필수로 존재해야한다
		// - DTO에 setter가 필수로 존재해야한다
		
		//***@ModelAtturibute 어노테이션은 생략이 가능하다!!***
		
		// *** @ModelAtturibute를 이용해서 값이 필드에 세팅된 객체를 
		//		"커멘드 객체"라고 한다****
		
		
		System.out.println(inputMember);
		
		
		return "redirect:/";

	}
}