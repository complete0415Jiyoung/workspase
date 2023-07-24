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

                <h1 class="myPage-title">프로필</h1>
                <span class="myPage-explanation">프로필 이미지를 변경할 수 있습니다.</span>
                
                <form action="#" method="post" name="myPage-form">

                    <div class="profile-image-area">
                        <img src="${contextPath}/resources/images/user.png" id="profile-image">
                    </div>
                    <div class="profile-btn-area">
                        <label for="input-image">이미지 선택</label>
                        <input type="file" name="profileImage" id="input-image">
                        <button type="submit">변경하기</button>
                    </div>



                    <div class="myPage-row">
                        <label>이메일</label>
                        <span>${loginMember.memberEmail}</span>
                    </div>

                    <div class="myPage-row">
                        <label>가입일</label>
                        <span>${loginMember.enrollDate}</span>
                    </div>

                </form>
            </section>
            
        </section>
       
    </main>

   <!-- footer.jsp연결 -->
   <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<script src="${contextPath}/resources/js/member/myPage.js"></script>

</html>