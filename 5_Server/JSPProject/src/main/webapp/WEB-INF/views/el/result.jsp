<!-- Person 클래스 import -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="edu.kh.jsp.model.vo.Person" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 확인하기</title>
</head>
<body>

	<!-- 
			EL의 특징
			
			1. get이라는 단어를 사용하지 않음 
				왜? 표현언어 == 출력용 언어  == 출력은 얻어와서 밖에 못함 
				
			2. EL은 null을 빈칸으로 출력함 
					(null과 관련된 것은 모두 빈칸)
			
	
	 -->
	 session 범위 sessionValue : ${ sessionValue }
	 
	 <br>
	 
	 application 범위 appValue : ${appValue }

	<h3>request에서 Parameter 얻어오기</h3>
	
	<pre>
		EL로 Parameter 얻어와서 출력하는 방법 
		\${ param.name의 속성값  }
	</pre>
	
	1) JSP 표현식 : 
	<%= request.getParameter("inputName") %> / 
	<%= request.getParameter("inputAge") %> /
	<%= request.getParameter("inputAddress") %>
	<%= request.getParameter("inputAddress2") %>
	<!-- null -->
	
	
	<br><br>
	
	2) EL(표현 언어) : 
	
		${ param.inputName } /
		${ param.inputAge } /
		${ param.inputAddress } /
		
		${ param.inputAddress2 } /
		<!-- 빈칸 -->
		
		<h3>request에서 속성(Attribute) 얻어오기 </h3>
		
		<pre>
				Servlet에서 추가된 속성을 표현(출력) 하려는 경우
				request에 세팅된 속성(Attribute)의 key값만 작성하여 출력할 수 있다!
				(import, getAttribute(), 다운캐스팅, 변수 저장 모두 생략)
				
				\${속성key }
				
				\${속성key.필드명 }
				(단, getter가 작성 되어있어야지만 가능)
				
		</pre>
	
		<%
			String menu = (String)request.getAttribute("menu");
		
			Person person = (Person)request.getAttribute("person");
		
		%>
		1) JSP 표현식 : <%= menu %>
		
		<!-- Person 클래스의 toString() 출력  -->
		<br> <%= person %>
		
		<!-- Person클래스의 getter를 이용해 얻어와서 출력  -->
		<br> <%= person.getName() %>
		<br> <%= person.getAge() %>
		<br> <%= person.getAddress() %>
		
		
		<br><br>
		
		2) EL (표현 언어) : ${menu  }
		
		<br> ${person }	
		
		<br> ${person.name }	
		<br> ${person.age }	
		<br> ${person.address }	
	
		<hr>
		
		<h3>null 처리 방법</h3>
		
		<pre>
			EL에서 null을 출력해야 되는 경우 ""(빈 문자열)을 출력한다
			
			+ NullPointerException이 발생하는 코드에서도 "" (빈 문자열)을 출력한다.
			
			+ EL은 null인 경우를 확인할 때 empty를 통해서 확인할 수 있다.
		</pre>
	
	<%
		List<String> list = null; 
	
	%>
	

	
	1) JSP 표현식 : <%= list %>
	
	<br> <%= list == null %>
	
	<br><br>
	
	2) EL (표현 언어) : ${ list }
	
	<br> ${empty list  }
	
	<h3 style ="color:red;">EL의 empty는 null과 비어있는 컬렉션을 비어있는 것으로 취급함</h3>
	
	<%
			list = new ArrayList<String>();
	
			// list가 ArrayList 객체를 참조 == null 아님 
			// 참조하고 있는 ArrayList에 내용은 없음 == 비어있음 
			
	%>
	
	${empty list }
	${ list == null }
	
	<!-- 
			EL을 이용해서 컬렉션 요소를 다룰 때
			null인지 비어있는지 확인하는 방법이 동일하기 때문에
			코드 작성 시 이를 잘 구분할 수 있도록 해야한다. 
	 -->
	 
	






</body>
</html>





