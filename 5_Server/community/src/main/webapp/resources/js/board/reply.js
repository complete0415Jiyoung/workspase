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
            const replyList = document.getElementById("reply-list"); //ul태그
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
                if(loginMemberNo == reply.memberNo){

                    // 버튼 영역
                    const replyBtnArea = document.createElement("div");
                    replyBtnArea.classList.add("reply-btn-area");
                    
                    // 수정버튼
                    const updateBtn = document.createElement("button")
                    updateBtn.innerText="수정"
                    // 수정 버튼에 onclick이벤트 추가
                    updateBtn.setAttribute("onclick",showUpdateReply("+reply.replyNo+",this));

                    // 삭제버튼
                    const deleteBtn = document.createElement("button")
                    deleteBtn.innerText="삭제"
                    // 삭제 버튼에 onclick이벤트 추가 
                    deleteBtn.setAttribute("onclick", "deleteReply("+reply.replyNo+")");
    
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
// -------------------------------------------------------

// 댓글 등록
const addReply = document.getElementById("addReply");
const replyContent = document.getElementById("replyContent");

addReply.addEventListener("click",function(){ //댓글 등록 버튼이 클릭 되었을 때
    
    // 1) 로그인이 되어 있는가? -> 전역 변수인 loginMemberNo 이용
    if(loginMemberNo == ""){ //로그인 X
        alert("로그인 후 이용해주세요.");
        return;
    }

    // 2) 댓글에 내용이 작성되어 있나?
    if(replyContent.value.trim().length == 0){//미작성인 경우
        alert("댓글을 작성한 후 버튼을 클릭해주세요");
        replyContent.value=""; // 띄어쓰기, 개행문자 제거 
        replyContent.focus();
        return;
    }

    // 3) AJAX을 이용해서 댓글 내용 DB에 저장(insert)
    $.ajax({
        url : contextPath + "/reply/insert",
        data: {"replyContent": replyContent.value,
                "memberNo": loginMemberNo,    
                "boardNo":boardNo},

        type: "POST",
        success: function(result){

            if(result > 0){
                alert("댓글 등록 성공");

                replyContent.value = ""//댓글 지우기 
                
                selectReplyList();//비동기 댓글 목록 조회 함수 호출


            }else{
                alert("댓글 등록 실패했습니다.");
            }
        },
        error: function(req, status, error){
            console.log("댓글 등록 실패");
            console.log(req.responseText);
        }

    })
});

//------------------------------------------------------------------------

// 댓글 삭제
function deleteReply(replyNo){
    
    if( confirm("정말로 삭제하시겠습니까?")){
        //요청주소  : /community/reply/delete
        // 파라미터 key : "replyNo" , value :매개변수 replyNo
        //전달 방식 : "Get"
        //sucess : 삭제 성공 시 -> "삭제 되었습니다." alert로 출력 호출  후 
        //                  댓글 목록 비동기 조회 함수 호출
        //          삭제 실패시  -> 삭제 실패  arelt로 출력

        //error : 앞 error코드 참고 
        //DB에서 댓글 삭제  ==> REPLY_ST ='Y' 변경


        $.ajax({

            url : contextPath +"/reply/delete",
            data : {"replyNo": replyNo},
            type : "GET",
            success:function(result){
                if(result > 0){
                    alert("삭제되었습니다");
    
                    selectReplyList();// 목록 다시 조회 삭제된 글 제거    
    
                }else{
                    alert("댓글 삭제 실패했습니다.");
                }
            },
            error:function(req, status, error){
                console.log("댓글 삭제 실패");
                console.log(req.responseText);
            }
        })
    }
}
//----------------------------------------------------------------------------
// 댓글 수정 화면 전환

function showUpdateReply(replyNo, btn){
                    //댓글 번호 , 이벤트가 발생한 요소 (수정버튼)
    
}
