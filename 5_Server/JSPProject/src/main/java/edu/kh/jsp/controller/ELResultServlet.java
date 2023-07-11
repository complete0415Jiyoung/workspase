package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.vo.Person;

@WebServlet("/EL/result")
public class ELResultServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// POST 방식 요청 -> 한글 깨짐 -> 문자 인코딩 처리 필요 
		req.setCharacterEncoding("UTF-8");
		
		// 새로운 임의의 값 
		String menu = "돈까스";
		
		// 파라미터 얻어오기
		String inputName = req.getParameter("inputName");
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		String inputAddress = req.getParameter("inputAddress");
		
		// Person 객체에 파라미터를 변경한 값을 대입 
		Person person = new Person();
		
		person.setName(inputName + "님");
		person.setAge(inputAge + 100);
		person.setAddress("대한민국 " + inputAddress);
		
		// 응답 화면 작성 코드를 JSP로 위임
		
		// 1) 요청 발송자
		String path = "/WEB-INF/views/el/result.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 2) 요청 위임 시 추가할 값 세팅
		req.setAttribute("person", person);
		req.setAttribute("menu", menu);
		
		// 3) 요청 위임
		dispatcher.forward(req, resp);
		
		
	}
	
	
	
	
}
