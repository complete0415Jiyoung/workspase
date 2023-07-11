var str = "JS 코드를 함수 내부가 아닌 "
        + "JS 파일 또는 script 태그 밑에 바로 작성하면"
        + "HTML 렌더링 시 바로 수행된다"
console.log(str)

//변수 선언 위치에 따른 구분
var num1=10; //전역변수
num2=20; //전역변수

var num1 = 20;

console.log("num1 : " + num1);
console.log("num2 : " + num2);

function test(){
    var num3 =3; // function 지역 변수
    num4 = 4; // 전역 변수

    if(true){ // 무조건 if문 수행
    
        var num5 =5; // function 지역 변수
        num6 =6;     // 전역 변수
    }

    console.log("num5 : "+num5);
}

test();

// console.log("num3 : "+num3) //error
console.log("num4 : "+num4); //function 종료 후에도 사용 가능

// console.log("num5 : " + num5); //error
console.log("num6 : " + num6); //function 내부 if문 종료 후에도 사용 가능


//자료형 확인
function typeTest(){
    const typeBox = document.getElementById("typeBox");

    let temp; //선언 후 값을 초기화 하지 않음 == undefined
    typeBox.innerHTML = "temp : "+temp;

    //string
    const name="박보검";

    //typeof 변수명 : 해당 변수의 자료형을 검사하는 연산자
    typeBox.innerHTML += "<br>name : "+name+" / "+ typeof name;

    const gender = 'm';
    typeBox.innerHTML += "<br>gerder : "+gender + " / "+ typeof gender
    //자바 스크립스는 char 자료형이 존재하지 않음!
    //"",'' 모두 string 리터럴 표기법

    //number
    const age = 20;
    const height = 180.3;

    typeBox.innerHTML += "<br>age : "+age + " / "+ typeof age
    typeBox.innerHTML += "<br>height : "+height + " / "+ typeof height


    //boolean 
    const isTrue=true;
    typeBox.innerHTML += "<br>isTrue : "+isTrue + " / "+ typeof isTrue


    //object

    //java({}사용)
    //int[] arr = {1,2,3,4,5};

    //javascript([]사용)
    const arr= [10,20,30,40,50];
    typeBox.innerHTML += "<br>arr : "+arr + " / "+ typeof arr;

    for(let i=0; i<arr.length; i++){
        typeBox.innerHTML += "<br> arr["+i+"]: "+ arr[i];
    }


    //자바스크립트 객체는 k:v(map형식)
    const user = {"id" :"user01", "pw" : "pass01"};
    typeBox.innerHTML += "<br>user: "+ user+" / "+ typeof user;


    //객체 내용 출력 방법 1
    typeBox.innerHTML += "<br>user.id : "+ user.id;
    typeBox.innerHTML += "<br>user.pw : "+ user.pw;

    //객체 내용 출력 방법 2 (객체 전용 for문 for... in)
    for(let key in user){
        //user 객채의 키(id, pw) 반복할 때마다 하나씩 key 변수에 저장
        typeBox.innerHTML += "<br>user["+ key + "] :"+ user[key];      
    }
    console.log(user);//콘솔 출력 시 보기가 더 좋음



    //function(함수도 자료형이다!)
    // 1) 변수명 == 함수명
    const sumFn= function(n1, n2){ //익명함수
        return n1+n2;
    }

    //함수명만 작성한 경우 -> 함수에 작성된 코드 자체 출력
    typeBox.innerHTML += "<br> sumFn :"+ sumFn +" / "+ typeof sumFn;
    
    //함수명에 ()포함해서 작성한 경우 -> 함수를 호출(수행)
    typeBox.innerHTML += "<br> sumFn(10,20) :"+ sumFn(10,20);
    
    typeBox.innerHTML += "<br> tempFn(30,sumFn) :"+ tempFn(30,sumFn);

}

function tepmFn(n3,fn){
    return n3 + fn(10,20);
}