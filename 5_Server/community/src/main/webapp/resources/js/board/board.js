// 상세조회, 게시글 작성 - "목록으로" 버튼

// 즉시 실행 함수
(function(){
    const gotoListBtn= document.getElementById("gotoListBtn");
    if(gotoListBtn != null){    // 목록으로 버튼이 화면에 있을 때만 버튼 추가 
        gotoListBtn.addEventListener("click",function(){

            // location 객체(BOM)
            // 문자열.substring(시작, 끝) 시작이상 끝 미만 인덱스까지 문자열 자르기
            // 문자열.indexOf("검색 문자열", 시작인덱스) 
            //    : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            //      단, 시작 인덱스 이후 부터 검색

            const pathname = location.pathname; //주소상에서 요청 경로 반환
            // /community/board/detail

            // 이동할 주소 저장
            let url = pathname.substring(0,pathname.indexOf("/",1));
            // /community

            url +="/board/list?" // /community/board/list?

            //URL 내장객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이지 주소 + 쿼리스트링
            // URL.searchParams : 쿼리스트링만 별도로 객체로 반환

            const params = new URL(location.href).searchParams;

            const type = "type=" +params.get("type"); //type=1 
            let cp;
            if(params.get("cp") != ""){//쿼리스트링에 cp가 있을 경우
                cp= "cp=" +params.get("cp"); //cp=1 
            }else{
                cp="cp=1";
            }

            //조립
            // /community/board/list?type=1&cp=1
            url += type + "&" + cp;

            //검색key나 query가 존재하는 경우 Url에 추가
            if(params.get("key")!= null){
                const key = "&key=" + params.get("key")
                const query = "&query=" + params.get("query")

                url += key + query
            }

            //location.href = "주소" ->해당 주소로 이동
            location.href=url;


        })
    }


})();

// 즉시 실행함수 : 성능 up, 변수명 중복 x
(function(){
    const deleteBtn = document.getElementById("deleteBtn"); // 존재하지 않으면 null

    if(deleteBtn != null){//버튼이 화면에 존재할 때
    
        deleteBtn.addEventListener("click", function(){
            // 현재 : /community/board/deatil?no=1561&cp=1&type=1
            // 목표 : /community/board/datail?no=1562&type=1
            // 상대경로 : datail?no=1562&type=1

            let url="delete";// 상대경로 형식으로 작성
            
            //주소에서 작성된 쿼리스트링에서 필요한 파라미터만 얻어와서 사용

            // 1) 쿼리스트링에 존재하는 파라미터 모두 얻어오기
            const params = new URL(location.href).searchParams;
            //location.href: 현재 페이지의 주소가 다들어감
            //searchParams : 파라미터를 찾는당
            //==>  현재 페이지에서 파라미터를 찾을(얻을) 수 있는 변수 생성

            // 2) 원하는 파라미터만 얻어와 변수에 저장
            const no = "?no=" + params.get("no"); // ?no=1582
            const type= "&type=" + params.get("type") // &type=1

            // url에 쿼리스트링 추가
            url += no + type; // delete?no=1562&type=1

            if(confirm("정말로 삭제하시겠습니까?")){
                location.href = url; // get 방식으로 url 요청
            }



        });
    }


})();

//검색창에 기존 검색기록 반영하기 
(function(){
    const select =document.getElementById("search-key");
    const input =document.getElementById("search-query");

    //const option = select.children;
    const option = document.querySelectorAll("#search-key > option");

    if(select != null){ //즉 검색 창화면이 존재할 때만 코드 적용

        // 현재주소에서 쿼리스트링(파라미터) 얻어오기
        const params = new URL(location.href).searchParams;
        
        //얻어온 파라미터 중 key와query만 변수에 저장
        const key = params.get("key");
        const query = params.get("query"); 

        //input에 query값 대입
        input.value = query;

        // option을 반복 접근해서 value와 key와 같으면 selectd 속성 추가 
        for(op of option){
            if(op.value == key){
                op.selected = true;
            }
        }

    }

})()


//검색 유효성 검사 (검색어를 입력했는지 확인)
function searchValidate(){
    const query = document.getElementById("search-query");

    if(query.value.trim().length ==""){
        query.value="";
        query.focus();
        alert("검색어를 입력해주세요")
        return false;
    }
    return true
}




// 즉시 실행 함수
(function(){
    const thumbnail = document.getElementsByClassName("list-thumbnail");


    if(thumbnail.length > 0){ // 목록에 썸네일 이미지가 있을 경우에만 이벤트 추가
     
        const modal = document.querySelector('.modal');
        const modalImage = document.getElementById("modal-image");
        const modalClose = document.getElementById("modal-close");


        for(let th of thumbnail){
            th.addEventListener("click", function(){
                modalImage.setAttribute("src", th.getAttribute("src") );
               
                /* on/off 스위치 */
                // classList.toggle("클래스명") : 클래스가 없으면 추가(add)
                //                                클래스가 있으면 제거(remove)
               
                modal.classList.toggle('show'); // add
            });
        }


        // X버튼
        modalClose.addEventListener("click", function(){
           
            modal.classList.toggle('hide'); // hide 클래스 추가


            setTimeout(function(){ // 0.45초 후 동작
                modal.classList.toggle('hide'); // hide 클래스 제거


                modal.classList.toggle('show'); // remove
            }, 450);
        });




    }


})();