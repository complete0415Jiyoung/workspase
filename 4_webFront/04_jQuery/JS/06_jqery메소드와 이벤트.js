//html()버튼
$("#btn1").on("click",function(){

    //아이디가 area인 요소의 내용을 모두 삭제 
    $("#area").html("");

    //아이디가 area인 요소의 내용을 모두 출력(태그인식O)
    $("#area").html("<p class=cls1>html() 작성된 내용</p>");

})

//text()버튼
$("#btn2").on("click",function(){
     //아이디가 area인 요소의 내용을 모두 삭제 
     $("#area").text("");

     //아이디가 area인 요소의 내용을 모두 출력(태그인식x)
     $("#area").text("<p class=cls1>text() 작성된 내용</p>");
 
})

//val()버튼
$("#btn3").on("click",function(){
    //아이디가 inputId인 요소의 값 삭제
    $("#inputId").val("");

    //아이디가 inputId인 요소에 값 대입
    $("#inputId").val("banana");
})

$(document).ready(function(){
    let count=1;

    //append():마지막 자식요소로 추가
    $("#list2").append("<li>리스트 "+count++ +"</li>");
    $("#list2").append("<li>리스트 "+count++ +"</li>");
    $("#list2").append("<li>리스트 "+count++ +"</li>");

    //prepend():첫번째 자식요소로 추가
    $("#list2").prepend("<li>리스트 "+count++ +"</li>");
    $("#list2").prepend("<li>리스트 "+count++ +"</li>");
    $("#list2").prepend("<li>리스트 "+count++ +"</li>");

    for(let i=0; i<3; i++){
        const el= "<p>새로 추가된 요소"+i+"</p>";

        //before(): 바로 이전 형제 요소 추가 
        //after(): 바로 다음 형제 요소 추가 
        $("#list2").before(el);
        $("#list2").after(el);
    }

    
})

//empty()버튼
$("#btn2-1").on("click",function(){
    //empty() :자식요소들을 모두 제거하는 메소드 
    //특정 요소 내부를 비움
    
    //id area3인 요소의 내부를 비움
    $("#area3").empty();
})

//id div3인 요소에 마우스가 들어갔다 나갔다 할때 의 동작
//$("#div3").hover(function(){},function(){})
                //들어왔을 때, 나갔을 때 
$("#div3").hover(function(){
    console.log($("#div3"))
    
    //마우스가 들어왔을 때 현재 요소에 lime 클래스 추가 
    
    //$("#div3").addClass("lime");
    $(this).addClass("lime");
} , function(){
    
    //마우스가 나갔을 때 현재 요소에 lime 클래스 제거
    $("#div3").removeClass("lime"); 

    
});

//romove()버튼 
$("#btn2-2").on("click", function(){
    //remove(): 요소 잘라내기 , 관련이벤트 삭제
    const el = $("#div3").remove();
    console.log(el);

    $("#area4").append(el);
})
// 확인 필요

//detach() 버튼
$("#btn2-3").on("click",function(){
    //detech():요소 잘라내기 관련 이벤트 잘라내기
    const el = $("#div3").detach();
    $("#area4").append(el);
})


