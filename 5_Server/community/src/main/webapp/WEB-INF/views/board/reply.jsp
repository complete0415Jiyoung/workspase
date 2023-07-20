<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<div id="reply-area">
    <!-- 댓글 목록 -->
    <div class="reply-list-area">
        <ul id="reply-list">
            <c:forEach var="reply" items="${rList}">

                <li class="reply-row">
                    <p class="reply-writer">
                        <c:if test="${empty reply.profileImage}">
                            <!-- 프로필 이미지가 없을 경우 -->
                            <img src="${contextPath}/resources/images/user.png">
                        </c:if>
                        <c:if test="${!empty reply.profileImage}">
                            <!-- 프로필 이미지가 있을 경우 -->
                            <img src="${contextPath}${reply.profileImage}">
                        </c:if>


                        <span>${reply.memberNickname}</span>
                        <span class="reply-date">(${reply.createDate})</span>
                    </p>
    
                    <p class="reply-content">${reply.replyContent}</p>
                    
                    <c:if test="${loginMember.memberNo == reply.memberNo}">
                        <div class="reply-btn-area">
                            <button>수정</button>
                            <button>삭제</button>
                        </div>
                    </c:if>
                </li>

            </c:forEach>

            <li class="reply-row">
                <p class="reply-writer">
                    <img src="${contextPath}/resources/images/user.png">
                    <span>댓글 작성자 닉네임</span>
                    <span class="reply-date">(2023.20.20 10:22:22)</span>
                </p>

                <p class="reply-content">
                    댓글 내용입니다. <br>
                    이런식으로 출력될 예정
                </p>
                
                <div class="reply-btn-area">
                    <button>수정</button>
                    <button>삭제</button>
                </div>
            </li>
        </ul>
    </div>
    <!-- 댓글 작성 부분 -->
    <div class="reply-write-area">
        <textarea id="replyContent"></textarea>
        <button id="addReply">
            댓글<br>
            등록
        </button>
    </div>
</div>

