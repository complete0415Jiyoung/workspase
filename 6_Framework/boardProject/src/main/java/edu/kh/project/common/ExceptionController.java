package edu.kh.project.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//에외 처리용 컨트롤러 (프로젝트 전역)
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {

		//Exception e : 예외 정보를 담고 있는 객체
		// Model model : 데이터 전달용 객체 (request scope가 기본)

		e.printStackTrace();

		model.addAttribute("e", e);

		// forward 진행
		// -> View Resolver 의 prefix , suffix를 붙여서 JSP경로를 만듦
		return "common/error";
	}
}
