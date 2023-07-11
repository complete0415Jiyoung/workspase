<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:forEach 향상된 for문처럼 사용하기</title>
</head>
<body>

	<h3>EL로 파라미터 얻어오는 방법</h3>
	1. \${param.name속성값 }
	
	-> 단일 파라미터를 얻어와 출력하는 용도 
	-> 복수 파라미터에 사용하는 경우 맨 앞(0번 인덱스)값만 얻어옴 <br><br>
	
	${param.lang }
	
	<br><br>
	
	2. \${param.lang[인덱스] } <br><br>
	
	${paramValues.lang[0] } <br>
	${paramValues.lang[1] } <br>
	${paramValues.lang[2]  } <br>
	
	<hr>
	
	<h3>향상된 for문 사용</h3>
   
   <ul>
      <c:forEach var="str" items="${ paramValues.lang }" varStatus="vs">
         <li>
            ${str} / ${ vs.index } /${ vs.count }/${vs.current }
            
            <c:if test="${vs.first }">
            	<!-- 첫번째 반복인 경우 -->
            	<span style="color:red;">첫 번째</span>
            </c:if>
            
            <c:if test="${vs.last }">
            	<!-- 마지막 반복인 경우 -->
            	<span style="color:blue;">마지막</span>
            </c:if>
            
         </li>
      </c:forEach>
   </ul> 
	
	
	
	

</body>
</html>