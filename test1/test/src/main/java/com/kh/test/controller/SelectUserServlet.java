package com.kh.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.test.model.UserDAO;
import com.kh.test.model.UserDTO;


@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int userNo = Integer.parseInt(req.getParameter("userNo"));
			
			UserDAO dao = new UserDAO();
			
			UserDTO user = dao.selectUser(userNo);
			
			req.setAttribute("user", user);
			
			RequestDispatcher dispatcher = null;
			
			if(user != null) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp");
			}else {
				dispatcher = req.getRequestDispatcher("/WEB-INF/views/searchFail.jsp");
			}
			dispatcher.forward(req, resp);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
