<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% // 자바 코드 작성 영역

		// 여기는 JSP -> Servlet으로 부터 전송 받은 req, resp가 있음 
		// -> req, resp 를 사용할 수 있다 !!
		// -> 대신 이름이 request, response로 바뀜 
		String r = (String)request.getAttribute("res");
		
		// getAttribute("key")
		// - 반환형 Object -> 원래 타입으로 강제 형변환이 필요함!
		
    
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
</head>
<body>

	<!-- 위에 선언된 변수 r에 저장된 값 출력 -->
	<h1><%= r %></h1>



</body>
</html>