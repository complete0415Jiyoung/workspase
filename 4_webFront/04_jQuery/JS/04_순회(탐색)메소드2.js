$(document).ready(function(){
    //id가 test 인 요소의 태두리를 2px 빨간 실선, 글자색 파란색
    //$("#test").css("border","2px solid red").css("color", "blue");

    //자바 스크립트 객체를 매개 변수로 전달하는 방법
    $("#test").css({border : "2px solid red", "color":"blue"});
    //key 에 ""안해도 String 
})

//css()매게변수로 사용할 코드 미리 변수에 저장
const style1={"border" : "2px solid red", "color":"red"};
const style2={"border" : "2px solid orange", "color":"orange"};
const style3={"border" : "2px solid yellow", "color":"yellow"};
const style4={"border" : "2px solid green", "color":"green"};
const style5={"border" : "2px solid blue", "color":"blue"};

$(function(){
    $("#test").css(style5);
})

// ----------------------------------------------------------------------------------------
//children(): 선택된 요소의 바로 하위 요소(자식)를 선택하는 메소드
//클래스가 wrap인 요소의 자식 스타일을 styly1로 설정
$(".wrap").children().css(style1);

//ul,p태그의 스타일을 style2로 설정
//$(".type").children().css(style2);
$(".wrap").children().children().css(style2);


//children("메개변수(css선택자)")
//선택된 자식 요소 중"선택자"와 일치하는 자식만 선택
//클래스가 type인 요소의 자식 중 ul태그의 스타일을 style3로 설정
$(".type").find("ul").css(style3);

//클래스가 wrap인 요소를 기준으로 li 태그의 스타일을  s4로 지정
//$(".wrap").find("li").css(style4);
$(".wrap").children(".type").children("ul").children("li").css(style4);


//find (매개 변수 (css선택자)"")
//선택된 요소의 후손 중 매개 변수로 작성된 선택자와 
//일치하는 모든 요소를 선택

//클래스가 wrap인 요소의 후손 중 모든 span 태그의 스타일을 s5로 설정
$(".wrap").find("span").css(style5);

