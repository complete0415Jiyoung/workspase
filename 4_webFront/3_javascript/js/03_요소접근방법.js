//id로 접근하기
function eccessId(){

    const div1 = document.getElementById("div1");

    //접근한 요소의 배경색 얻어오기
    const bgColor= div1.style.backgroundColor;

    //***자바스크립트는 문자열 비교시에도 비교연산자 사용한다!!*** */
    if( bgColor == "red" ){

        //div1의 배경색을 yellow로 변경
        div1.style.backgroundColor="yellow";
        
    }else{

        //div1의 배경색을 red로 변경
        div1.style.backgroundColor="red";
    }

}

//class로 접근하기 
function accessClass(){

    //요소를 여러개 접근하는 경우 [배열] 형태로 반환됨
    const arr= document.getElementsByClassName("div2");

    //인덱스를 이용해서 요소에 하나씩 접근 
    arr[0].style.backgroundColor="pink";
    arr[0].innerHTML="첫 번째 요소";
    
    arr[1].style.backgroundColor="tomato";
    arr[1].innerHTML="두 번째 요소";
    
    arr[2].style.backgroundColor="skyblue";
    arr[2].innerHTML="세 번째 요소";

}

// //태그명으로 접근하기
// function accessTagName(){

//     //문서내 모든 il 태그 접근(배열 반환)
//     const arr = document.getElementsByTagName("li");

//     //반복문(java와 비슷)
//     for(let i=0; i<arr.length; i++){

//         const num = arr[i].innerText; //요소의 작성된 내용(숫자) 얻어오기
//        arr[i].style.backgroundColor="rgb(130, 220, "+(50 *num)+ ")";

//     }
// }
// -------------------------------------------------------------
function accessTagName(){

    const arr= document.getElementsByClassName("div2")
    
    for(let i= 0 ; i<arr.length; i++){
        const num= arr[i].innerHTML;
        arr[i].style.backgroundColor="rgb(130,220, "+(50*num)+")";
    }
}


//input 태그의 값 (value)얻어오기/ 변경하기
function inputTest(){

    //input요소 접근하기 
    const input = document.getElementById("input-test");

    //** innerText와 innerHTML은
    //요소의 내용(시작태그, 종료태그 사이에 작성된 내용)를
    //얻어오거나, 변경할때 만 사용
    
    //** input은 [value]를 이용해서 값을 얻어오거나, 변경할 수 있음

    console.log(input.value);

    //input에 작성된 값 변경하기
    input.value=''; //빈 문자열 == value 지우기
    
    //input에 초점 맞추기 -> focus()
    input.focus();


}

//name으로 접근하기
// function accessName(){
    
//     const hobbyList = document.getElementsByName("hobby");

//     let str="";
//     let count=0;

//     for( let i=0; i<hobbyList.length; i++ ){

//         //* rodio/checkbox 전용 속성*
//         // .checked :해당 요소가 체크되어 있으면 true/false 반환

//         if(hobbyList[i].checked){// 현재 요소가 체크되어 있으면

//             //str변수에 value누적
//             str += hobbyList[i].value +" ";
//             count++;//개수가 증가
//         }
//         //#name-div에 출력
//         document.getElementById("name-div").innerHTML = str;
//         //갯수 출력
//         document.getElementById("name-div").innerHTML += "<br>선택된 갯수 : "+ count;
//     }
// }

// -----------------------------------------------------------------
function accessName(){

    const hobbyList= document.getElementsByName("hobby");

    let str="";
    let count=0;

    for(let i=0; i<hobbyList.length; i++){
        if(hobbyList[i].checked){
            str += hobbyList[i].value +" ";
            count++;
        }    
        document.getElementById("name-div").innerHTML=str;
        document.getElementById("name-div").innerHTML +="<br>선택된 갯수: "+count;
    }

}

    //css선택자로 접근하기 
    function accessCss(){

        //querySelector() : 요소 한개 선택시 사용
        //                  (여러 요소가 선택되면 첫 번째 요소만 선택)

        //1개만 있는 요소 선택
        document.querySelector("#css-div").style.border = "3px solid red";

        //여러개 있는 요소- 첫번째 요소만 바뀜
        document.querySelector("#css-div > div").style.fontSize="30px";
        
        
        //querySelectorAll() : 모든 요소 선택시 사용
        const arr = document.querySelectorAll("#css-div > div");

        //배경색을 원하는 색상으로 바꾸고 실행
        for(let i=0; i<arr.length; i++){
            arr[i].style.backgroundColor="pink";
        }
        

    }

    //카카오톡 채팅 화면 만들기
    function readValue(){
        //채팅입력에 사용되는 요소 얻어 오기 
        const bg = document.getElementById("chatting-bg");

        const input = document.querySelector("#chatting-input");

        //input에 입력되는 값이 있을 경우
        if(input.value.trim().length > 0 ){

            //문자열.trim() :문자열 끝에 공백을 모두 제거
            //ex)"        k            h       ".trim()->"k            h"
        
            //input에 입력된 값을 얻어와서 bg에 추가(누적)
            bg.innerHTML += "<p><span>"+input.value+"</span></p>";

            //요소.scrollTop           : 요소 내부 스크롤 위치 반환
            //요소.scrollTop = 위치    : 스크롤을 특정 위치로 이동
            //요소.scrollHeight        :스크롤 전체 높이

            //bg의 스크롤 제일 밑으로 내리기

            bg.scrollTop = bg.scrollHeight;
        }

        //input 에 작성된 값 변경하기

        input.value =""; //빈문자열

        //input 초점 맞추기
        input.focus();

    }
// input태그 키가 눌러졌을 때 엔터인 경우를 검사하는 함수
    function inputEnter(event){
        //console.log(event.key);//현재 눌러진 키 반환
        if(event.key == "Enter"){
            readValue(); //함수 호출 
        }

    }

    // /////////////////////////////////////////////
    function readValuee(){
        const bg2= document.querySelector("#chatting-bg2");
        
        const input2 = document.querySelector("#chatting-input2");

        
        if(input2.value.trim().length>0){
            bg2.innerHTML += "<p><span>"+input2.value+"</span></p>"
            
            bg2.scrollTop=bg2.scrollHeight;

        }

        input2.value="";
        input2.focus();
    }

    function inputEnter2(event){
        if(event.key=='Enter'){
            readValuee();
    }

}
