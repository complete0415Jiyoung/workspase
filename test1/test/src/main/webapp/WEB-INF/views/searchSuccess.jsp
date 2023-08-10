<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원정보</h1>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>회원아이디</td>
			<td>회원이름</td>
			<td>회원나이</td>
		</tr>
		<tr>
			<td>${user.userNo}</td>
			<td>${user.userId}</td>
			<td>${user.userName}</td>
			<td>${user.userAge}</td>
		</tr>
	</table>
	<a href="<%=request.getContextPath()%>">메인페이지로 돌아가기</a>

</body>
</html>