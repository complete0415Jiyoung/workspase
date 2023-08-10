package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller : 현재 클래스가 controller임을 명시
//				-> 요청과 응답 처리
//				+ bean 등록


// instance : 클래스 -> 객체
// --> new클래스명(); 객체 생성을 개발자가 직접함

// IOC(Inversion Of Control, 제어의 역전)
// -> 프레임워크(Spring Container)가 객체를 생성하고 관리 
//--> 이때 생성된 객체를  = bean

@Controller
public class MainController {
	
	// tip : spring 에서 controller메소드 작성시 
	// 반환갓을 모르겠으면 일단 Spring으로 작성!!
	
//	@RequestMapping("/") : 요청주소가 "/"인 경우 해당 메소드와 연결
	
	@RequestMapping("/")
	public String mainForward() {
		//main.jsp로 화면 전환

//		<beans:property name="prefix" value="/WEB-INF/views/" />
//		<beans:property name="suffix" value=".jsp" />
//		
		//Spring 에서 forword하는 방법!!
		
		// -> webapp폴더를 기준으로 
		// 요청 위임할 JAP파일 경로를 리턴하면 된다
		
		//단, servlet - context.xal에 작성된
		// prefix, suffix 부분을 제외하고 작성
		// prefix + 리턴값 + suffix로 경로 완성!!
		
		// **View Resolver**
 		
		return "common/main";
	}
	
	
}
