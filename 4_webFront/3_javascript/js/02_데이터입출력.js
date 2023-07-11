// alert 확인
function fnAlert(){
    alert("alert버튼 클릭 됨");
    
    //window 는 부라우저 자체를 나타내는 객체
    //->JS 코드는 (window) 내부에서 실행되는 코드이다 보니 
    //  window 생략 할 수 있다
}
//document.write 확인
function documentWrite(){
    //document.write("안녕하세요");
    //document.write("<br> <b>안녕하세요</b><br> <br> <h2>반가워요</h2>안녕하세요");

    //출력할 문구에 html 태그가 있을 경우 해석해서 시각적인 요소로 보여짐

    let a= "<table border='1'>";
    
    a+= "<tr>";
    a+= "<td>1</td>";
    a+= "<td>2</td>";
    a+= "</tr></table>";

    document.write(a);
    

}
//innerText읽어오기 
function getinnerText(){
    //HTML 문서  내에서 아이디가 "text1"인 요소를 얻어와
    //test1변수에 대입
    const test1 = document.getElementById("test1");

    //test1변수에 대입된 요소에서 내용을 얻어와 console에 출력
    console.log(test1.innerText);
}


//innerText로 변경하기
function setinnerText(){
    //id 가 "test1"인 요소를 얻어와 
    //test1 변수에 대입
    const test1 = document.getElementById("test1");

    //test1변수에 대입된 요소에 새로운 내용을 작성
    test1.innerText="innertext로 변경된 <br> 내용입니다";
}

//innrHTML로 읽어오기
function getInnerHTML1(){
    //id가 test2인 요소를 얻어와 
    //test2 변수에 대입
    const test2 = document.getElementById("test2");

    //test2요소 내부에 내용(태그 +속성+ 내용)을 읽어와 콘솔에 출력 
    console.log(test2.innerHTML);
    

}

//innerHTML로 변경하기 
function setInnerHTML1(){
    const test2= document.getElementById("test2");

    test2.innerHTML="<b>innerHTML로 변경된 내용</b> <br>반갑습니다.";
}

//innerHTML응용
function add(){
    //1) 아이디가 area1인 요소 얻어오기
    const area1 = document.getElementById("area1");

    //2) area1 내부 내용 (태그, 속성, 내용 포함)을 모두읽어오기
   //const content = area1.innerHTML;

    //3)area1에 이전 내용 + 새로운 요소 (div. box2)추가
    //area1.innerHTML = content +"<div class='box2'></div>"

    //2번)+3번)
    area1.innerHTML += "<div class='box2'></div>";

}
function fnContirm(){
    //확인
    if(confirm("버튼 배경색을 분홍색으로 바꾸시겠습니까?")){
        document.getElementById("confirmBtn").style.backgroundColor="pink";
    }else{
        document.getElementById("confirmBtn").style.backgroundColor="green";
    }

}
//prompt확인하기
function fnPrompt1(){
    var name = prompt("당신의 이름은 무엇입니까?");
    var age = prompt("당신의 나이는?");

    //console.log(name);
    //console.log(age);

    const divE1= document.getElementById("area2");
    divE1.innerHTML = "<b>앗, 당신이 바로 "+ age+ "살 "+ name+"님이시군요..!!</b>";

}

function fnPrompt2(){

    const input = prompt("이름을 입력해주세요");
    const propmtResult = document.getElementById("area3");

    if(input != null){//이름이 입력되었을때 
        propmtResult.innerHTML= input+"님 환영합니다.";
    }else{
        //취소버튼 눌렀을때 
        propmtResult.innerText="이름을 입력해주세요";

    }

}
//선택한 input 요소.value확인하기******
function fuInput(){
    const input1= document.getElementById("userId");
    const input2= document.getElementById("userPwd");

   //console.dir(input1);

    let id = input1.value;
    const pwd = input2.value;

    console.log(id);
    console.log(pwd);

    document.getElementById("area4").value= id + ", " + pwd;
  
    input1.value='';
    input2.value="";

}
