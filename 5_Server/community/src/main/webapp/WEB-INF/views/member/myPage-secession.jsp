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
                <h1 class="myPage-title">회원 탈퇴</h1>
                <span class="myPage-explanation">현재 비밀번호가 일치하는 경우 탈퇴할 수 있습니다.</span>
                
                <!-- 가야할 주소와 현재 주소가 겹칠 때는 마지막 주소만 쓰면 된당(GET/POST) -->
                <!-- 
                	http://localhost:8080/community/member/myPage/secession(GET방식)
                	http://localhost:8080/community/member/myPage/secession(POST방식)
                 -->
                <form action="secession" method="post" name="myPage-form">
                    <div class="myPage-row">
                        <label>비밀번호</label>
                        <input type="password" name="memberPw" maxlength="30">
                    </div>

                    <div class="myPage-row info-title">
                        <label>회원탈퇴 약관</label>
                    </div>
                    <pre id="secession-terms">
제1조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4


제2조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4
                        
                    </pre>
                    <div>
                        <input type="checkbox" name="agree" id="agree">
                        <label for="agtree">위 약관에 동의합니다.</label>
                    </div>



                    <button id="info-update-btn">탈퇴</button>


                </form>
            </section>
        </section>
       
    </main>

   <!-- footer.jsp연결 -->
   <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>