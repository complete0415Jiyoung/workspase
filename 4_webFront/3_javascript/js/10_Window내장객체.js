//window.setTimeout(함수,지연시간(ms))
document.getElementById("btn1").addEventListener("click", function(){

    setTimeout(function(){
        alert("3초 후 출력 확인")
    }, 3000 );

})

//
let Interval; //setInterval를 저장하기 위한 전역변수





//window.setInterval(함수, 지연시간(ms))
function clockFn(){
    const clock = document.getElementById("clock");
    clock.innerHTML = currentTime();//현재 시간 화면 출력


    //지연 시간 마다 반복한다(첫반복도 지연시간 후에 시작)
    //-> 페이지가 로딩 된 후 1초 후 부터 반복(지연-> 함수->지연->함수)
    Interval= setInterval(function(){
        clock.innerHTML= currentTime();
    },1000);



}
//현재 시간 분자열로 반환 하는 함수
function currentTime(){
    const now = new Date();

    let hours =now.getHours();
    let min =now.getMinutes();
    let sec =now.getSeconds();

    if(hours <10)hours="0"+hours;
    if(min <10)min="0"+min;
    if(sec <10)sec="0"+sec;


    return hours+" : "+ min+" : "+sec; 
}


clockFn();// 함수 호출

//clearInterval
document.getElementById("stop").addEventListener("click", function(){
    clearInterval(Interval);

})