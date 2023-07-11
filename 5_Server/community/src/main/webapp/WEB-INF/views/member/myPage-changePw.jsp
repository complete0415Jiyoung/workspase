<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%--문자열 관렬 함수(메소드) 제공 JSTL (EL형식) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">

    <script src="https://kit.fontawesome.com/a5af36132e.js" crossorigin="anonymous"></script>

</head>
<body>

    <main>
    	<!-- header.jsp연결 -->
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
       
        <!-- 마이페이지 내 정보-->
        <section class="myPage-content">
            
            <jsp:include page="/WEB-INF/views/member/sideMenu.jsp"/>
            
            <!-- 오른쪽 마이페이지 주요 내용 부분-->
            <section class="myPage-main">
                <h1 class="myPage-title">비밀번호 변경</h1>
                <span class="myPage-explanation">현재 비밀번호가 일치하는 경우 새비밀번호로 변경할 수 있습니다.</span>
               
                <!-- 
                	http://localhost:8080/community/member/myPage/changePw(GET방식)
                	http://localhost:8080/community/member/myPage/changePw(POST방식)
                 -->
               
                <form action="changePw" method="post" name="myPage-form">
                    
                    <div class="myPage-row">
                        <label>현재 비밀번호</label>
                        <input type="password" name="currentPw" id="currentPw" maxlength="30">
                    </div>
                    
                    <div class="myPage-row">
                        <label>새 비밀번호</label>
                        <input type="password" name="newPw" maxlength="30">
                    </div>
                    
                    <div class="myPage-row">
                        <label>새 비밀번호 확인</label>
                        <input type="password" name="newPwconfirm" maxlength="30">
                    </div>

                    <button id="info-update-btn">수정하기</button>
                </form>
            </section>
        </section>
       
    </main>

   <!-- footer.jsp연결 -->
   <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>