// 미리보기 관련요소 모두 얻어오기

const inputImage = document.getElementsByClassName("inputImage");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-image");

// 게시글 수정시 삭제된 이미지의 레벨(위치)를 저장할 INPUT요소
const deleteList = document.getElementById("deleteList");

// 게시글 수정시 삭제된 이미지의 레벨의(위치)를 기록해둘 Set생성
const deleteSet = new Set(); // 순서없고 중복도 안됨 (여러번 클릭시 중복값 저장을 방지)


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

                // d이미지가 성공적으로 잘 불러와졌을 때
                //deleteSet에서 해당 레벨을 제거(삭제목록에서 제외)
                deleteSet.delete(i);

            }
        }else{ //파일이 선택되지 않았을 때(취소)
            preview[i].removeAttribute("src");//src속성 제거

        }
    });
    // 미리보기 삭제 버튼(X) 클릭되었을 때
    deleteImage[i].addEventListener("click",function(){

        //미리보기가 존재하는 경우에만 (이전에 추가된 이미지가 있을 때만) x버튼 동작
        if(preview[i].getAttribute("src") !=""){

            //미리보기 삭제
            preview[i].removeAttribute("src");
    
            //input의 값을 ""만들기
            inputImage[i].value="";
     
            //deleteSet에 삭제된 이미지 레벨(i) 추가
            deleteSet.add(i);
        }
 
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
    // 제목, 내용이 유효한 경우 
    // deleteList(input태그)에 deleteSet(삭제된 이미지 레벨)을 추가
    // -> js 배열의 특징을 사용해서 
    // --> JS 배열을 HTML요소 또는 console에 출력되응 경우 1,2,3 같은 문자열로만 출력 됨
    // (배열 기호가 벗겨짐)

    //*Set -> Array로 변경 -> deleteList.value에 대입

    // Array.from(유사배열 | 컬렉션): 배열로 변환해서 반환
    
    deleteList.value = Array.from(deleteSet) ;
    
    
    return true;
}