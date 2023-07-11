<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>KH 커뮤니티</title>

<link rel="stylesheet" href="../resources/css/main-style.css">
<link rel="stylesheet" href="../resources/css/signUp-style.css">

<script src="https://kit.fontawesome.com/a5af36132e.js"
	crossorigin="anonymous"></script>

</head>
<body>



	<main>
		<!-- header include -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>


		<!-- 회원 가입 -->
		<section class="signUp-content">

			<form action="#" method="post" name="signUp-form">
				<!-- 회원가입 화면 전환 주소(GET)와 같은 주소로 
                    실제 회원가입을 요청 (POST)
                    -> 요청 주소가 같아도 데이터 전달 방식이 다르면 중복 허용
                -->

				<!-- 절대경로 : /community/member/signUp 

                     현재주소 : /community/member/signUp 
                     상대경로 : signUp
                
                -->

				<label for="memberEmail"> <span class="required">*</span>
					아이디(이메일)
				</label>

				<div class="signUp-input-area">
					<input type="text" id="memberEmail" name="memberEmail"
						placeholder="아이디(이메일)" maxlength="30" autocomplete="off" required>

					<!-- autocomplete="off" : 자동완성 미사용 -->
					<!-- required : 필수 작성 input 태그 -->

					<button type="button">인증번호 받기</button>

				</div>

				<span class="signUp-message">메일을 받을 수 있는 이메일을 입력해주세요.</span> <label
					for="emailCheck"> <span class="required">*</span> 인증번호

				</label>

				<div class="signUp-input-area">
					<input type="text" id="emailCheck" placeholder="인증번호 입력"
						maxlength="6" autocomplete="off">

					<button type="button">인증하기</button>
				</div>

				<span class="signUp-message confirm">인증되었습니다.</span> <label
					for="memberPw"> <span class="required">*</span> 비밀번호

				</label>

				<div class="signUp-input-area">
					<input type="password" id="memberPw" name="memberPw"
						placeholder="비밀번호" maxlength="30" autocomplete="off">
				</div>

				<div class="signUp-input-area">
					<input type="password" id="memberPwConfirm" placeholder="비밀번호 확인"
						maxlength="30" autocomplete="off">
				</div>

				<span class="signUp-message error">비밀번호가 일치하지 않습니다.</span> <label
					for="memberNickname"> <span class="required">*</span> 닉네임

				</label>

				<div class="signUp-input-area">
					<input type="text" id="memberNickname" name="memberNickname"
						placeholder="닉네임" maxlength="10">

				</div>

				<span class="signUp-message confirm">사용 가능한 닉네임 입니다.</span> <label
					for="memberTel"> <span class="required">*</span> 전화번호

				</label>

				<div class="signUp-input-area">
					<input type="text" id="memberTel" name="memberTel"
						placeholder="(-없이 숫자만 입력)" maxlength="11">

				</div>

				<span class="signUp-message error">전화번호 형식이 올바르지 않습니다.</span> <label
					for="memberAddress"> 주소 </label>

				<div class="signUp-input-area">
					<input type="text" id="memberAddress" name="memberAddress"
						placeholder="우편번호" maxlength="6">

					<button type="button">검색</button>
				</div>

				<div class="signUp-input-area">
					<input type="text" name="memberAddress" placeholder="도로명주소">

				</div>

				<div class="signUp-input-area">
					<input type="text" name="memberAddress" placeholder="상세주소">
				</div>

				<button type="submit" id="signUp-btn">가입하기</button>

			</form>

		</section>

	</main>

	<!-- footer include -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


</body>
</html>