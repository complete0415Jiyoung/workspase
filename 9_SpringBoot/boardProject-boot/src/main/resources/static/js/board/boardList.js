const insertBtn = document.getElementById("insertBtn");

// 글쓰기 버튼 을 클릭했을 때 

if(insertBtn != null){

    insertBtn.addEventListener("click", ()=>{
        // JS BOM 객체 location

        // location.href="주소"
        // 해당 주소 요청(GET방식)
       
        // location.href="/board2/"+location.pathname.split("/")[2]
        location.href=`/board2/${location.pathname.split("/")[2]}/insert`
                    //board2/1/insert
    })
}

// 검색창 이전의 기록 남겨 놓기 
const boardSearch = document.querySelector("#boardSearch");
const searchKey = document.querySelector("#searchKey");
const searchQuery = document.querySelector("#searchQuery");
const options = document.querySelectorAll("#searchKey > option");

(()=>{
    const params = new URL(location.href).searchParams;
    const key = params.get("key"); //t,c,tc,w중  하나
    const query = params.get("query"); // 검색어

    if(key != null){ // 검색을 했을 때
        searchQuery.value=query; // 검색어를 화면에 출력 
    
        // option태그를 하나씩 순차접근해서 value가 key랑 같으면
        // selected속성 추가
        for(let op of options){
            if(op.value == key){
                op.selected = true;
            }

        }
    }
})();

//검색어 없이 제출된 경우 
boardSearch.addEventListener("submit", e =>{
    if(searchQuery.value.trim().length == 0){
        e.preventDefault();

        location.pathname//해당게시판 1페이지로 이동 

        //location.pathname : 쿼리스트링을 제외한 실제 주소
    }
})