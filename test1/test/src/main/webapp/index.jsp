<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath() %>/selectUser">
		<h1>회원정보조회</h1>
		<input type="text" placeholder="회원 아이디 입력" name="userid">
		<button>조회</button>
	</form>
	
</body>
</html>