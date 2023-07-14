/*signUp.js*/ 

// 유효성 검사여부를 기록할 객체를 생성 
const checkObj = {
    "memberEmail"       :  false,
    "memberPw"          :  false,
    "memberPwConfirm"   :  false,
    "memberNickname"    :  false,
    "memberTel"         :  false
};



//전화번호 유효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

// *** input 이벤트 ***
// -> 입력과 관련된 모든 동작 (key관련 mouse관련, 붙여넣기)
memberTel.addEventListener("input",function(){

    // 입력이 되지 않은 경우
    if(memberTel.value.trim().length==0){
        telMessage.innerText="전화번호를 입력해주세요(-제외)"
        // telMessage.classList.remove("error");
        // telMessage.classList.remove("comfirm");
        telMessage.classList.remove("confirm", "error");

        checkObj.memberTel = false; // 유효하지 않은 상태임을 기록
        return;
    }

    // 전화번호 정규식
    const regExp =/^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
    
    if(regExp.test(memberTel.value)){ //유효한 경우
        telMessage.innerText="유효한 전화번호 형식입니다."
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");

        checkObj.memberTel = true;
    
    }else{ // 유효하지 않은 경우
        telMessage.innerText="전화번호 형식이 올바르지 않습니다."
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");
    
        checkObj.memberTel = false; 
    }

});


// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.querySelector("#emailMessage");

memberEmail.addEventListener("input", function(){
    
    //입력이 되지 않은 경우
    if(memberEmail.value.trim().length==0){
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";
        emailMessage.classList.remove("confirm", "error");
    
        checkObj.memberEmail = false; 
        return;
    }

    // 입력된 경우 
    // const regExp =/^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;
    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if(regExp.test(memberEmail.value)){ //유효한 경우 
    

        //************이메일 중복 검사 (ajax) 진행 예정************* */

        // $.ajax( {k:V , K:V}); //JQuery ajax의 기본 형태


        // 입력된 이메일 == memberEmail.value
        $.ajax({
            url : "emailDupCheck", 
            // 필수 속성 url
            // 현재 주소 : /community/member/signUp
            // 절대 경로 : /community/member/emailDupCheck
            // 상대 경로 : emailDupCheck

            data : { "memberEmail" : memberEmail.value },
            // data 속성 : 비동기 통신시 서버로 전달할 값 작성(JS 객체 형식)
            // -> 비동기 통신 시 input 에 입력된 값을 
            //    "memberEmail"이라는 key 값(파라미터)으로 전달

            type : "GET", // 데이터 전달 방식 type

            success : function(result){
                // 비동기 통신 (ajax)가 오류없이 요청/ 응답 성공한 경우

                //매개변수 result : servlet 에서 출력된 result값이 담겨 잇음
                if(result == 1){ //중복 O
                    emailMessage.innerText="이미 사용 중인 이메일입니다.."
                    emailMessage.classList.add("error");
                    emailMessage.classList.remove("confirm");
             
                    checkObj.memberEmail = false; 
                    
                }else{//중복 X
                    emailMessage.innerText="사용 가능한 이메일입니다."
                    emailMessage.classList.add("confirm");
                    emailMessage.classList.remove("error");
                    
                    checkObj.memberEmail = true; 
            
                }
            },

            error : function(){
                //비동기 통신(ajax) 중 오류가 발생한 경우 
                console.log("에러발생");
            }
        })

    }else{ //유효하지 않은 경우
        emailMessage.innerText=" 유효하지 않은 형식입니다."
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");

        checkObj.memberEmail = false; 

    }
})

