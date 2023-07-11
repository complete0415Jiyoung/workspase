<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // 추가된 값 
    String m = (String)request.getAttribute("msg");
    
    // 전달 받은 값(파라미터)
    String memberId = request.getParameter("memberId");
    String memberPw = request.getParameter("memberPw");
    String memberName = request.getParameter("memberName");
    String intro = request.getParameter("intro");
    
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <%= memberName %> 님 가입 결과</title>
</head>
<body>
	<ul>
			<li>아이디 : <%= memberId %> </li>
			<li>비밀번호 : <%= memberPw %> </li>
			<li>이름 : <%= memberName %> </li>
			<li>자기소개 : <%= intro %> </li>
	</ul>
	
	<h1><%= m %></h1>
	
</body>
</html>