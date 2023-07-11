<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 목록 조회</title>
</head>
<body>
	<table border="1">
		<thead>
			<th>회원 번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>가입일</th>
			<th>탈퇴 여부</th>
		</thead>
		<tbody>
			<c:forEach var="member" items="${ requestScope.list }">
				<tr>
					<td>${member.memberNo}</td>
					<td>${member.memberId}</td>
					<td>${member.memberPw}</td>
					<td>${member.memberName}</td>
					<td>${member.memberGender}</td>
					<td>${member.enrollDate}</td>
					<td>${member.secessionFlag}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>