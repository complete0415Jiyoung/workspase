/* 아이디 : 값이 변했을 때 
영어 소문자로 시작하고, 
영어 대/소문자, 숫자, - , _ 로만 이루어진 6~14 글자 사이 문자열인지 검사
아이디 정규표현식 : (각자 작성)

- 형식이 일치할 경우
입력창의 배경색을 green 으로 변경

- 형식이 일치하지 않은 경우
입력창의 배경색을 red, 글자색을 white 로 변경*/

//내가 쓴 정규 표현식 : const regExp = /^[a-z]{1,}([\w]|[\d]|-|_){6,14}$/

const inputId = document.getElementById("inputId");
const regExp = /^[a-z](\d|\w|\-|_){5,13}$/;
//첫 글자 사용 했기 때문에 {5~13}까지
inputId.addEventListener("keyup", function(){ //change는 사용 안된 다른 창으로 넘어갔을때 

    if(regExp.test(inputId.value)){
        this.style.backgroundColor = "green";
    } else{
        this.style.background = "red";
        this.style.color = "white";
    }
})

// ------------------------------------------------------------------

/* 비밀번호, 비밀번호 확인 : 키보드가 올라올 때 
"비밀번호" 를 미입력한 상태에서 "비밀번호 확인"을 작성할 경우
"비밀번호 확인"에 작성된 내용을 모두 삭제하고
'비밀번호를 입력해주세요' 경고창 출력 후
focus 를 "비밀번호" 입력창으로 이동
*/
const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPwConfirm");

inputPwConfirm.addEventListener("keyup", function(){
    if(inputPw.value.length == 0){
        this.value = "";
        alert("비밀번호를 입력해주세요");
        inputPw.focus();
    }
});


// ------------------------------------------------------------------

/*
- 비밀번호가 일치할 경우
"비밀번호" 입력창 오른쪽에 "비밀번호 일치" 글자를 초록색으로 출력.

- 비밀번호가 일치하지 않을 경우
"비밀번호" 입력창 오른쪽에 "비밀번호가 불일치" 글자를 빨간색으로 출력

- 비밀번호가 작성되지 않은경우 오른쪽에 출력되는 문구 삭제

*/
const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", function(){

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0  ){
        pwMessage.innerText = "비밀번호 일치";

        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

    } else{
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
    }

    if( inputPw.value.length == 0 && inputPwConfirm.value.length == 0 ){
        pwMessage.innerText = "";
    }
});

inputPwConfirm.addEventListener("keyup", function(){

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0  ){
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

    } else{
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
    }

    if( inputPw.value.length == 0 && inputPwConfirm.value.length == 0 ){
        pwMessage.innerText = "";
    }
});


// -------------------------------------------------------------

/* 이름 : 값이 변화했을 때 
한글 2~5 글자 사이 문자열인지 검사.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "정상입력" 글자를 초록색으로 출력.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "한글만 입력하세요" 글자를 빨간색으로 출력.
*/
const inputName = document.getElementById("inputName");
const nameMessage = document.getElementById("nameMessage");
inputName.addEventListener("keyup", function(){
    const regExp = /^[가-힣]{2,5}$/;

    if(regExp.test(inputName.value)){
        nameMessage.innerText =  "정상입력";
        nameMessage.style.color = "green";

    } else {
        nameMessage.innerText =  "한글만 입력하세요";
        nameMessage.style.color = "red";
    }

    if(inputName.value.length == 0){
        nameMessage.innerText =  "";
    }
})

// -----------------------------------------------------------

/* 회원가입 버튼 클릭 시 : validate() 함수를 호출하여 
성별이 선택 되었는지, 전화번호가 형식에 알맞게 작성되었는지 검사 */

function validate(){

    /*- 성별이 선택되지 않은 경우 
    "성별을 선택해주세요." 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.*/
    const gender = document.getElementsByName("gender");

    if(!gender[0].checked&& !gender[1].checked){
        alert("성별을 선택해주세요");

        return false;
    }
        

    /*
    - 전화번호 형식이 올바르지 않을 경우 
    "전화번호의 형식이 올바르지 않습니다" 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.
    */

    const tel= document.getElementById("inputTel");
    const regExp = /^[0][0-9]{1,2}-[0-9]{3,4}-[0-9]{4}$/
    
    //전화번호를 입력하지 않았을때
    // "전화 번호를 입력해주세요" 경고창 출력
    if(tel.value.length==0){
        alert("전화번호를 입력해주세요")
        return false;

    }

    if(!regExp.test(tel.value)){
        alert("전화번호의 형식이 올바르지 않습니다.")

        return false;
    }
    






}