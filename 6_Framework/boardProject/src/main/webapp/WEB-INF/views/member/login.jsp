<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>


    <link rel="stylesheet" href="/resources/css/member/login.css">


    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>


<body>
    <main>


        <section class="logo-area">
            <a href="/">
                <img src="/resources/images/logo.jpg">
            </a>
        </section>




        <form id="loginFrm" action="/member/login" method="post">
            <section class="input-box">
                <input type="text" name="memberEmail" placeholder="Email" value="${cookie.saveId.value}"/>
            </section>


            <section class="input-box">
                <input type="password" name="memberPw" placeholder="Password"/>
            </section>


            <button class="login-btn">Login</button>


            <%-- 쿠키에 saveId가 있는 경우--%>
            <c:if test="${ !empty cookie.saveId.value}">
                <%-- chk 변수 생성(page scope)--%>
                <c:set var="chk" value="checked"/>
            </c:if>


            <div class="saveId-area">
                <input type="checkbox" name="saveId" id="saveId" ${chk}>
                <label for="saveId"><i class="fas fa-check"></i>아이디 저장</label>
            </div>


            <p class="text-area">
                <a href="#">회원가입</a>
                |
                <a href="#">ID/PW 찾기</a>
            </p>
        </form>
    </main>

    <%-- main.js 추가 --%>
    <script src="/resources/js/main.js"></script>
  </body>
</html>