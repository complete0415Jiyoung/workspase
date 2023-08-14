const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");


if(loginFrm != null){

    //로그인 시도를 할 때 
    loginFrm.addEventListener("submit", e =>{
        //alert("로그인");
    
        if(memberEmail.value.trim() == "" ){
            alert("이메일을 입력해주세요");
            // form 기본 이벤트 제거 
           
            //잘못입력된 값(공백)제거
            //이메일 input 태그에 초점 맞추기
            
            memberEmail.value ="";
            memberEmail.focus();
            //제출 못하게 막기
            e.preventDefault();
            return;
        }
        if(memberPw.value.trim() == "" ){
            alert("비밀번호을 입력해주세요");
            // form 기본 이벤트 제거 
           
            //잘못입력된 값(공백)제거
            //비밀번호 태그에 초점 맞추기
            memberPw.value = "";
            memberPw.focus();
            
            //제출 못하게 막기
            e.preventDefault();
            return;
        }
        
    
    
    });
}