//닉네임 유효성 검사 
const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input", function(){

    //입력되지 않은 경우 
    if(memberNickname.value.trim().length==0){
        nicknameMessage.innerText = "영어 숫자 한글 2~10글자 사이로 작성해주세요"
        nicknameMessage.classList.remove("confirm", "error");
        
        checkObj.memberNickname = false; //유효기록 X
        return;
    }


    const regExp=/^([A-Za-z가-힣]|[0-9]){2,10}$/
    if(regExp.test(memberNickname.value)){
        

        /****************닉네임 중복검사(ajax)진행예정***************/ 
        $.ajax({
            url  : "nicknameDupCheck", // 필수 작성 속성
            data : {"memberNickname": memberNickname.value}, //서버로 전달 할 값 파라미터
            type : "GET",//데이터 전달 방식(기본값GET)
            success:function(res){//비동기 통신이 성공했을 때
               // 매개변수 res = Servlet 에서 응답으로 출력된 데이터 전달 
                if(res == 0){ //중복 X
                    nicknameMessage.innerText="사용가능한 닉네임 입니다."
                    nicknameMessage.classList.add("confirm");
                    nicknameMessage.classList.remove("error");
        
                     checkObj.memberNickname = true; //유효기록 O

                    
                }else{//중복 O
                  
                    nicknameMessage.innerText="이미 사용 중인 닉네임입니다.."
                    nicknameMessage.classList.add("error");
                    nicknameMessage.classList.remove("confirm");
             
                    checkObj.memberNickname = false;
            
                }
            },
            
            error: function(){ //비동기 통신 시 에러 발생
                console.log("에러 발생");
            }
        })


    }else{
        nicknameMessage.innerText="유효하지 않은 닉네임입니다."
        nicknameMessage.classList.add("error");
        nicknameMessage.classList.remove("confirm");

        checkObj.memberNickname = false; //유효기록 X
    }

})

// 비밀번호 유효성 검사 
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage= document.getElementById("pwMessage");

memberPw.addEventListener("input",function(){

    // 입력 되지 않은 경우 
    if(memberPw.value.trim().length==0){
        pwMessage.innerText = "영어, 숫자,특수문자(!,@,#,-,_) 6~30글자 입력해주세요"
        pwMessage.classList.remove("confirm", "error");

        checkObj.memberPw = false; //유효기록 X
        
    }

    const regExp = /^[\w!@#_-]{6,30}$/
    if(regExp.test(memberPw.value)){ //비밀번호가 유효한 경우
        
        checkObj.memberPw = true; //유효기록 O

        if(memberPwConfirm.value.trim().length ==0){ // 비밀번호 유효 , 확인 작성
            pwMessage.innerText="유효한 비밀번호입니다.";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        
            
            
        }else{ // 비밀번호 유효 , 확인 작성O
            checkPw(); //비밀번호 일치 검사 함수 호출()
        }

        
        

    }else{
        pwMessage.innerText="유효하지 않은 비밀번호입니다."
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPw = false; //유효기록 X
    }


})


// 비밀번호 확인 유효성 검사

// 함수명() : 함수 호출(수행)
// 함수명   : 함수에 작성된 코드 반환
memberPwConfirm.addEventListener("input", checkPw);
// -> 이벤트가 발생되었을 때 정의된 함수를 호출하겠다.

function checkPw(){ //비밀번호 일치 검사

    //비밀번호 확인/ 비밀번호가 같을 경우
    if(memberPw.value == memberPwConfirm.value){
        pwMessage.innerText="비밀번호가 일치합니다.";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

        checkObj.memberPwConfirm = true; //유효기록 o
    } else {
        pwMessage.innerText="비밀번호가 일치하지않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        
        checkObj.memberPwConfirm = false; //유효기록 X
    }
}   

//회원가입 버튼 클릭시 유효성 검사가 완료 되었는 지 확인하는 함수
function signValidate(){

    
    // checkObj에 있는 모든 속성을 반복접근하여
    // false가 하나라도 있는 경우 form 태그 기본 이벤트 제거

     let str;



    for( let key in checkObj){ //객체용 향상된 for문

        
        if ( !checkObj[key] ){
            switch(key){
                case"memberEmail" : str="이메일"; break;
                case"memberPw" : str="비번"; break;
                case"memberPwConfirm" : str="비번확인"; break;
                case"memberNickname" : str="닉네임"; break;
                case"memberTel" : str="전화번호"; break;

            }

        // 현재 접근중인 key 의 value 가 false인 경우

            alert(str);
            document.getElementById(key).focus()
            return false; //form 태그 기본 이벤트 제거
        }

    }

    return true;

}