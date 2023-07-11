//태그 선택자

//ready()함수 : 문서가 로딩 된 후 마지막에 수행하는 함수
$(document).ready(function(){

    //jQuery의 선택자는 css선택자와 같다!
    $("h5").css("color", "red");
    
    $("p").css("color","blue");

    //자바스크립트로 했을 때
    //document.getElementsByTagName("p").style.color="blue";
    //배열의 style을 적용할수 없다

    const arr= document.getElementsByTagName("p");

    for(let item of arr){
        item.style.color="yellow";
    }

    //-> 배열에서 요소를 하나씩 꺼내서 적용하는 것은 가능 하나 불편하다.

    //h5, p동시에 배경색을 green으로 지정하기
    $("h5,p").css("backgroundColor","green");
})

//클래스 선택자

$(document).ready(function(){
    //클래스가 item인 요소의 글자 색을 orange로 변경
    $(".item").css("color","orange");

    //클래스가 select인 요소의 배경색을 yellowgreen으로 변경
    $(".select").css("backgroundColor", "yellowgreen")

    //클래스가 item select 를 동시에 가지고 잇는 요소만
    //글자 크기 50px로 변경
    $(".item.select").css("fontSize","50px");

})
//아이디 선택자
const regExp=/^[a-z][a-zA-Z0-9]{7,19}$/;
$("#input1").on("input", function(){
    //on() == addEventLister
    //특정이벤트 발생시 동작(이벤트 핸들러) 지정

    //input 이벤트: 입력과 관련된 모든 행위

    //1)작성된 값이 정규  표현식 맞는 형식 인지 검사
    if( regExp.test($("#input1").val()) ){
        //$
        //아이디가 input1인 요소에 작성된 값 얻어오기

        //2)정규식 결과에 따라 내용 출력
        $("#span1").text("유효한 문자열 형식입니다");
        $("#span1").css("color", "green");
    }else{

        $("#span1").text("유효하지 않는 문자열입니다.").css("color", "red");
        //mothod chaining:하나에 대상에 대하여 여러 메소드를 연달아 작성하는 기술 
    }

})
//자식 후손 선택자

//재일 간단한 형태의 ready()함수
$(function(){
    //클래스가 area인 요소 자식 중에서 h4글자색 red
    $(".area>h4").css("color","red");
    
    //클래스가 area인 요소 후손 중에서 ul후손
    //클래스가 qqq인 요소의 배경색 원하는 색
    $(".area>ul>.qqq").css("backgroundColor","pink");
    
    //클래스가 area인 요소 후손 중에서 
    //클래스가 qqq인 요소의 폰트크기를 30px로 변경
    $(".area .qqq").css("fontSize","30px");

    //내용이 사과인 요소를 선택해서 
    //배경 빨간색 글자 흰색
    $(".area li > h4").css("backgroundColor","red").css("color","white");


})

//속성 선택자
$("#check").on("click",function(){

    //name 속성이 gender인 요소 선택 
    console.log($("input[name='gender']") );

    //name 속성 값이 gender인 요소 중에ㅐ서 check된 요소
    //:checked -> ckeck된 요소만 선택
    const gender = $("input[name='gender']:checked");

    console.log(gender.length);
    //아무것도 check안함 : 0
    //하나 check : 1

    // 변수 gender눈 Javascript방식의 변수이다
    //-> 이후 gender을 단순하게 호출하게 되면 
    // Javascript방식으로 사용해야한다



    //radio 버튼이 하나도 선택되지 않은 경우
    //"남자 또는 여자를 선택해 주세요 " 알림창 출력"

    if(gender.length==0){
        alert("남자 또는 여자를 선택해 주세요");
    }else{

        // 1) 체크된 요스를 모두 얻어 왔으므로
        //   배열 형태로 저장된 gender 변수에서 
        //   0번 인덱스의 value만 얻어오기(순수 JS)
        console.log(gender[0].value);

        // 2) 체크된 요소를 모두 얻어와도 rodio는 한개만 체크 되어ㅣㅇㅆ기 때문에
        //변수 한개와 같다고 해석해서 
        //자동으로 -번 인덱스 요소에 있는 valuse를 얻어옴 (JS+ jQuery)
        console.log(gender.val()); 

        //3) 순수 jQuery 
        console.log($(gender).val());
        //$(gender): 체크된 요소만 담긴 배열 +요소를 선택해라 기호
        //-> 체크된 radio버튼을 선택하는 jQuery 선택자

        alert($(gender).val()+" 자를 선택하셨습니다.")


    }

})

//prop() 메소드
$("#btn1").on("click",function(){
    const arr = $("input[name='hobby']");

    let str =""; //체크된 요소의; value값을 누적해서 저장할 변수 

    console.log( arr.prop("checked") );
    //배열명을 적을 경우 0번 인덱스만 확인 가능

    for(let i=0; i<arr.length; i++){
        //각 인덱스에 저장된 checkBox 요소가 체크 되어 잇는 지 확인

        console.log(i+" : "+$(arr[i]).prop("checked") );

        if($(arr[i]).prop("checked")){
            //체크된 요소의 value값을 얻어와서 str변수에 누적 
            str += $(arr[i]).val()+" ";
        }
    }
    alert(str);
})



