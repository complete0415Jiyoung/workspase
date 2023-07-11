<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL_1</title>
</head>
<body>

    <h1>JSTL(Jsp Standard Tag Library)</h1>

    <pre>
        JSP에서 자주 사용되거나 공통적으로 사용되는 Java 코드를
        쉽고, 표기법을 간단히 할 수 있도록 태그화(Tag Library) 하여
        표준(Standard)으로 제공함

        (if, for, scope 변수 선언, 데이터 파싱 등)
    </pre>
    
       
   <h3>JSTL 라이브러리 등록 방법</h3>
   <ol>
      <li> https://tomcat.apache.org/download-taglibs.cgi 접속 </li>
      <li> jar files -> impl, EL, Spec 다운로드 </li>
      <li> WEB-INF/lib 폴더에 추가</li>
      
      <!-- webapp 폴더는 서버 구동 시 인터넷에 배포되는 폴더
         -> 인터넷 상에서 수행되어야 되는 코드, 파일 등을
            모두 webapp폴더 내부에 저장함.
       -->

   </ol>
   
   <hr>

   <h3>JSTL 사용을 위한 선언 방법</h3>

   <pre>
        JSTL을 사용하고자 하는 JSP가 있을 경우
        해당 JSP 최상단에 JSTL 라이브러리를 추가하는 지시자 taglib를 작성해야 한다.


	prefix : 접두사. 다른 태그와 구별할 수 있는 namespace
				(태그 앞에 붙는 태그명 )
				
				url(Uniform Resource Locator) : 인터넷에서 특정 자원 위치 지정(주소)
				uri(Uniform Resource Identifier) : 네트워크 상에서 자원을 구별하는 식별자
																			(자원을 구분하는 유일한 주소)
				
				
				-> uri에 작성하는 주소는 네트워크 상의 주소가 아닌 다운로드 받은 라이브러리
					내부 구분 주소
				
				
				
   </pre>
   
   <h3>1. 변수 선언 (c : set)</h3>
   
   <pre>
   			- 변수를 선언하고 값을 초기화하는 태그(초기화는 무조건 수행 )
   			
   			- c : set 태그로 선언된 변수는 EL을 이용해서 출력할 수 있다.
   			
   			특징 1: 변수 타입을 지정하지 않음 
   			특징 2: 변수의 범위(scope) 지정할 수 있음
   			
   				-> c : set은 내장 객체에 속성을 추가하는 태그 
   						(page , request , session , application)
   						
   			- c : set 태그 속성
   			1) var : 변수명
   			2) value : 대입될 값
   			3) scope : 변수 범위(기본값 : page)
   			
   </pre>
   <!-- <태그명 /> : 태그가 시작 되자 마자 종료 == 내용이 없는 요소  -->
   <c:set var="num"  value ="100"/> <!--page  -->
   <c:set var="num"  value ="200"  scope="request"/>

<!-- scope 미지정 시 좁은 범위부터 탐색(우선순위) -->
${ num  } + ${ requestScope.num } = ${ num + requestScope.num }
   
   <hr>
   
   <h3>2. 변수 삭제 (c:remove)</h3>
   
	<pre>
			- 지정한 변수(c : set / setAttribute() 추가된 변수) 삭제 
			- scope 선택 가능
			- scope 미작성 시 모든 scope에서 일치하는 변수명 모두 제거 
			
			- c : remove 속성
			var : 삭제할 변수명
			scope : 삭제할 범위 (기본값 모든 범위)
			
	</pre>   
	
	<!-- session scope 변수 선언 -->
	<c:set var="num"  value="300"  scope="session"/>
	
	<ul>
			<li>page : ${ pageScope.num }</li>
			<li>request : ${ requestScope.num }</li>
			<li>session : ${ sessionScope.num }</li>
	</ul>
	
	request 범위의 num 변수 삭제
	<c:remove var="num"  scope="request" />
   
   
	<ul>
			<li>page : ${ pageScope.num }</li>
			<li>request : ${ requestScope.num }</li>
			<li>session : ${ sessionScope.num }</li>
	</ul>
	
	모든 범위 num 변수 삭제
	<c:remove var="num"  />
   
   
	<ul>
			<li>page : ${ pageScope.num }</li>
			<li>request : ${ requestScope.num }</li>
			<li>session : ${ sessionScope.num }</li>
	</ul>
   
   
   <hr>
   
   <h3>3. 조건문 - if (c:if 태그)</h3>
   
   <pre>
   		- 조건문을 작성할 수 있는 태그
   		
   		- if문만 가능하고 else는 불가능(c:else 존재하지 않음 )
   		
   		- c:if 속성
   		
   		test : 조건을 작성하는 속성 
   					단, EL로만 작성할 수 있다.
   					
   </pre>
   
   		<c:set var="temp"  value="10" />
   		
   		<c:if test="${ temp > 20 }" >
   			<!-- test에 작성된 조건이 만족(true)할 때만 화면에 출력됨 -->
   			temp는 20보다 크다
   		</c:if>
   		
   		<!-- else 구문이 없어 반대되는 조건을 별도 작성 -->
   		<c:if test="${ temp <= 20 }">
   			temp는 20보다 작거나 같다
   		</c:if>   
   		
   		<hr>
   		
   		<h3>4. 조건문 - if ~ else if ~ else (c:choose, c:when, c:otherwise")</h3>
   		
   		<pre>
   				c:choose 내부에
   				c:when (if / else if),
   				c:otherwise (else) 태그를 작성하는 형태 
   		</pre>
   
   		<c:set var="temp2"  value="10" />
   		
   		<c:choose>
   				<c:when test="${temp2 > 10 }">
   					10보다 크다
   				</c:when>
   				
   				<c:when test="${temp2 < 10 }">
   					10보다 작다
   				</c:when>
   				
   				<c:otherwise>
   					10과 같다
   				</c:otherwise>
   				
   		</c:choose>
   
   
   
   
   
</body>
</html>