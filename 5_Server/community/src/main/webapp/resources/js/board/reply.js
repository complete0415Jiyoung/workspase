// selectReplyList();

// 댓글 목록 조회(AJAX)
function selectReplyList(){

    // contextPath , boardNo, memberNo 전역변수 사용
    $.ajax({
        url: contextPath + "/reply/selectReplyList",
        data : {"boardNo" : boardNo},
        type : "get",

        dataType : "JSON", //JSON형태의 문자열 응답 데이터를 Js 객체로 자동 반환

        success : function(rList){
            //rList : 반환 받은 댓글 목록
            console.log(rList);

            // 화면에 출력 되어 있는 댓글 목록 삭제
            const replyList =document.getElementById("reply-list"); //ul태그
            replyList.innerHTML="";

            //rList에 저장된 요소 하니씩 접근해서 
            for(let reply of rList){

                // 행 
                const replyRow = document.createElement("li");
                replyRow.classList.add("reply-row");

                // 작성자
                const replyWriter = document.createElement("p");
                replyWriter.classList.add("reply-writer");

                //프로필 이미지
                const profileImage= document.createElement("img");

                if(reply.profileImage != null){ // 프로필 이미지가 있는 경우
                    
                    profileImage.setAttribute("src", contextPath + reply.profileImage);

                }else{// 없는 경우 == 기본이미지
                    profileImage.setAttribute("src", contextPath + "/resources/images/user.png" );
                }
                
                // 작성자 닉네임
                const memberNickname= document.createElement("span");
                memberNickname.innerText= reply.memberNickname;

                // 작성일
                const replyDate = document.createElement("span")
                replyDate.classList.add("reply-date");
                replyDate.innerText= "("+reply.createDate+")";
                
                // 작성자 영역(P)에 프로필, 닉네임, 작성일 마지막 자식으로 추가
                replyWriter.append(profileImage,memberNickname,replyDate)
 
                // 댓글 내용
                const replyContent = document.createElement("p");
                replyContent.classList.add("reply-content");
                
                //왜 innHtml이냐<br> 인식해야하니꽈~
                replyContent.innerHTML=reply.replyContent
                
                // 행에 작성자, 내용, 버튼 영역 추가 
                replyRow.append(replyWriter, replyContent);

                //로그인한 회원번호와 댓글 작성자의 회원번호와 같을 때만 버튼 추가
                if(loginMember.memberNo= reply.memberNo){

                    // 버튼 영역
                    const replyBtnArea = document.createElement("div");
                    replyBtnArea.classList.add("reply-btn-area");
                    
                    // 수정버튼
                    const updateBtn = document.createElement("button")
                    updateBtn.innerText="수정"
                    // 삭제버튼
                    const deleteBtn = document.createElement("button")
                    deleteBtn.innerText="삭제"
    
                    // 버튼 영역 마지막 자식으로 수정/삭제 버튼 추가 
                    replyBtnArea.append(updateBtn,deleteBtn);

                    // 행에 버튼 영역만 추가 
                    replyRow.append(replyBtnArea)
                }
                
                // 댓글 목록(ul)에 행(li)추가
                replyList.append(replyRow);
            }

        },
        error: function(){
            console.log("에러발생")
        }
   
    })
}
