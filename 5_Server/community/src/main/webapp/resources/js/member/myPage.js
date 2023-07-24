//내 정보 수정 유효성 검사 
console.log("myPage.js loaded.");


function myInfoValidate(){
    const memberNickname = document.getElementsByName("memberNickname");
    const memberTel = document.getElementsByName("memberTel");
    
    const regExp1 =/^[A-Za-z0-9가-힣]{2,10}$/;

    // 전화번호
    // 010 011 016 017 019
    // 02 031 032 041 051 052
    // 070

    //010 123 1234
    //010 1234 1234

    const regExp2 =/^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

   // 닉네임 미작성 시 : 닉네임을 입력해주세요.
   if(memberNickname[0].value.trim().length == 0){
        alert("닉네임을 입력해주세요");
        memberNickname[0].focus(); 
        return false;
   }
   
   // 닉네임 유효성검사
   if(!regExp1.test(memberNickname[0].value)){
        alert("닉네임 영어/ 숫자/한글 2~10글자를 입력하세요");
        memberNickname[0].focus(); 
        return false;
    }
    // 전화번호 미작성 시 : "전화번호를 입력해주세요(-제외)"
    if(memberTel[0].value.trim().length == 0){
        alert("전화번호를 입력해주세요(-제외");
        memberTel[0].focus(); 
        return false;
    }
   // 전화번호 유효성검사 
   if(!regExp2.test(memberTel[0].value)){
        // alert("전화번호 형식이 올바르지 않습니다");
        // memberTel[0].focus(); 
        // return false;

        return printAlert(memberTel[0],"전화번호 형식이 올바르지 않습니다.");
    }

    return true;//ture 를 반환해서 제출
   
}

//경고 출력 + 포커스 + false 반환 함수 
function printAlert(el,message){ // 매개변수 el은 요소
    alert(message);
    el.focus();
    return false;
}


// 비밀번호 제출시 유효성검사
function changePwValidate(){
    const currentPw = document.getElementsByName("currentPw");
    const newPw = document.getElementsByName("newPw");
    const newPwconfirm = document.getElementsByName("newPwconfirm");
    
    const regExp3 = /^[a-zA-z0-9!@#\-_]{6,30}$/;
    //const regExp3 = /^[\w!@#_-]{6,30}$/;

    // 미작성시
    if(currentPw[0].value.trim().length==0){
        return printAlert(currentPw[0], "현재 비밀번호를 입력해주세요");
    }
    if(newPw[0].value.trim().length==0){
        return printAlert(newPw[0], "새 비밀번호를 입력해주세요");
    }
    if(newPwconfirm[0].value.trim().length==0){
        return printAlert(newPwconfirm[0], "새 비밀번호 확인을 입력해주세요");
    }
    // 새 비밀번호 유효성
    if(!regExp3.test(newPw[0].value)){
        return printAlert(newPw[0], "영어, 숫자,특수문자(!,@,#,-,_)6~30사이로 작성해주세요");

    }

    //새 비밀번호와 새 비밀번호 확인이 일치 하지 않는 경우
    if(newPw[0].value != newPwconfirm[0].value){
        return printAlert(newPwconfirm[0], "새 비밀번호가 일치하지 않습니다");
    }

    return true;
}

//회원 탈퇴 유효성 검사
function secessionValidate(){

    const memberPw = document.getElementsByName("memberPw");
    const agree =document.getElementById("agree");
    
    //비밀번호 미작성시 
    if(memberPw[0].value.trim().length==0){
        return printAlert(memberPw[0], "비밀번호를 입력해주세요");
    }
    //약관 동의 체크 여부 
    // - 체크 박스요소.checked :체크시 ture, 해제시 false 반환  
    if(!agree.checked){
        return printAlert(agree, "약관 동의 후 탈퇴 버튼을 클릭해주세요");
    }
    //정말 탈퇴 할 지 확인
    // [window.]confirm("내용") : 대화 상자에 확인 / 취소 생성
    //          -> 확인 클릭 시 ture / 취소 클릭 시 false

    if(!confirm("정말 탈퇴하시겠습니까?")){
        return false;
    }

    return true;
}

// document.getElementById("agree").addEventListener("change",function(){
    
//     if(this.checked){
//         const str ="정말 탈퇴하시겠습니까?"

//         if(!confirm(str)){ // 취소를 눌렀을 때 
//               // 체크 해제
//             this.checked = false;
//         }
//     }
// })


// 회원프로필 이미지 변경 (미리 보기)
const inputImage = document.getElementById("input-image");
if(inputImage != null){ //즉 inputIamge요소가 화면에 존재할 때
    
    // input type="file"요소는 파일이 선택 될 때 change이벤트가 발생한다 
    inputImage.addEventListener("change", function(){
        
        // this : 이벤트가 발생한 요소 (input type= "file")
        // files : input type = "file"만  가능한 속서으로 
        // 선택된 파일 목록*배열)을 반환
        //console.log(this.files);
        //console.log(this.files[0]);//파일 목록에서 첫번째 파일 객체를 선택
        
        if(this.files[0] != undefined){ //파일이 선택 되었을 때
            const reader = new FileReader();
            // 자바스크립의 FileReader 
            // - 웹 어플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체

            reader.readAsDataURL(this.files[0]);
            //FileReader.readDataURL(파일)
            // 지정된 파일의 내용를 읽기 시작함 
            // 읽어오는게 완료되면 result속성의 data에 
            // 읽어온 파일의 위치를 나타내는 URL이 포함된다
            //  -> 해당 URL을 이용해서 브라우저의 이미지를 볼수 있다.

            // FileReader.onload = function(){}
            // FileReader가 파일을 다 읽어 온 경우 함수 수행
            reader.onload=function(e){
                // e : 이벤트 발생 객체
                // e.targer : 이벤트가 발생한 요소(객체) -> FileReader
                // e.target.result : FileReader가 읽어온 파일을 URL

                //프로필 이미지에 src 속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profile-image");

                profileImage.setAttribute("src", e.target.result);
                // -> setAtturibute()호출시 중복되는 속성이 존재하면 덮어쓰기 

            }

        } 
    })
}





