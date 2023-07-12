console.log("main.js loaded.");

// 로그인시 이메일 아이디와 /비밀번호 입력확인 

// -> 미작성시 alert()이용해서 메세지를 출력하고 
//    로그인 form태그의 제출을 막는 기본 이벤트 진행
//    onsubmit= "return false "

function loginValidate(){//로그인 유효성 검사 
    // validate   : 유효하다
    // invalidate : 무효하다

    //이메일 입력 input 요소 
    const inputEmail = document.getElementsByName("inputEmail")[0];
    console.log(inputEmail);

    // 비밀번호 입력 input 요소
    const inputPw = document.getElementsByName("inputPw")[0];

    //이메일이 입력되지 않은 경우 false 반환
    if(inputEmail.value.trim().length == 0){
        //문자열.trim() : 문자열 양쪽 공백 제거
        //문자열.length : 문자열 길이 (몇 글자?)
        alert("이메일을 입력해주세요")
        
        inputEmail.value = ""; //이메일 input 입력된 내용 삭제
        inputEmail.focus(); //이메일 input 에 포커스
        return false;
    }

    //비밀번호 입력되지 않은 경우 false 반환
    if(inputPw.value.trim().length == 0){
        alert("비밀번호를 입력해주세요");
       
        inputPw.value = ""; //비밀번호 input 입력된 내용 삭제
        inputPw.focus(); //비밀번호 input에 포커스
        return false;
    }

    return true; // form 태그 기본 이벤트 정상 수행 
}

// 아이디 저장 체크박스가 체크되었을 때 이벤트 처리 

// radio, checkbox 체크시 change 이벤트 발생

document.getElementById("saveId").addEventListener("change",function(){
    //체크여부 확인 
    console.log(this.checked)
    //this : cjhange 이벤트가 발생한 요소 (체크박스)
    
    if(this.checked){
        //체크박스가 체크된 경유
        const str ="개인정보를 위해 개인 PC에서 사용을 권장합니다. 개인PC가 아닌 경우 취소를 눌러주세요"
        
        //confirm(str) //확인(ture) / 취소 (false) 대화상자

        if(!confirm(str)){ // 취소를 눌렀을 때 
              // 체크 해제
            this.checked = false;

        }
    }
})



