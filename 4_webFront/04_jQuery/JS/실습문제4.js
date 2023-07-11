
const hobbyList= document.getElementsByName("hobby");
const box = document.querySelector(".box");

const selectAll = document.getElementById("select-all");

for(let i =1; i < hobbyList.length; i++){
hobbyList[i].addEventListener("change",function(){
    let check;
    
    for(let i =1; i < hobbyList.length; i++){
       
        check="";
       
        if(hobbyList[i].checked ==false){
            check=false;
            break;
        }else if(hobbyList[i].checked ==true){
            check=true;
        }
    }
    
    selectAll.checked=check
    
    })
}

selectAll.addEventListener("change",function(){
    let check;

    if(this.checked){
        check=true;

    }else{
        check=false;
    }
    
    for (let i of hobbyList) {
        i.checked = check;
    }

});




box.innerHTML="";
document.getElementById("btn").addEventListener("click",function(){
    
    let str="";
    
    for(let i=1; i<hobbyList.length; i++){
        if(hobbyList[i].checked){
            str += hobbyList[i].value +" ";
        }
        
        box.innerHTML=str;
    }

})

