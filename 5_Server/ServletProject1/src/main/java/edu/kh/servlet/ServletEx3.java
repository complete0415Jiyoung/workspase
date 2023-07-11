package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx3 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String inputId =  req.getParameter("inputId");
		String inputPw1 =  req.getParameter("inputPw1");
		String inputPw2 =  req.getParameter("inputPw2");
		String inputName =  req.getParameter("inputName");
		String inputEmail =  req.getParameter("inputEmail");
		
		
		String[] color = req.getParameterValues("color");
				
	
		if(color != null) {
			
			
			for(String c:color) {
				System.out.println(c);
			}
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(inputPw1.equals(inputPw2)) {
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");

			out.println("<head>");
			out.println("<title> "+"회원 정보 제출 결과"+"</title>");
			out.println("</head>");
			
			out.println("<body>");
			out.println("<ul>");
			
			out.print("<li> 아이디 : "+inputId+"</li>");
			out.print("<li> 비밀번호 : "+inputName+"</li>");
			out.print("<li>이메일 : "+inputEmail+"</li>");
			
			String color2 ="";
			if(color != null) {
				for(int i =0 ; i<color.length; i++) {
					
					if(color.length==(i)-1 || color.length==0) {
						color2 += color[i];
					}else {
						color2 += color[i]+", ";
					}
				}
				out.println("<li> 좋아하는 색 : "+ color2 +"</li>");
			}
			out.println("</ul>");
			out.println("</body>");
			
			out.println("</html>");
			
		}else {
			out.println("<!DOCTYPE html>");
			out.println("<html>");

			out.println("<head>");
			out.println("<title> "+"회원 정보 제출 결과"+"</title>");
			out.println("</head>");
			
			out.println("<body>");
			out.print("<h1>비밀번호가 일치하지 않습니다.</h1>");
			out.println("</body>");
			
			out.println("</html>");
			
		}
		
		
		
		
	}

}
