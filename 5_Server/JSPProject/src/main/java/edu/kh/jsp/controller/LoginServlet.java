package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("요청 주소") 어노테이션
// - 해당 클래스를 Servlet 클래스로 등록( <servlet> 태그) 하고
// 		어떤 요청 주소를 처리할지 지정( <serlvet-mapping>태그)



@WebServlet("/login")

public class LoginServlet extends HttpServlet {
       


	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 시 전달 된 input 태그의 값(== Parameter) 얻어오기
		// (파라미터는 모두 String 타입이다!!)
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		
		// 파라미터를 잘 얻어왔는지 확인
		System.out.println("ID : " + inputId);
		System.out.println("PW : " + inputPw);
		
		// 간이 로그인 확인 코드
		String result = null;
		
		if(inputId.equals("user01") && inputPw.equals("pass01!")) {
			result = inputId + "님이 로그인 하셨습니다.";
		} else {
			result = inputId + "아이디 또는 비밀번호가 일치하지 않습니다..";
		}
		
		// out.print("<html>"); -> jsp 교체
		
		// JSP란?
		// - Servlet에 html코드를 쓰는게 불편하기 때문에
		// 		반대로 html 코드에 java 코드를 쓸 수 있게 하는 문서
		
		// * JSP 생성 폴더 위치
		// -> webapp/WEB-INF 폴더 내부에 생성 
		
		//*******************************************************************************
		
		// JSP로 응답하기
		
		// Dispatcher : 필요한 정보를 제공하는 자 == 발송자
		
		// 위임 : (맡은 일을) 넘겨주다
		
		// forward : 전송하다, 보내다
		
		// 응답 화면을 만드는 Servlet의 일을
		// 좀 더 효율적으로 처리할 수 있는 JSP에게 넘겨줄 예정
		
		// req.getRequestDispatcher("JSP경로");
		// - HttpServletRequest 객체가 생성될 때
		// 내부에 자동으로 요청발송자(RequestDispatcher)가 같이 생성됨 
		
		
		// - "JSP경로" : 전달할 JSP의 경로를 작성
		
		// ** JSP 경로 작성 규칙 **
		// - webapp 폴더를 기준으로 해서 JSP 파일까지의 모든 경로를 다 작성!!
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		// JSP에게 전송될 예정인 req 객체에 
		// result 변수 값 담아서 같이 전달 
		
		// req.setAttribute(String key, Object value);
		// - key는 String(문자열)
		// - value는 모든 객체(타입 상관 없음)
		
		// - Attribute : 속성 (데이터, 값)
		req.setAttribute("res", result);
		
		// 요청 발송자를 이용하여 req, resp 객체를 전송(forward)함
		dispatcher.forward(req, resp);
		
		
	}

	

}









