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

// 비동기로 이메일이 일치하는 회원의 닉네임 조회
function selectNickname(email){
    
    fetch("/selectNickname?email="+ email) 
        // 지정된 주소로 GET방식 비동기 요청(ajax)
        // 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가

    .then(response => response.text()) // 요청에 대한 응답 객체(response)를 필요한 형태로 파싱
           //promise객체      //.text() 문자열 형태로 변환
    .then(nickname => {console.log(nickname)}) // 첫 번째 then에서 파싱한 데이터를 이용한 동작 작성

    .catch(e => {console.log(e)}) // 예외 발생시 처리할 내용을 작성

}


// 닉네임이 일치하는 회원의 전화번호 조회
const inputNickname = document.getElementById("inputNickname");
const btn1 = document.getElementById("btn1");
const result1 = document.getElementById("result1");

btn1.addEventListener("click", ()=>{
    
    // fetch()API를 이용해서 Ajax(비동기 통신)

    //GET방식요청(파라미터를 쿼리스트링으로 추가)
    fetch("/selectMemberTel?nickname="+inputNickname.value)
    .then( resp => resp.text() )
    // resp : 응답객체
    // resp : 응답객체의 내용을 문자열로 변환하여 반환
    
    .then( tel => {
        /* 비동기 요청 후 수행할 코드 */
        result1.innerText = tel; // 조회결과를 result1에 출력
    })
    //tel : 파싱되어 반환된 값이 저장된 변수

    .catch( err => console.log(err));
    // 에러 발생 시 콘솔에 출력 


})
