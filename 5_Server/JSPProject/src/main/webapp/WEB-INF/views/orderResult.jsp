<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- HTML 주석 (개발자 도구에 노출됨) -->
    
    <%--JSP 주석(개발자 도구에 노출안됨) --%>
    
    <%-- 
    
    <%@ %> : 지시자 -> 알려주거나 지시하는 속성을 기입 
    
    "charset=UTF-8" : 현재 문서가 UTF-8 문자 인코딩 형식으로 작성되었음 
    pageEncoding="UTF-8" : 현재 문서를 해석할 때 UTF-8 문자 인코딩을 이용해서 해석 
    
    <% %> : 스크립틀릿(scriptlet) -> JSP에서 자바 코드를 작성할 수 있는 영역 
    -> JSTL 라이브러리를 이용해서 태그 형식으로 변경 
    
    <%= %> : 표현식(Expression) -> 자바 코드의 값을 HTML 형식으로 표현(출력)
    
    
    
    
    
    
     --%>
    
<% // 자바 코드 작성 영역 
    
	int result = (int)request.getAttribute("res");

	// JSP에서도 요청 시 전달 받은 값 (parameter)을 얻어올 수 있다.
	String pizza = request.getParameter("pizza");
	
	String size = request.getParameter("size");
	
	String amount = request.getParameter("amount");
    
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 결과</title>
<style>
	#area {
			font-size : 18px;
			font-weight: bold;
	}

	h1{ color : red; }
	
</style>
</head>
<body>
	<!-- webapp 폴더 내부 html/css/jsp 등은 서버 끄지 않고도 수정 가능  -->
	<div id="area">
			피자 : <%=pizza %>
			<br>
			사이즈 : 
			
				<% if(size.equals("R")){%>
						Regular
				<%}else{%>
						Large
				<%} %>
				
			<br>
			수량 : <%=amount %>판
	</div>
	<h1>계산 결과 : <%= result %></h1>
	
	<% for(int i=1; i<6; i++){ %>
			<h<%=i %>><%=i %>번째 출력중</h<%=i %>>
	<%} %>
	
	
	
	
	
	

</body>
</html>



