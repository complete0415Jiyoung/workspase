
// 색 출력 영역

// 요소를 얻어와서 변수에 저장
// 클래스명, 태그명, name속성값,querySelectorAll()같은 경우
// 요소를 얻어올 때 배열 형식으로 반환 !!!!!!!!!!!!!!!!!**


const container = document.querySelector('.container');

const area = document.getElementsByClassName("area");
const box = document.getElementsByClassName("box");
const boxColor =document.getElementsByClassName("box-color");


// JS로 CSS 추가하기

// container 클래스 요소에 display : flex 추가
container.style.display='flex';


// area 클래스 요소에
// 높이 170px, 너비 150px, 테두리 1px 검정색 실선
// display : flex, main-axis 방향 : 열(세로)

//일반for문 || for of
for( let i=0; i<area.length; i++ ){
    // i ==area 배열에 담긴 요소를 순차적으로 하나씩 꺼내서 저장하는
    area[i].style.height="170px";
    area[i].style.width="150px";
    area[i].style.border="1px solid black";
    area[i].style.display="flex";
    area[i].style.flexDirection="column";

}

// box 클래스 요소에 높이 150px, 아랫쪽 테두리 1px 실선 검정색
for( let i=0; i<box.length; i++ ){
    box[i].style.height="150px";
    box[i].style.borderBottom= "1px solid black";
   
}

// box-color 클래스 요소의 테두리와 outline을 없애기
for( let item of boxColor){

    item.style.border="none";
    item.style.outline="none";
}

// box-color 클래스 요소의 입력된 값이 변했을 때
// 위에있는 box 클래스 요소의 배경색을 변경
// + 입력된 input요소 글씨색도 변경
for(let i=0 ; i < boxColor.length ; i++){
    //change : 포커스를 잃고 나서 엔터 입력시 작성된 값이 이전과 다른 경우
    //blur : 포커스를 잃었을 때

    boxColor[i].addEventListener("change",function(){
        //boxColor input태그와 같은 인뎃스 번째 box 요소 배경 색 변경

        box[i].style.backgroundColor = this.value;

        //글자색 변경
        this.style.color =this.value
    })


}




// transition-duration 변경 버튼 클릭 시
// #input1에 작성된 값 만큼의 transition-duration을
// 모든 box 요소에 추가
// + #print1 요소의 내용을 #input1에 작성된 값으로 변경

// hint.  transition-duration에 세팅되는 값은 초단위(s) 입니다.
document.getElementById("btn1").addEventListener("click",function(){

    const duration = document.getElementById("input1").value

    //#print1요소의 내용을 #input1에 작성된 값으로 변경
    document.getElementById("print1").innerText=duration;

    for(let item of box){//box배열에 담긴 요소를 하나씩 꺼내서 item에 저장
        item.style.transitionDuration=duration;

    }
})


// #clearBtn 클릭 시
// .box의 모든 배경색을 없애고
// .box-color에 작성된 값도 없애기

document.getElementById("clearBtn").addEventListener("click",function(){
    for(let item of box){//.box 배경색 삭제
        item.style.backgroundColor="";

    }
    for(let item of boxColor){//.box-color 값 삭제
        item.value="";
    }
})