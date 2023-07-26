// 미리보기 관련요소 모두 얻어오기

const inputImage = document.getElementsByClassName("inputImage");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-image");

for(let i=0; i<inputImage.length; i++){

    //파일이 선택 되었을 때
    inputImage[i].addEventListener("change", function(){
        if(this.files[0] != undefined){ // 파일이 선택되었을 때
            const reader = new FileReader(); //선택될 파일을 읽을 객체 생성
            reader.readAsDataURL(this.files[0])
            // 지정된 파일을 읽음 -> result에 저장(url포함)-> URL을 이용해서 이미지 볼수 있음

            reader.onload= function(e){ //reader가 파일을 다 읽어온 경우
                // e.target == reader
                // e.target.result ==읽어들인 이미지의 URL
                // preview[i] == 파일이 선택된 input태그와 인접한 preview 이미지 태그
                preview[i].setAttribute("src", e.target.result);
            }
        }else{ //파일이 선택되지 않았을 때(취소)
            preview[i].removeAttribute("src");//src속성 제거

        }
    });
    // 미리보기 삭제 버튼(X) 클릭되었을 때
    deleteImage[i].addEventListener("click",function(){

        //미리보기 삭제
        preview[i].removeAttribute("src");

        //input의 값을 ""만들기
        inputImage[i].value="";
    });
}
// 게시글 작성 유효성 검사
function writeValidate(){
    const boardTitle = document.getElementsByName("boardTitle")[0];
    const boardContent = document.querySelector("[name='boardContent']");

    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요!!!");
        boardTitle.value = "";
        boardTitle.focus();
        return false;
    }

    if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요!!!");
        boardContent.value = "";
        boardContent.focus();
        return false;
    }
    return true;
}