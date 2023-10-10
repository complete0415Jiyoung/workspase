// 좋아요 버튼이 클릭 되었을 때
const boardLike = document.getElementById("boardLike");

boardLike.addEventListener("click", e=>{
    
    // 로그인 여부 검사
    if(loginMemberNo == ""){
        alert("로그인후 이용해 주세요")
        return;
    }

    let check; // 기존에 좋아요 X (빈하트)    : 0,
               // 기존에 좋아요 O (꽉찬 하트) : 1
    // contains("클래스명") : 클래스가 있으면 true, 없으면 false
    if(e.target.classList.contains("fa-regular")){ // 좋아요 X(빈하트)
        check = 0;
    }else{ //좋아요 O(꽉찬하트)
        check = 1;
    }

    // ajax 서버로 제출할 파라미터를 모아둔 JS 객체
    const data = {"boardNo": boardNo,
                "memberNo": loginMemberNo,
                "check": check
    }
    //로그인 회원 번호 , 게시글 번호, check

    //ajax 코드 작성
    fetch("/board/like", {
        method: "POST",
        headers: {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(response => response.text()) //응답 객체를 필요한 형태로 파싱하여 return
    .then(count =>{
        console.log("count:"+ count)

        if(count == -1){ //inaert, delete 실패
            console.log("좋아요 처리 실패")
            return;
        }

        //toggle() : 클래스가 있으면 없애고 , 없으면 추가
        e.target.classList.toggle("fa-regular");
        e.target.classList.toggle("fa-solid");

        // 현재 게시글의 좋아요 수 화면에 출력
        e.target.nextElementSibling.innerText = count;

    }) // 파싱된 데이터를 받아서 처리하는 코드를 작성

    .catch(err =>  {
        console.log("예외 발생");
        console.log(err);
    })//예외 발생 시 처리 할 구문

})

if(loginMemberNo != ""){
   // 게시글 수정 버튼 클릭시 
    document.getElementById("updateBtn").addEventListener("click", ()=>{

        // 요청 주소 - /board2/1/1507/update?cp=1 (GET방식)
        location.href= location.pathname.replace("board","board2")
                        + "/update"
                        + location.search  //?ch=?
    });


    // 게시글 삭제 버튼이 클릭 되었을 때
    document.getElementById("deleteBtn").addEventListener("click", () => {

        if(confirm("정말 삭제 하시겠습니까?")){
            location.href 
            = location.pathname.replace("board","board2")
                + "/delete";
            //   /board2/1/2006/delete (GET)

            // 삭제 서비스 호출 성공 시 redirect:/board/{boardCode}
            // + RedirectAttributes 이용해서 "삭제 되었습니다" alert 출력

            // 삭제 서비스 호출 실패 시 redirect:/board/{boardCoed}/{boardNo}
            // + RedirectAttributes 이용해서 "삭제 실패" alert 출력
        }
    }) 
}

// 목록으로 
document.getElementById("goToListBtn").addEventListener("click",()=>{
    
    // 이동할 주소 저장
    let url = "/board/"+ boardCode
    
    //  URL 내장 객체 : 주소 관련 정보를 나타내는 객체
    // URL.searchParams : 쿼리스트링만 별도 객체로 반환

    const params = new URL(location.href).searchParams;

    let cp;
    let key;
    let query;
    if(params.get("cp")!= "") { // cp가 있을 경우
        cp = "?cp=" + params.get("cp");
    }

    // 검색 key, query가 존재하는 경유 url에 추가
    if(params.get("key") != null){
        key = "&key="+ params.get("key");
        query = "&query="+ params.get("query");
    }

    url += cp + key + query


    // location.href = "주소"; -> 해당 주소로 이동 
    location.href = url;
    
    // 이전 주소로 가기
    // 문제점 : 수정하기 후 목록으로했을 때 문제가 있음!
    //location.href = document.referrer;

    /* // 지영 풀이 
    if(key != ""){
        url += "?key="+ key +"&query="+ query;
    }
    if(cp != null){
       url += "&cp="+cp;
    }
    location.href = url;
    */
})

