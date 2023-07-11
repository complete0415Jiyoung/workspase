//Node 확인하기
document.getElementById("btn1").addEventListener("click",function(){


    //#test의 자식 노드 모두 얻어오기
    //요소.childNodes :요소의 자식 노드를 모두 반환
   const nodeList = document.getElementById("test").childNodes;
   console.log(nodeList);


   //Node 탐색

   //1) 부모 노드 탐색 :parentNode
   const li1 = document.getElementById("li1");
   console.log(li1.parentNode);//ul#test

   //부모 노드의 배경색 변경
   li1.parentNode.style.backgroundColor = "pink";

   //부모 노드 마지막에 새로운 노드 추가(append : (마지막에)덧붙이다)
   li1.parentNode.append("ABCD");

   //2) 첫번째 자식 느드 탐색 :first child
   console.log(document.getElementById("test").firstChild);

   //3) 마지막 자식 노드 탐색 : last child
   console.log(document.getElementById("test").lastChild); //추가된 ABCD

   //4) 중간에 존재하는 자식 노드 탐색 : 부모 요소.childNodes[인덱스]
   console.log(nodeList[11]);
   nodeList[11].append("1234");

   //5) 이전 형제 노드 탐색 : previousSibaing
   //   다음 형제 노드 : nextSibing

   console.log(nodeList[8].previousSibling);
   console.log(nodeList[8].nextSibling);

   //노드 탐색을 위한 구문은 연달아서 사용 가능
   console.log(nodeList[8].previousSibling.previousSibling.previousSibling);

})
//Element 탐색 확인하기
document.getElementById("btn2").addEventListener("click", function(){
    
    //#test의 모든 자식요소 반환

    const list= document.getElementById("test").children;
    console.log(list);

    //#test인 요소의 첫번째 자식요소의 배경색 바꾸기
    document.getElementById("test").firstElementChild.style.backgroundColor="red";
    
    //#test인 요소의 마지막 자식요소의 배경색 바꾸기
    document.getElementById("test").lastElementChild.style.backgroundColor="yellowgreen";
    
    //#test의 자식 중(list) 2번 인덱스의 이전/다음 형제
    list[2].previousElementSibling.addEventListener("click",function(){
        alert("2번 인덱스의 이전 형제요소 클릭됨");

    })
    list[2].nextElementSibling.addEventListener("click",function(){
        alert("2번 인덱스의 다음 형제요소 클릭됨")
    })

    console.log(prevEl(list[2])); //1번 인덱스 
    console.log(prevEl(prevEl(list[2]))); //3번 인덱스 
    console.log(nextvEl(list[2])); //1번 인덱스 




})

//이전 형제 요소를 선택하는 함수 만들기
function prevEl(el){
    return el.previousElementSibling;
}
//다음 형제 요소를 선택하는 함수 만들기
function nextvEl(el){
    return el.nextElementSibling;
}


// let count2 =1; 

// //createElement 버튼 클릭시 
// document.getElementById("btn3-2").addEventListener("click", function(){
//     const div = document.getElementById("div3-2");//#div3-2선택

//     ///creatEelement이용해서 div 요소 생성
    
//     // document.createElement("태그명"): 해당 태그 요소를 생성하여 반환
//     const child= document.createElement("div");//div 생성O, 화면 배치 X

//     //만들어진 div(child)에 내용 추가
//     if(count2 <= 10){
//         child.innerText= count2;
//         count2++;
//     }
 
//     //div3-2의 마지막 요소로 추가하기(append)
//     div.append(child);

// })

let count2 = 1;
document.getElementById("btn3-2").addEventListener("click",function(){
    const div = document.getElementById("div3-2");

    const child = document.createElement("div");
    if(count2 <= 10){
        child.innerText =count2; 
        count2++;
    }
    div.append(child);
})


let count1=1;
//innerHTML버튼 클릭시 
document.getElementById("btn3-1").addEventListener("click",function(){


    const div = document.getElementById("div3-1");//#div3-1선택
   
    if(count1<=10){
        //누적
        div.innerHTML +="<div>"+count1+"</div>";
        count1++;

    }

})

document.getElementById("temp").addEventListener("click",function(){
    alert("temp");
})
