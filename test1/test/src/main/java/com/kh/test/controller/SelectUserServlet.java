package com.kh.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.kh.test.model.UserDAO;


@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int userNo = Integer.parseInt(req.getParameter("userNo"));
			
			UserDAO dao =
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
}
