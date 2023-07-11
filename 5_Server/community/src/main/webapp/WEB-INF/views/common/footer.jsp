<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  JSTL은 사용되는 JSP 파일마다 작성되어야 함 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer>

	<p>Copyright &copy; KH Information Educational Institue M-Class</p>

	<article>
		<a href="#">프로젝트 소개</a> <span>|</span> <a href="#">이용약관</a> <span>|</span>
		<a href="#">개인정보처리방침</a> <span>|</span> <a href="#">고객센터</a>
	</article>

</footer>

<%--session에 message 속성이 존재하는 경우 alert창으로 해당 내용 출력 --%>
<c:if test="${!empty sessionScope.message}">
	<script> alert("${message}");
    	
    	//EL 작성시 scope를 지정하지 않으면
    	// page -> request -> session -> application 순서로 검색하여 
    	//일치하는 속성이 잇으면 출력
    	
    </script>
	<%--message 1회 출력 후 session에서 출력 --%>
	<c:remove var="message" scope="session" />


</c:if>