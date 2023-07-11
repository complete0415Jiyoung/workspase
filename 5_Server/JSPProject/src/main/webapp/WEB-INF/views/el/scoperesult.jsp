<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 범위 결과</title>
</head>
<body>
	
	<%
			// page scope
			pageContext.setAttribute("message", "page");
	%>

	<pre>
			request 범위 message : ${ message  }
			
			session 범위 sessionValue : ${ sessionValue }
			
			application 범위 appValue : ${appValue }
			
			*** scope 우선 순위 ***
			
			page > request > session > application
			
			** 원하는 범위(scope)의 값 얻어오기(000Scope)
			
			${ requestScope.message }
			
			${ sessionScope.message }
			
			${ applicationScope.message }
	</pre>

</body>
</html>