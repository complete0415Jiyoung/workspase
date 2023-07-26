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

            //location.href = "주소" ->해당 주소로 이동
            location.href=url;


        })
    }


})();