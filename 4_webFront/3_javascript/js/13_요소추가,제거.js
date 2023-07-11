//#add버튼 클릭 되었을 때
document.getElementById("add").addEventListener("click",function(){
    
    // div요소 생성
    const div = document.createElement("div");
    //div에 row 클래스 추가
    div.classList.add("row");

    //----------------------------------------

    // input요소 생성
    const input =document.createElement("input");

    //input에 in 클래스 추가 
    input.classList.add("in");
    //input의 "type" 속성, number 속성값 추가 (

    //요소.setAttribute("속성","속성값") :요소 추가
    input.setAttribute("type", "number")
    

    //-----------------------------------------
    // span요소 생성
    const span =document.createElement("span");

    //span에 remove 추가
    span.classList.add("remove");

    //span의 내용으로 X추가
    span.innerHTML ="X";

    //span이 클릭 되었을 때 이벤트 동작 추가
    span.addEventListener("click", function(){
        //요소.prentElement : 부모요소

        //요소.remove(): 요소 삭제
        //부모(.row)제거
        span.parentElement.remove();

    })
    //-------------------------------------------------------

    //div내부에 (자식으로 )input, sapn 순서대로 추가하기
    
    div.append(input);
    div.append(span);
    
    //#container에 div을 마지막 자식으로 추가 
    document.getElementById("container").append(div);
    

})

//----------------------------------------------------------------------//
//계산 버튼 클릭시 이벤트 동작
document.getElementById("calc").addEventListener("click",function(){
    
    //합계저장용 변수 
    let sum = 0;
    
    //in 클래스 요소 모두 얻어오기 -> 배열 형태 
    const list = document.getElementsByClassName("in");

    //배열용 향상 for문 (for of)
    for(let input of list){
        
        //sum에 입력값 누적
        //-> input에 입력 된 값은 모두 String -> 숫자 변환 Number 필요

        sum += Number(input.value);

        //Number("")==0 //빈칸은 0으로 변환 되기 때문에 노상관 신경 쓰지 말자
        
    }


    //sum을 alert로 출력
    alert("합계 : " + sum);
})